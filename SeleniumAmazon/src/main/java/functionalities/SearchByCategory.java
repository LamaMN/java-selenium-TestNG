package functionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchByCategory {

	// Locators for all the needed WebElements
	By categories = By.id("searchDropdownBox");
	By searchBar = By.id("twotabsearchtextbox");
	By submit = By.id("nav-search-submit-button");

	// WebElements to be written into or chosen from
	WebElement searchTxtField;
	WebElement chooseCategory;

	// This ArrayList will contain all the currencies
	public ArrayList<String> departments;

	WebDriver driver;
	WebDriverWait wait;
	String query;
	String category;

	public SearchByCategory(WebDriver driver) {

		this.driver = driver;

	}

	public void chooseCategory(String category) {

		if (category.equalsIgnoreCase("all")) {
			category = "aps";
		}

		this.category = category;

		// For the entered string to be like the file
		category = category.toLowerCase();

		// Navigate to Category
		chooseCategory = driver.findElement(categories);

		// Create Selector
		Select selectCategory = new Select(chooseCategory);

		departments = new ArrayList<String>();

		File f = new File("All Departments.txt");

		// Read from the file of all the categories and add them to the ArrayList
		try {
			Scanner scan = new Scanner(f);
			while (scan.hasNext()) {

				departments.add(scan.nextLine());

			}

			scan.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		for (String input : departments) {
			if (input.contains(category)) {

				// Select desired category
				selectCategory.selectByValue(input);
				System.out.println(selectCategory.getFirstSelectedOption().getText());

			}

		}

	}

	public void searchProduct(String query) {

		this.query = query;

		// Navigate to the search bar
		searchTxtField = driver.findElement(searchBar);

		// clear text field of any previous prompt
		searchTxtField.clear();

		// Typing in the input
		searchTxtField.sendKeys(query);

		// Navigate to the search button and click
		WebElement search = driver.findElement(submit);

		search.click();

	}

	public boolean validCategory(String expected) {

		if (expected.equalsIgnoreCase("all")) {

			return true;

		} else if (expected.equalsIgnoreCase("books")) {
			expected = "b";

		}
		// To match the actual value to be compared
		expected = expected.toLowerCase();
		expected = expected.replaceAll("\\s", "+");

		// Wait until the page after submission is loaded to check the new language
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submit)));

		String actual = driver.getCurrentUrl();
		System.out.println(driver.getTitle());
		return (actual.contains(expected));

	}

	public boolean validSearch(String expected) {

		expected = expected.replaceAll("\\s", "+");

		// Wait until the page after submission is loaded to check the new language
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(submit)));

		String actual = driver.getCurrentUrl();

		return (actual.contains(expected));

	}

}

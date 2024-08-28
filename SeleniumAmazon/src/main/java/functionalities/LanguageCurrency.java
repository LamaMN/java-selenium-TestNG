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

public class LanguageCurrency {

	// Locators for all the needed WebElements
	By changeLanguage = By.id("icp-nav-flyout");
	By english = By.xpath("//*[@id=\"icp-language-settings\"]/div[2]/div/label/i");
	By espanol = By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i");
	By arabic = By.xpath("//*[@id=\"icp-language-settings\"]/div[4]/div/label/i");
	By deutsch = By.xpath("//*[@id=\"icp-language-settings\"]/div[5]/div/label/i");
	By hebrew = By.xpath("//*[@id=\"icp-language-settings\"]/div[6]/div/label/i");
	By korean = By.xpath("//*[@id=\"icp-language-settings\"]/div[7]/div/label/i");
	By portuguese = By.xpath("//*[@id=\"icp-language-settings\"]/div[8]/div/label/i");
	By chineseSimplified = By.xpath("//*[@id=\"icp-language-settings\"]/div[9]/div/label/i");
	By chineseTraditional = By.xpath("//*[@id=\"icp-language-settings\"]/div[10]/div/label/i");
	By changeCurrency = By.id("icp-currency-dropdown");
	
	By submit = By.id("icp-save-button");

	// WebElements to be written into or chosen from
	WebElement chosen;
	WebElement chooseCurrency;
	Select currencySelector;

	// This ArrayList will contain all the currencies
	public ArrayList<String> currencies;

	WebDriver driver;
	WebDriverWait wait;
	String lang, curr;

	public LanguageCurrency(WebDriver driver) {

		this.driver = driver;

	}

	public void changeLanguage(String language) {

		// To search only by the first two characters in lower case
		lang = language.substring(0, 2);
		lang = lang.toLowerCase();

		// Navigate to the button for changing language and currency
		WebElement chooseLanguage = driver.findElement(changeLanguage);
		chooseLanguage.click();

		switch (lang) {

		case "en":

			chosen = driver.findElement(english);
			chosen.click();
			break;

		case "es":

			chosen = driver.findElement(espanol);
			chosen.click();
			break;

		case "ar":

			chosen = driver.findElement(arabic);
			chosen.click();
			break;

		case "de":

			chosen = driver.findElement(deutsch);
			chosen.click();
			break;

		case "he":

			chosen = driver.findElement(hebrew);
			chosen.click();
			break;

		case "ko":

			chosen = driver.findElement(korean);
			chosen.click();
			break;

		case "po":

			chosen = driver.findElement(portuguese);
			chosen.click();
			break;

		case "ch":

			chosen = driver.findElement(chineseSimplified);
			chosen.click();
			break;

		default:
			System.out.println("Invalid language input");
		}

	}

	public void submit() {

		// Navigate to submission button to save changes
		WebElement submitButton = driver.findElement(submit);
		
		submitButton.click();

	}

	public boolean isLanguageChanged(String expected) {

		if (expected.equalsIgnoreCase("portuguese")) {

			expected = "pt";

		} else if (expected.equalsIgnoreCase("chinese")) {

			expected = "zh";

		}

		// To match the actual value to be compared
		expected = expected.toLowerCase();
		expected = expected.substring(0, 2);

		// Wait until the page after submission is loaded to check the new language
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains("Amazon.com")));

		WebElement languageChecker = driver.findElement(By.xpath("/html"));

		// To get the language attribute for the web page
		String actual = languageChecker.getAttribute("lang");
		actual = actual.substring(0, 2);

		return (actual.equalsIgnoreCase(expected));

	}

	public void changeCurrency(String currency) {

		// To search only by the first three characters in upper case
		curr = currency.substring(0, 3);
		curr = currency.toUpperCase();

		// Navigate to the dropdown list of currencies
		chooseCurrency = driver.findElement(changeCurrency);

		// To choose from the dropdown list of currencies
		currencySelector = new Select(chooseCurrency);

		currencies = new ArrayList<String>();

		File f = new File("curr.txt");

		// Read from the file of all the currencies and add them to the ArrayList
		try {
			Scanner scan = new Scanner(f);
			while (scan.hasNext()) {

				currencies.add(scan.nextLine());

			}

			scan.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		// Select by the chosen currency

		for (String input : currencies) {
			if (input.contains(curr)) {

				currencySelector.selectByValue(curr);

			}

		}

	}

	public boolean isCurrencyChanged(String expected) {

		// Wait until the page after submission is loaded to check the new language
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Amazon.com"));

		// Check if the currency is changed by the url
		String actual = driver.getCurrentUrl();

		return (actual.contains(expected));

	}

}

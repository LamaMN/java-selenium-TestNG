package test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestListeners;
import functionalities.LanguageCurrency;
import functionalities.SearchByCategory;

public class AmazonTest extends TestListeners {

	public WebDriver chrome;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {

		// Set the desired driver property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		chrome = new ChromeDriver();

		// Load the web site
		chrome.get("https://www.amazon.com/");
		chrome.manage().window().maximize();

		// To avoid Captcha
		wait = new WebDriverWait(chrome, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("icp-nav-flyout")));

		// Checking if we launched the correct web site
		String title = chrome.getTitle();
		System.out.println(title);
	}

	@Test(priority = 1)
	public void testCase01() {

		String language = "English";
		String currency = "USD";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));

	}

	@Test(priority = 2)
	public void testCase02() {

		String language = "Espanola";
		String currency = "COP";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));
	}

	@Test(priority = 3)
	public void testCase03() {

		String language = "Arabic";
		String currency = "SAR";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));
	}

	@Test(priority = 4)
	public void testCase04() {

		String language = "Deutsch";
		String currency = "AED";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));
	}

	@Test(priority = 5)
	public void testCase05() {

		String language = "Hebrew";
		String currency = "AUD";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));
	}

	@Test(priority = 6)
	public void testCase06() {

		String language = "Korean";
		String currency = "KRW";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));
	}

	@Test(priority = 7)
	public void testCase07() {

		String language = "Portuguese";
		String currency = "EUR";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));

	}

	@Test(priority = 8)
	public void testCase08() {

		String language = "Chinese";
		String currency = "CNY";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));

	}

	@Test(priority = 9)
	public void testCase09() {

		String language = "English";
		String currency = "RUB";

		LanguageCurrency tc1 = new LanguageCurrency(chrome);
		tc1.changeLanguage(language);
		logger.get().log(Status.INFO, "Changing the language to " + language);
		tc1.changeCurrency(currency);
		logger.get().log(Status.INFO, "Changing the currency to " + currency);
		tc1.submit();
		logger.get().log(Status.INFO, "Clicking \"Save Changes\"");

		assertTrue(tc1.isLanguageChanged(language));
		assertTrue(tc1.isCurrencyChanged(currency));

	}

	@Test(priority = 10)
	public void testCase10() {

		String query = "Dolls";
		String category = "All";

		SearchByCategory tc1 = new SearchByCategory(chrome);
		tc1.chooseCategory(category);
		logger.get().log(Status.INFO, "Choosing " + category + " From Categories");
		tc1.searchProduct(query);
		logger.get().log(Status.INFO, "Typing " + query + " in the Search Bar");

		assertTrue(tc1.validSearch(query));
		assertTrue(tc1.validCategory(category));

	}

	@Test(priority = 11)
	public void testCase11() {

		String query = "Apple AirPods";
		String category = "Electronics";

		SearchByCategory tc1 = new SearchByCategory(chrome);
		tc1.chooseCategory(category);
		logger.get().log(Status.INFO, "Choosing " + category + " from Categories");
		tc1.searchProduct(query);
		logger.get().log(Status.INFO, "Typing " + query + " in the Search Bar");

		assertTrue(tc1.validSearch(query));
		assertTrue(tc1.validCategory(category));

	}

	@Test(priority = 12)
	public void testCase12() {

		String query = "";
		String category = "Books";

		SearchByCategory tc1 = new SearchByCategory(chrome);
		tc1.chooseCategory(category);
		logger.get().log(Status.INFO, "Choosing " + category + " from Categories");
		tc1.searchProduct(query);
		logger.get().log(Status.INFO, "Typing " + query + " in the Search Bar");

		assertTrue(tc1.validSearch(query));
		assertTrue(tc1.validCategory(category));

	}

	@Test(priority = 13)
	public void testCase13() {

		String query = "Blouse";
		String category = "Fashion";

		SearchByCategory tc1 = new SearchByCategory(chrome);
		tc1.chooseCategory(category);
		logger.get().log(Status.INFO, "Choosing " + category + " from Categories");
		tc1.searchProduct(query);
		logger.get().log(Status.INFO, "Typing " + query + " in the Search Bar");
 
		assertTrue(tc1.validSearch(query));
		assertTrue(tc1.validCategory(category));

	}

	@Test(priority = 14)
	public void testCase14() {

		String query = "Glycolic Acid Toner";
		String category = "Beauty";

		SearchByCategory tc1 = new SearchByCategory(chrome);
		tc1.chooseCategory(category);
		logger.get().log(Status.INFO, "Choosing " + category + " from Categories");
		tc1.searchProduct(query);
		logger.get().log(Status.INFO, "Typing " + query + " in the Search Bar");

		assertTrue(tc1.validSearch(query));
		assertTrue(tc1.validCategory(category));

	}


	@AfterTest
	public void tearDown() {

		chrome.quit();
	}

}

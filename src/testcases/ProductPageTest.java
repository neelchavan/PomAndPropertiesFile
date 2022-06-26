package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import resources.Base;

public class ProductPageTest extends Base {

	public WebDriver driver;
	LoginPage lp;
	ProductPage productTest;

	@BeforeTest
	public void openFirefoxBroser() {
		driver = startDriver();
		driver.get("https://www.saucedemo.com/");
		lp = new LoginPage(driver);
		productTest = lp.methodToLogin();
	}

	@Test(priority = 1)
	public void verifyProductPage() {
		String page = productTest.verifyProductPage();
		Assert.assertEquals(page, "PRODUCTS");
	}

	@Test(priority = 2)
	public void getPageUrlTest() {
		String url = productTest.getUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
	}

	@Test(priority = 3)
	public void productPageAddItemsTest() throws InterruptedException {
		productTest.addItems();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import resources.Base;

public class ShoppingCartPageTest extends Base {

	public WebDriver driver;
	LoginPage loginPageTest;
	ProductPage productPageTest;
	ShoppingCartPage ShoppingCartTest;

	@BeforeTest
	public void openFirefoxBroser() {
		driver = startDriver();
		driver.get("https://www.saucedemo.com/");
		loginPageTest = new LoginPage(driver);
		productPageTest = loginPageTest.methodToLogin();
		productPageTest.addItems();
		ShoppingCartTest = productPageTest.goToCart();
	}

	@Test
	public void verifyShoppingCartPage() {
		String pageTitle = ShoppingCartTest.verifyCartPage();
		Assert.assertEquals(pageTitle, "YOUR CART");
	}

	@Test
	public void itemsCount() {
		int count = ShoppingCartTest.verifyItemsCount();
		System.out.println("There are " + count + " items in your cart please verify manually again");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

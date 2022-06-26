package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import resources.Base;

public class LoginPageTest extends Base {

	public WebDriver driver;

	@BeforeTest
	public void openFirefoxBroser() {
		driver = startDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void LoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.methodToLogin();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

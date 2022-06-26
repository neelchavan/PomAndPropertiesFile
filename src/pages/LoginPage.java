package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.Base;

public class LoginPage extends Base {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//form//div[@class=\"form_group\"]//input[@placeholder=\"Username\"]");
	By password = By.xpath("//form//div[@class=\"form_group\"]//input[@type=\"password\"]");
	By loginButton = By.xpath("//input[@type=\"submit\"]");

	public ProductPage methodToLogin() {
		driver.findElement(username).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(loginButton).click();

		return new ProductPage(driver);
	}

}

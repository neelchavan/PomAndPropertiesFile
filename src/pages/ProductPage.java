package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.Base;

public class ProductPage extends Base {
	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	By fleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	By boltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By gotoShoppCart = By.cssSelector("a[class=\"shopping_cart_link\"]");
	By productHeading = By.xpath("//span[contains(text(), \"Products\")]");

	public String verifyProductPage() {
		return driver.findElement(productHeading).getText();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void addItems() {
		driver.findElement(fleeceJacket).click();
		driver.findElement(boltTShirt).click();
	}

	public ShoppingCartPage goToCart() {
		driver.findElement(gotoShoppCart).click();
		return new ShoppingCartPage(driver);
	}
}

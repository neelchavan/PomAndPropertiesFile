package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	private WebDriver driver;

	By shopCartTitle = By.xpath("//span[contains(text(),'Your Cart')]");
	By items = By.xpath("//div[@class=\"cart_item\"]");

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyCartPage() {
		return driver.findElement(shopCartTitle).getText();
	}

	public int verifyItemsCount() {
		List<WebElement> list = driver.findElements(items);
		return list.size();
	}
}

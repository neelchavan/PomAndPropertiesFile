package learn;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class FindBrokenLink extends Base {
	public WebDriver driver;

	@BeforeTest
	public void BeforeTest() {
		driver = startDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void findBrokenLinks() throws InterruptedException {

		driver.switchTo().frame("callout");

		// close the popUps
		if (driver.findElement(By.xpath("//button[contains(text(),'No thanks')]")).isDisplayed()) {
			driver.findElement(By.xpath("//button[contains(text(),'No thanks')]")).click();
		}
		driver.switchTo().defaultContent();

		List<WebElement> list = driver.findElements(By.tagName("a"));

		// verifyLinkActiveness("https://ssl.gstatic.com/gb/images/a/e2c0b463b4.png");

		for (int i = 0; i < list.size(); i++) {
			WebElement ele = list.get(i);
			String url = ele.getAttribute("href");
			verifyLinkActiveness(url);
		}
	}

	public static void verifyLinkActiveness(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				// Assert.assertTrue(httpURLConnect.getResponseCode() == 200);

				System.out
						.println(linkUrl + " - " + httpURLConnect.getResponseCode() + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				// Assert.assertFalse(true);
				System.out
						.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

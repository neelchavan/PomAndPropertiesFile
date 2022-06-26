package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public static String browserName;

	public WebDriver startDriver() {
		PropertiesFile.getProperties();
		System.out.println("All the test cases will now run on " + browserName);
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Neel\\tools\\gecko\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Neel\\tools\\chromeD\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}

		return driver;
	}

}

package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;

	// define variable browserName
	public static String browserName = null;

	public WebDriver startDriver() {
		// call static method getProperties() from PropertiesFile class this will set
		// the browserName.
		PropertiesFile.getProperties();

		System.out.println("All the test cases will now run on " + browserName);

		// opens the Browser according to the browser name specified in config file
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Neel\\tools\\gecko\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Neel\\tools\\chromeD\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		return driver;
	}
}

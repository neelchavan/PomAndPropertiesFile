package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void getProperties() {

		try {
			Properties prop = new Properties();

			// get current project path
			String projectPath = System.getProperty("user.dir");

			// Create a inputStream to read from a file
			InputStream input = new FileInputStream(projectPath + "\\src\\resources\\config.properties");

			// load the config file to get the key value pairs.
			prop.load(input);

			// read the config file
			String browser = prop.getProperty("browser");

			// Set the browserName in base class to browser name specified in config file
			Base.browserName = browser;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}

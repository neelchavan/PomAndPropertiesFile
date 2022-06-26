package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
	}

	public static void getProperties() {

		try {
			Properties prop = new Properties();
			String projectPath = System.getProperty("user.dir");
			System.out.println(projectPath);
			InputStream input = new FileInputStream(projectPath + "\\src\\resources\\config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			Base.browserName = browser;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}

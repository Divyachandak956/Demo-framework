package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase {

	public static WebDriver driver;

	@Test
	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\OM\\workspace\\anyonehomeDemo\\src\\main\\java\\Config\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		// System.out.println(browserName);
		if (browserName.equals("chrome")) {
		
			driver = new ChromeDriver();
			//chrome code
		} 
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/cdac/geckodriver.exe");
			driver = new FirefoxDriver();
			// firefox code
		} 
		else if (browserName.equals("IE")) {
			// IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}

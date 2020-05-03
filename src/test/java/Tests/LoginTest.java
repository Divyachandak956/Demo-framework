package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class LoginTest extends TestBase {
	@BeforeMethod
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "getData")
	public void Login(String username, String password) throws InterruptedException {
		System.out.println(username);
		System.out.println(password);
		driver.get("http://stage-showpro.herokuapp.com/signin");
		LoginPage lp = new LoginPage(driver);
		lp.userName().sendKeys(username);
		lp.password().sendKeys(password);
		WebElement l = lp.login();
		lp.login().click();
		Thread.sleep(9000);
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String ExpectedUrl = "http://stage-showpro.herokuapp.com/dashboard";
		Assert.assertEquals(actualUrl, ExpectedUrl);
		System.out.println("Login Test Pass");

	}

	@DataProvider(name = "getData")
	public String[][] dp() throws IOException {
		DataDriven ext = new DataDriven();
		String[][] dataToRead = ext
				.excelRead("C:\\Users\\OM\\workspace\\anyonehomeDemo\\src\\main\\java\\TestData\\file.xlsx", "Sheet1");
		return dataToRead;
	}

	@AfterMethod
	public void teardown() {

		driver.close();

	}

}

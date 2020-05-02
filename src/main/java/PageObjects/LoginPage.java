package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
	public WebDriver driver;

	@FindBy(id = "inputEmail")
	WebElement user_email;

	@FindBy(id = "inputPassword")
	WebElement user_password;

	@FindBy(className = "showproSignInBtn")
	WebElement sign_in;

	
	@Test
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement userName() {
		return user_email;

	}

	public WebElement password() {
		return user_password;
	}

	public WebElement login() {
		return sign_in;
	}

}

package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage {
	
	private WebDriver driver;

	@FindBy(linkText = "Login")
	private static WebElement btnLogin;

	@FindBy(id = "loginUserName")
	private static WebElement txtUsername;

	@FindBy(id = "loginPassword")
	private static WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement btnSubmit;

	@FindBy(className = "user")
	private static WebElement lblUser;
	
	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void setUserName(String userName) {
		txtUsername.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> btnSubmit).click();
	}
	
	public String getUserName() {
		return lblUser.getText();
	}

}

package pageObject;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactpage {
	
	private WebDriver driver;

	@FindBy(id = "forename-err")
	private static WebElement errorforename;
	
	@FindBy(id = "email-err")
	private static WebElement erroremail;
	
	@FindBy(id = "message-err")
	private static WebElement errormessage;
	
	@FindBy(linkText = "Contact")
	private static WebElement contactmenu;

	@FindBy(linkText = "Submit")
	private static WebElement Submitbutton;

	@FindBy(id = "forename")
	private static WebElement forename;

	@FindBy(id = "surname")
	private static WebElement surname;

	@FindBy(id = "email")
	private static WebElement email;

	@FindBy(id = "telephone")
	private static WebElement telephone;

	@FindBy(id = "message")
	private static WebElement message;
	
	@FindBy(css = "div.alert.alert-success")
	private static WebElement sucessmsg;

	public contactpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getNameError() {
		return errorforename.getText();
	}
	
	public String getEmailError() {
		return erroremail.getText();
	}
	
	public String getMessageError() {
		return errormessage.getText();
	}
	
	public String getAlertMessage() {
		new WebDriverWait(driver, Duration.ofSeconds(45))
		.until(ExpectedConditions.elementToBeClickable(sucessmsg));
		return sucessmsg.getText();
	}
	
	public boolean isNameErrorDisplayed() {
		return checkElementPresent(errorforename);
	}
	
	public boolean isEmailErrorDisplayed() {
		return checkElementPresent(erroremail);
	}
	
	public boolean isMessageErrorDisplayed() {
		return checkElementPresent(errormessage);
	}
	
	public void enterValues(String userName,String surName, String stremail, String phoneNumber, String strmessage) {
		forename.clear();
		forename.sendKeys(userName);
		
		surname.clear();
		surname.sendKeys(surName);
		
		email.clear();
		email.sendKeys(stremail);
		
		telephone.clear();
		telephone.sendKeys(phoneNumber);
		
		message.clear();
		message.sendKeys(strmessage);
	}
		
	public void clickContact() {
		contactmenu.click();
	}
	
	public void clickSubmit() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(Submitbutton));
		Submitbutton.click();
	}
	
	public boolean checkElementPresent(WebElement element) {
		 try {
			 return element.isDisplayed();
		 } catch (NoSuchElementException e) {
			 return false;
		 }
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") WebElement CheckAgreeChkBox;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement btnSubmit;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cPwd) {
		txtConfirmPassword.sendKeys(cPwd);
	}
	
	public void setPrivacyPolicy() {
		CheckAgreeChkBox.click();
	}
	
	public void clickContinue() {
		btnSubmit.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return msgConfirmation.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}

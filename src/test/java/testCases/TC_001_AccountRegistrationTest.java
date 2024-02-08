package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
		
	@Test (groups= {"regression","master"})
	public void verify_account_registration() {
		
		logger.info("**** TC_001_AccountRegistrationTest ****");
		
		logger.debug("application started....");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on MyAccount link");
		hp.clickRegister();
		logger.info("Click on registration link");
		
		logger.info("Entering customer details..");
		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		ar.setFirstName(randomString().toUpperCase());
		ar.setLastName(randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");
		ar.setTelephone(randomNumber());
		String password=randomAplhaNumeric();
		
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		
		ar.setPrivacyPolicy();
		ar.clickContinue();
		logger.info("Clicked on continue..");
		
		String cnfmsg=ar.getConfirmationMessage();
		
		logger.info("Validating expected message..");
		
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.debug("application logs end....");
		logger.info("**** TC_001_AccountRegistrationTest ****");
		
	}
	
	
	
}

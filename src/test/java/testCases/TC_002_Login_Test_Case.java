package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_002_Login_Test_Case extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void loginTest() {
		logger.info("**** TC_002_Login_Test_Case ****");
		logger.debug("capturing application logs.....");
		
		try {
		//home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount on home page");
		hp.clickLogin();
		logger.info("Clicked on Login link");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password");
		lp.setLoginEmail(p.getProperty("email"));
		lp.setLoginPassword(p.getProperty("password"));
		lp.btnLoginClick();
		
		//My Account
		MyAccount macp=new MyAccount(driver);
		boolean testPage=macp.isMyAccountPageExists();
		Assert.assertEquals(testPage,true,"Login failed");
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_Login_Test_Case ****");
		
	}
	
}

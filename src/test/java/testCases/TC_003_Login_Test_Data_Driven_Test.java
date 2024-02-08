package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_Test_Data_Driven_Test extends BaseClass{
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void loginTest(String email,String password,String exp) {
		logger.info("***** STARTIGN TC_003_Login_Test_Data_Driven_Test *****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setLoginEmail(email);
		lp.setLoginPassword(password);
		lp.btnLoginClick();
		
		
		MyAccount macp=new MyAccount(driver);
		boolean targetPage=macp.isMyAccountPageExists();
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				macp.clickLogut();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macp.clickLogut();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e) {
		Assert.fail("An exception occured"+e.getMessage());
	}
		
		logger.info("***** END TC_003_Login_Test_Data_Driven_Test *****");
	}
}

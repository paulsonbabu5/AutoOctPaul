package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void test_account_Registration()
	{   logger.info("*****Starting Test Case*********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickRegister();
		logger.info("clicked on Register");
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Started enter user details");
		rp.enterFIrstName("Pa");
		rp.setLastName("nm");
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randonNumber());
		rp.setPassword("12345");
		rp.setConfirmPassword("12345");
		rp.setPrivacyPolicy();
		rp.clickContinue();
		Assert.assertEquals(rp.confirmMSg(),"Your Account Has Been Created!");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		
		logger.info("*****Finished Test Case*********");
		
	}

}

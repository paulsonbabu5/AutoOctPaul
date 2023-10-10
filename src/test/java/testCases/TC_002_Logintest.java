package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Logintest extends BaseClass{
	@Test(groups={"Master","Regression"})
	public void test_login()
	{  logger.info("****Starting Test Case*****");
	try
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(rb.getString("email"));
		lp.enterPassword(rb.getString("password"));
		lp.clickSubmit();
		Assert.assertEquals(lp.isMyAccountPageExists(), true);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("***Finished Test Case*******");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

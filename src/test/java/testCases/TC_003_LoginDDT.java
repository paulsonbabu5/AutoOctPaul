package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String mail,String password,String exp)
	{ 
		logger.info("LoginDDT started");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(mail);
		lp.enterPassword(password);
		lp.clickSubmit();
		boolean targetpage=lp.isMyAccountPageExists();
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(true);
				lp.clickLogout();
			}
			else
			{
				Assert.fail();
			}
		}
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				Assert.fail();
			}
			else
			{
				Assert.assertTrue(true);
			}
		}}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("login ddt finished");
	}
	
	

}

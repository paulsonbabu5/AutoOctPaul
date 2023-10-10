package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(name="email")
	WebElement txtEmail;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnSubmit;
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading ;
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	public void enterUsername(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}	
	public void clickLogout()
	{
		lnkLogout.click();
		
	}
	
	
	
	
	
	
	
}

package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@BeforeClass(groups={"Master","Regression","Sanity"})
	@Parameters("browser")
	public void setup(String br)
	{
	logger=LogManager.getLogger(this.getClass());
	rb=ResourceBundle.getBundle("config");
	if(br.equals("chrome"))
	{
	driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(rb.getString("appURL"));
	driver.manage().window().maximize();
	}
	@AfterClass(groups={"Master","Regression","Sanity"})
	public void tearDown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return(generatedString);
	}
	public String randonNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(7);
		return (generatedNumber);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\pauls\\eclipse-workspace\\Automation_24_09_2023\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}

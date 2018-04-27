package Tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

public class Screenshot extends BaseTest
{

	@Test
	public void Screenshot() throws IOException, InterruptedException{
		test = extent.createTest("Screenshot");
		System.setProperty("webdriver.gecko.driver", "i:\\Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		driver =  new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.navigate().to("http://google.com/");
		test.pass("Navigate to the google website");
		
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("test");
		test.pass("enter the value in google search field");
		
		driver.findElement(By.name("btnK")).click();
		test.pass("Click the Google Search button");
		
		Thread.sleep(5000);
		// Take screenshot and store in temp file
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String screenShotName = this.getClass().getName()+".png";
		String screenShotFilePath = System.getProperty("user.dir")+"/Screenshots/"+screenShotName;

		// declare the destination file path
		File destination = new File(screenShotFilePath);

		//copy the screenshot file from source to the destination
		FileUtils.copyFile(source, destination);

		test.fail(screenShotFilePath, MediaEntityBuilder.createScreenCaptureFromPath(screenShotFilePath).build());
		
		driver.quit();


	}

}
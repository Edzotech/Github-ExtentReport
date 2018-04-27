package Tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;

	@BeforeSuite
	public void setUp()
	{

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/extent-report/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7");
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Edzotech");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Cycle");
		htmlReporter.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");
	
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.fail(result.getThrowable());

		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
		}
		else
		{
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}

}
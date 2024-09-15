package frameworkdesign.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtendReportDemo {

	ExtentReports extent;

	@BeforeTest

	public void config()

	{

		String path = System.getProperty("user.dir") + "\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentReports extent = new ExtentReports();

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Priyanka");

	}

	@Test

	public void initialDemo()

	{

		extent.createTest("initial Demo");

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/login/");

		System.out.println(driver.getTitle());

		extent.flush();

	}

}

package anirbansarkar.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentSparkReporter esr;
	ExtentReports er;

	@BeforeTest

	public void config() {

		// ExtentSparkReporter is used to set Report path and report configuration
		String path = System.getProperty("user.dir") + "//reports//report.html";
		esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Web Automation Results");
		esr.config().setDocumentTitle("Test Results");

		// ExtentReports is used to enter actual details into the report created in the
		// previous section
		er = new ExtentReports();
		er.attachReporter(esr);// Attach the reporter object
		er.setSystemInfo("Tester", "Anirban");// Set tester name

	}

	@Test

	public void initialDemo() {

		er.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		er.flush();

	}

}

package com.retail.testng.runners;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import com.framework.utils.ExtentReporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features",
		glue={"com.retail.stepDefinitions"}
		,tags={"@chamu"}
		,monochrome=true
		,format={"pretty","json:reports/cucumber/json/json-report.json", "html:reports/cucumber/html/html-report.html"}
		)

public class BuildTest extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public static void initializeSuite(ITestContext xmlSuite) throws FileNotFoundException, IOException {	
		
		String suiteName = xmlSuite.getSuite().getName();
		ExtentReporter.startExtentReport(suiteName);
	}
	
}

package com.retail.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.framework.utils.DataProvider;
import com.framework.utils.LogUtils;
import com.framework.wrapper.WebDriverManager;
import com.framework.wrapper.WebOperations;

public class Hooks extends WebDriverManager {

	static Logger log;
	static {
		log = Logger.getLogger(Hooks.class);
	}

	@Before
	public void before(Scenario scenario) {
		try {
			String scenarioName = scenario.getName();
			LogUtils.startTest(scenarioName);
			RemoteWebDriver driver;
			if (getExeMode().equalsIgnoreCase("remote") || getExeMode().equalsIgnoreCase("grid")) {
				log.info("getting remote driver for: " + getBrowser());
				driver = WebDriverManager.createRemoteDriver(getBrowser());
			} else {
				log.info("getting driver for: " + getBrowser());
				driver = WebDriverManager.createLocalDriver(getBrowser());
			}
			WebDriverManager.setWebDriver(driver);
			log.info("Done! Created " + getBrowser() + " driver!");

			String temp = scenario.getId();
			String[] tempArr = temp.split(";");
			String featureName = tempArr[0];
			if (tempArr.length == 2)
				startExtentTestReport(scenarioName + "_" + getEnvironment() + "_" + getBrowser(),
						"Feature Name: " + featureName + "<br>Scenario Name: " + scenarioName + "<br>Environment: "
								+ getEnvironment() + "<br>Browser: " + getBrowserInfo());
			else {
				int iterationNo = Integer.parseInt(tempArr[tempArr.length - 1]);
				startExtentTestReport(
						iterationNo - 1 + ". " + scenarioName + "_" + getEnvironment() + "_" + getBrowser(),
						"Feature Name: " + featureName + "<br>Scenario Name: " + scenarioName + "<br>Environment: "
								+ getEnvironment() + "<br>Browser: " + getBrowserInfo());
			}
			log.info("Executing scenario: " + scenarioName);
			DataProvider.loadXMLData("./src/test/resources/testData/xmlData.xml", scenarioName);
			DataProvider.loadExcelData("./src/test/resources/testData/TestData.xlsx", "testData", scenarioName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void after(Scenario scenario) {
		try {
			String scenarioName = scenario.getName();
			String status = scenario.getStatus();
			if (scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
			endExtentReport();
			WebOperations.quitBrowser();
			LogUtils.endTest(scenarioName, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
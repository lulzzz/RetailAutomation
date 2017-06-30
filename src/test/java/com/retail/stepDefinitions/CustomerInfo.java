package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import cucumber.api.java.en.*;
import com.retail.pageObjects.CustomerInfoPage;

public class CustomerInfo extends CustomerInfoPage{

	private static Logger log = Logger.getLogger(CustomerInfo.class);	
	
	@When("^I give valid date or month and click submit$")	
	public void enterValidDOB() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: When I give valid date or month and click submit", "INFO");
			if(isElementDisplayed(CustomerInfoPage.dobField,10))
			{
				clickElement(CustomerInfoPage.dobField);				
				Actions action = new Actions(getDriver());					
				action.sendKeys("06/06/1985").perform();
				log.info("DOB is entered");					
			}				
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in CustomerMoreInfo_enterSSNDOB(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
	@When("^I give valid SSN and click submit$")
	public void enterValidSSN() throws Exception{
		try {			
			ExtentReporter.reportStep("BDD Step: When I give valid SSN and click submit", "INFO");
			if(isElementDisplayed(CustomerInfoPage.ssnField,10))
			{
				clickElement(CustomerInfoPage.ssnField);
				typeValue(CustomerInfoPage.ssnField,getXMLData("SSN"));				
				log.info("SSN is entered");	
			}
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in CustomerMoreInfo_enterValidSSN(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
	@When("^I click submit$")	
	public void clickSubmit() throws Exception {
		try {		
			ExtentReporter.reportStep("BDD Step: When I click submit", "INFO");
				//Click on Submit
			clickElement(CustomerInfoPage.submitBtn);
			log.info("Clicked on Submit button");
				
		}catch (Exception e) {
			log.error("GOT EXCEPTION in CustomerMoreInfo_clickSubmit(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@When("^I select valid lines and click submit$")	
	public void selectValidLines() throws Exception {
		try {		
				ExtentReporter.reportStep("BDD Step: When I select valid lines and click submit", "INFO");
				//Selection of number of lines			
				String number_of_lines= getXMLData("NumberOfLines").toUpperCase();
				log.info(number_of_lines);
				if(number_of_lines.equalsIgnoreCase("Just Accessories"))
				{				
					log.info("Selected Just Accessories Option");
					clickElement(CustomerInfoPage.justAccessories);					
				}else{
					clickElement(CustomerInfoPage.singleLine);					
				}						
				//Click on Submit
				clickSubmit();
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in CustomerMoreInfo_selectValidLines(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
}
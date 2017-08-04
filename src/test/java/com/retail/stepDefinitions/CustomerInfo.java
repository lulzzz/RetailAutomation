package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import cucumber.api.java.en.*;
import com.retail.pageObjects.CustomerInfoPage;
import com.retail.pageObjects.SignaturePage;

public class CustomerInfo extends CustomerInfoPage{

	private static Logger log = Logger.getLogger(CustomerInfo.class);	
	
	GlobalSteps globalStepsObj = new GlobalSteps();
	
	@When("^I give valid date or month and click submit$")	
	public void enterValidDOB() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: When I give valid date or month and click submit", "INFO");
			if(isElementDisplayed(CustomerInfoPage.storeName,10))
			{
				globalStepsObj.capture_session();
				clickElement(CustomerInfoPage.storeName);
				typeValue(CustomerInfoPage.storeName,getXMLData("Store_Name"));
				clickElement(CustomerInfoPage.storeNumber);
				typeValue(CustomerInfoPage.storeNumber,getXMLData("Store_Number"));
				clickElement(CustomerInfoPage.address);
				typeValue(CustomerInfoPage.address,getXMLData("Address"));
				clickElement(CustomerInfoPage.city);
				typeValue(CustomerInfoPage.city,getXMLData("city"));
				clickElement(CustomerInfoPage.state);
				String state= getXMLData("state");
				CustomerInfoPage.selectState(state);
				clickElement(CustomerInfoPage.Zip);
				typeValue(CustomerInfoPage.Zip,getXMLData("zipcode"));
			}
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
			if(isElementDisplayed(CustomerInfoPage.ssnField2,10))
			{
//				clickElement(CustomerInfoPage.ssnField2);
//				typeValue(CustomerInfoPage.ssnField2,getXMLData("SSN2"));				
//				log.info("SSN is entered");	
				 String ssn = getXMLData("SSN2");
				 WebElement webElement = getDriver().findElement(CustomerInfoPage.ssnField2);
				 Actions actionBuilder=new Actions(getDriver());
				 Action drawOnCanvas=actionBuilder.moveToElement(webElement)					 							 	
			                .moveByOffset(3,1)
			                .release()
			                .click()
			                 .sendKeys(ssn)
			                .build();				
				 drawOnCanvas.perform();

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
//			if(isElementDisplayed(CustomerInfoPage.submitBtn,5))
//			{
//				clickElement(CustomerInfoPage.submitBtn);
//				log.info("Clicked on Submit button for two times");
//				
//		}
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
				if(isElementDisplayed(CustomerInfoPage.singleLine,5)){
					if(number_of_lines.equalsIgnoreCase("Just Accessories"))
					{				
						log.info("Selected Just Accessories Option");
						clickElement(CustomerInfoPage.justAccessories);					
					}else{
						clickElement(CustomerInfoPage.singleLine);					
					}	
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

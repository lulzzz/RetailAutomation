package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import cucumber.api.java.en.*;
import com.retail.pageObjects.Customer_MoreInfoPage;

public class Customer_MoreInfo extends WebOperations{

	private static Logger log = Logger.getLogger(Customer_MoreInfo.class);	
	
	@When("^I give valid date or month and click submit$")	
	public void enterSSNDOB()  {
		try {
			Thread.sleep(5000);
			
			if(checkElement(Customer_MoreInfoPage.dobField))
			{
				clickElement(Customer_MoreInfoPage.dobField);				
				Actions action = new Actions(getDriver());					
				action.sendKeys("06/06/1985").perform();
				log.info("DOB is entered");	
			}							
			Thread.sleep(5000);		
			
			if(checkElement(Customer_MoreInfoPage.ssnField))
			{
				clickElement(Customer_MoreInfoPage.ssnField);
				typeValue(Customer_MoreInfoPage.ssnField,getExcelData("SSN"));				
				log.info("SSN is entered");	
			}	
			
			selectValidLines();				
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in enterSSNDOB(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
	@When("^I select  valid lines and click submit$")	
	public void selectValidLines()  {
		try {			
				//Selection of number of lines			
				String number_of_lines= getExcelData("NumberOfLines").toUpperCase();
				log.info(number_of_lines);
				if(number_of_lines.equalsIgnoreCase("Just Accessories"))
				{				
					log.info("Selected Just Accessories Option");
					clickElement(Customer_MoreInfoPage.justAccessories);
					Thread.sleep(5000);
				}else{
					clickElement(Customer_MoreInfoPage.singleLine);					
				}			
				Thread.sleep(5000);
				
				clickElement(Customer_MoreInfoPage.submitBtn);
				log.info("Clicked on Submit button");
				
				Thread.sleep(5000);
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in selectValidLines(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
}

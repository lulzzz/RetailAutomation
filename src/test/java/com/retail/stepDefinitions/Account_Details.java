package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Account_DetailsPage;

import cucumber.api.java.en.*;



public class Account_Details extends WebOperations{

	private static Logger log = Logger.getLogger(Account_Details.class);
	
	Customer_MoreInfo custMoreInfoObj= new Customer_MoreInfo();
	
	//Looks up for customer details
	@When("^I click Launch Mobile$")	
	public void launchMobile()  {
		try {
			Thread.sleep(5000);	
			
			if(checkElement(Account_DetailsPage.manageMobileLink))
			{								
				clickElement(Account_DetailsPage.launchMobileRtBtn);
			}else
			{						
				clickElement(Account_DetailsPage.launchMobileBtn);	
			}	
			
			log.info("Clicked on Launch Mobile");	
			Thread.sleep(2000);		
			
			custMoreInfoObj.enterSSNDOB();			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in launchMobile(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
}

package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.Account_DetailsPage;

import cucumber.api.java.en.*;

public class Account_Details extends Account_DetailsPage{

	private static Logger log = Logger.getLogger(Account_Details.class);	
	
	//Looks up for customer details
	@When("^I click Launch Mobile$")	
	public void launchMobile()  {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Launch Mobile", "INFO");
			if(checkElement(Account_DetailsPage.manageMobileLink))
			{								
				clickElement(Account_DetailsPage.launchMobileRtBtn);
			}else
			{						
				clickElement(Account_DetailsPage.launchMobileBtn);	
			}				
			log.info("Clicked on Launch Mobile");					
								
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_Details_launchMobile(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
}

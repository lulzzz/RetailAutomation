package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.AccountDetailsPage;

import cucumber.api.java.en.*;

public class AccountDetails extends AccountDetailsPage{

	private static Logger log = Logger.getLogger(AccountDetails.class);	
	
	//Looks up for customer details
	@When("^I click Launch Mobile$")	
	public void launchMobile() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Launch Mobile", "INFO");
			if(isElementDisplayed(AccountDetailsPage.manageMobileLink,5))
			{								
				clickElement(AccountDetailsPage.launchMobileRtBtn);
			}else
			{						
				clickElement(AccountDetailsPage.launchMobileBtn);	
			}				
			log.info("Clicked on Launch Mobile");				
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_Details_launchMobile(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
}

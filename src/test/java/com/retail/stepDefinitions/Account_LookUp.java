package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Account_LookUpPage;

import cucumber.api.java.en.*;


public class Account_LookUp extends WebOperations{

	private static Logger log = Logger.getLogger(Account_LookUp.class);
	
	Account_Details acctDetailsObj= new Account_Details();
	
	@When("^I enter valid account number$")
	public void enterValidAcctNumber()
	{
		try {
			Thread.sleep(5000);			
			clickElement(Account_LookUpPage.lookUpInput);
			System.out.println(getXMLData("AccountNumber"));
			typeValue(Account_LookUpPage.lookUpInput,getXMLData("AccountNumber"));
			log.info("Entered Customer Look Up Value");	
			Thread.sleep(5000);
						
		}catch (Exception e) {
			log.error("GOT EXCEPTION in enterValidAcctNumber(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}		
	
	@And("^click on Look Up$")
	public void clickOnLookUp()
	{
		try {
			
			clickElement(Account_LookUpPage.lookUpButton);
			log.info("Clicked on Look Up Button");	
			Thread.sleep(5000);	
			WebOperations.verifyText("Please validate customer ID");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in clickOnLookUp(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the customer ID validation to launch the customer details$")
	public void acctDetailsPageLaunch()
	{
		try {			
			//Customer ID Validation
			String customer_ID= getXMLData("ID_Validation").toUpperCase();
			log.info(customer_ID);
			if(customer_ID.equalsIgnoreCase("Driver License"))
			{				
				log.info("Validated Customer ID using Driver License");
				clickElement(Account_LookUpPage.driverLicense);
				Thread.sleep(5000);
			}else if(customer_ID.equalsIgnoreCase("State ID"))
			{
				clickElement(Account_LookUpPage.stateID);
				log.info("Validated Customer ID using State ID");
			}else if(customer_ID.equalsIgnoreCase("US Passport"))
			{
				clickElement(Account_LookUpPage.USPassport);
				log.info("Validated Customer ID using US Passport");
			}			
			Thread.sleep(5000);	
			
			acctDetailsObj.launchMobile();	
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in acctDetailsPageLaunch(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	//Looks up for customer details
	@Given("^agent looks for an eligible customer details$")	
	public void customerLookup()  {
		try {
			enterValidAcctNumber();
			clickOnLookUp();
			acctDetailsPageLaunch();
		}catch (Exception e) {
			log.error("GOT EXCEPTION in customerLookup(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
}

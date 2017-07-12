package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.AccountLookUpPage;
import com.retail.pageObjects.CustomerInfoPage;

import cucumber.api.java.en.*;


public class AccountLookUp extends AccountLookUpPage{

	private static Logger log = Logger.getLogger(AccountLookUp.class);
	AccountDetails acctDetailsObj= new AccountDetails();
	CustomerInfo custMoreInfoObj= new CustomerInfo();
		
	@When("^I enter valid account number$")
	public void enterValidAcctNumber() throws Exception
	{
		try {	
			ExtentReporter.reportStep("BDD Step: When I enter valid account number", "INFO");
			clickElement(AccountLookUpPage.lookUpInput);			
			typeValue(AccountLookUpPage.lookUpInput,getXMLData("AccountNumber"));
			log.info("Entered Customer Look Up Value");					
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_enterValidAcctNumber(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}		
	
	@And("^click on Look Up$")
	public void clickOnLookUp() throws Exception
	{
		try {
			ExtentReporter.reportStep("BDD Step: And click on Look Up", "INFO");
			clickElement(AccountLookUpPage.lookUpButton);
			log.info("Clicked on Look Up Button");				
			WebOperations.verifyText("Please validate customer ID");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_clickOnLookUp(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I see the customer ID validation to launch the customer details$")
	public void acctDetailsPageLaunch() throws Exception
	{
		try {	
			ExtentReporter.reportStep("BDD Step: Then I see the customer ID validation to launch the customer details", "INFO");
			//Customer ID Validation
			String customer_ID= getXMLData("ID_Validation").toUpperCase();
			log.info(customer_ID);
			if(customer_ID.equalsIgnoreCase("Driver License"))
			{				
				log.info("Validated Customer ID using Driver License");
				clickElement(AccountLookUpPage.driverLicense);				
			}else if(customer_ID.equalsIgnoreCase("State ID"))
			{
				clickElement(AccountLookUpPage.stateID);
				log.info("Validated Customer ID using State ID");
			}else if(customer_ID.equalsIgnoreCase("US Passport"))
			{
				clickElement(AccountLookUpPage.USPassport);
				log.info("Validated Customer ID using US Passport");
			}
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_acctDetailsPageLaunch(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	//Looks up for customer details
	@Given("^agent looks for an eligible customer details$")	
	public void customerLookup()  throws Exception{
		try {
			ExtentReporter.reportStep("BDD Step: Given agent looks for an eligible customer details", "INFO");
//			Thread.sleep(4000);
			enterValidAcctNumber();
			clickOnLookUp();
			acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
			if(isElementDisplayed(CustomerInfoPage.dobField,10))
			{
			custMoreInfoObj.enterValidDOB();	
			custMoreInfoObj.enterValidSSN();
			custMoreInfoObj.selectValidLines();
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_customerLookup(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Given("^agent looks for an eligible customer with no active lines$")	
	public void customerLookup_noactivelines()  throws Exception{
		try {
			ExtentReporter.reportStep("BDD Step: Given agent looks for an eligible customer with no active lines", "INFO");
//			Thread.sleep(4000);
			enterValidAcctNumber();
			clickOnLookUp();
			acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
		
//			if(isElementDisplayed(CustomerInfoPage.existing_lines,5)){
//				System.out.println("Active lines are present in this account");
//				log.info("Active lines are present in this account");
//			    System.exit(0);
//			}
//			else
//			{
//				System.out.println("No active lines in this account");
//			}
            if(isElementDisplayed(CustomerInfoPage.dobField,5))
            {
			custMoreInfoObj.enterValidDOB();	
			custMoreInfoObj.enterValidSSN();
			custMoreInfoObj.selectValidLines();
            }
		} 
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_customerLookup(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
}

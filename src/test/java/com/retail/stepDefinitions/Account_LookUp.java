package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Account_LookUpPage;

import cucumber.api.java.en.*;


public class Account_LookUp extends Account_LookUpPage{

	private static Logger log = Logger.getLogger(Account_LookUp.class);
	Account_Details acctDetailsObj= new Account_Details();
	Customer_MoreInfo custMoreInfoObj= new Customer_MoreInfo();
		
	@When("^I enter valid account number$")
	public void enterValidAcctNumber()
	{
		try {	
			ExtentReporter.reportStep("BDD Step: When I enter valid account number", "INFO");
			clickElement(Account_LookUpPage.lookUpInput);			
			typeValue(Account_LookUpPage.lookUpInput,getXMLData("AccountNumber"));
			log.info("Entered Customer Look Up Value");					
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_enterValidAcctNumber(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}		
	
	@And("^click on Look Up$")
	public void clickOnLookUp()
	{
		try {
			ExtentReporter.reportStep("BDD Step: And click on Look Up", "INFO");
			clickElement(Account_LookUpPage.lookUpButton);
			log.info("Clicked on Look Up Button");				
			WebOperations.verifyText("Please validate customer ID");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_clickOnLookUp(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the customer ID validation to launch the customer details$")
	public void acctDetailsPageLaunch()
	{
		try {	
			ExtentReporter.reportStep("BDD Step: Then I see the customer ID validation to launch the customer details", "INFO");
			//Customer ID Validation
			String customer_ID= getXMLData("ID_Validation").toUpperCase();
			log.info(customer_ID);
			if(customer_ID.equalsIgnoreCase("Driver License"))
			{				
				log.info("Validated Customer ID using Driver License");
				clickElement(Account_LookUpPage.driverLicense);				
			}else if(customer_ID.equalsIgnoreCase("State ID"))
			{
				clickElement(Account_LookUpPage.stateID);
				log.info("Validated Customer ID using State ID");
			}else if(customer_ID.equalsIgnoreCase("US Passport"))
			{
				clickElement(Account_LookUpPage.USPassport);
				log.info("Validated Customer ID using US Passport");
			}
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_acctDetailsPageLaunch(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	//Looks up for customer details
	@Given("^agent looks for an eligible customer details$")	
	public void customerLookup()  {
		try {
			ExtentReporter.reportStep("BDD Step: Given agent looks for an eligible customer details", "INFO");
			Thread.sleep(4000);
			enterValidAcctNumber();
			clickOnLookUp();
			acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
			custMoreInfoObj.enterValidDOB();	
			custMoreInfoObj.enterValidSSN();
			custMoreInfoObj.selectValidLines();
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_customerLookup(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
}

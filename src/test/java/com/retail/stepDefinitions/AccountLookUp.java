package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;


public class AccountLookUp extends AccountLookUpPage{

	private static Logger log = Logger.getLogger(AccountLookUp.class);
	AccountDetails acctDetailsObj= new AccountDetails();
	CustomerInfo custMoreInfoObj= new CustomerInfo();
	AccountDetailsPage acctDetail= new AccountDetailsPage();
	CustomerPreSignaturePage custPage= new CustomerPreSignaturePage();
	DeviceBrand devicebrand= new DeviceBrand();
	BrowseDevice browseDevice= new BrowseDevice();
	
		
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
	
	@And("^I click on Look Up$")
	public void clickOnLookUp()
	{
		try {
			ExtentReporter.reportStep("BDD Step: I click on Look Up", "INFO");
			clickElement(AccountLookUpPage.lookUpButton);
			log.info("Clicked on Look Up Button");	
			Thread.sleep(5000);	
		    verifyText("Please validate customer ID");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in clickOnLookUp(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@And("^I click on Look Up button$")
	public void clickOnLookUpButton()
	{
		try {
			ExtentReporter.reportStep("BDD Step: I click on Look Up button", "INFO");
			clickElement(AccountLookUpPage.lookUpButton);
			log.info("Clicked on Look Up Button");	
			Thread.sleep(5000);	
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in clickOnLookUp(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
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
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
}
		
	catch (Exception e) {
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
		
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
		else
		{
			System.exit(0);
		}
			}
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
	@Given("^I am in Device details page$")
	public void deviceDetails() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Given I am in Device details page", "INFO");
			enterValidAcctNumber();
			clickOnLookUp();
		    acctDetailsPageLaunch();
			isElementDisplayed(acctDetail.Account,5);	
		   
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Scan Bill$")
	public void scanbill()  {
		try {
			ExtentReporter.reportStep("BDD Step: I click on Scan Bill", "INFO");
			clickElement(AccountLookUpPage.scanbill);
			log.info("Clicked Scan Bill button");	
			Thread.sleep(5000);	
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in scanbill(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}
	}
		
	@Then("^I see the Scan Barcode Now Text$")
	public void barcodetext()  {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Scan Barcode Now Text", "INFO");
			verifyText("Scan Barcode Now");
			log.info("Scan Barcode Now text is displayed");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in barcodetext(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	@Then("^I see error message$")
	public void errormessage()  {
		try {
			ExtentReporter.reportStep("BDD Step: I see error message", "INFO");
			verifyText("Please enter first and last name, email address, phone");
			log.info("Error message is displayed");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in errormessage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I close the Scan Bill$")
	public void scanclose()  {
		try {
			ExtentReporter.reportStep("BDD Step: I close the Scan Bill", "INFO");
			clickElement(AccountLookUpPage.scanclose);
			log.info("Clicked Scan Close button");	
			Thread.sleep(5000);	
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in scanclose(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I see the Look Up Page$")
	public void lookup() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Look Up Page", "INFO");
			verifyText("Look Up Customer");
			verifyText("Scan Bill");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in scanclose(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
	}
	
	@Then("^I cancel the Scan Bill$")
	public void scancancel()  {
		try {
			ExtentReporter.reportStep("BDD Step: I cancel the Scan Bill", "INFO");
			clickElement(AccountLookUpPage.scancancel);
			log.info("Clicked Scan Cancel button");	
			Thread.sleep(5000);	
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in scancancel(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Given("^I lookup for a Customer$")
	public void lookupinput()  {
		try {
			ExtentReporter.reportStep("BDD Step: I lookup for a Customer", "INFO");
			String lookupInput= getXMLData("LookUpInput").toUpperCase();
			log.info(lookupInput);
			if(lookupInput.equalsIgnoreCase("AccountNumber"))
			{				
				Thread.sleep(5000);			
				clickElement(AccountLookUpPage.lookUpInput);
				System.out.println(getXMLData("AccountNumber"));
				typeValue(AccountLookUpPage.lookUpInput,getXMLData("AccountNumber"));
				log.info("Entered Account Number as Customer Look Up Value");	
				Thread.sleep(5000);
			}else if(lookupInput.equalsIgnoreCase("ValidEmail"))
			{
				Thread.sleep(5000);			
				clickElement(AccountLookUpPage.lookUpInput);
				System.out.println(getXMLData("ValidEmail"));
				typeValue(AccountLookUpPage.lookUpInput,getXMLData("ValidEmail"));
				log.info("Entered Valid Email as Customer Look Up Value");	
				Thread.sleep(5000);
			}
			clickOnLookUp();	
					
		}catch (Exception e) {
			log.error("GOT EXCEPTION in lookupinput(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
			
			
	@When("^I click on Driver's License$")
	public void driverslicense()  {
		try {
			ExtentReporter.reportStep("BDD Step: I click on Driver's License", "INFO");
			clickElement(AccountLookUpPage.driverLicense);
			log.info("Validated Customer ID using Driver License");
			Thread.sleep(5000);
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in driverslicense(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I see the account details page$")
	public void accountdetails()  {
		try {
			ExtentReporter.reportStep("BDD Step: I see the account details page", "INFO");
			verifyText("Account Status");
			verifyText("Appointments");
			verifyText("Notes");
			verifyText("Mobile Details");
			verifyText("R360 Loads");
			log.info("Account Details Page is displayed");
				
			}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in accountdetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@When("^I click on State ID$")
	public void stateID()  {
		try {
			ExtentReporter.reportStep("BDD Step: I click on State ID", "INFO");
			clickElement(AccountLookUpPage.stateID);
			log.info("Validated Customer ID using State ID");
			Thread.sleep(5000);
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in stateID(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@When("^I enter valid Email$")
	public void validEmail()
	{
		try {
			ExtentReporter.reportStep("BDD Step: I enter valid Email", "INFO");
			Thread.sleep(5000);			
			clickElement(AccountLookUpPage.lookUpInput);
			System.out.println(getXMLData("ValidEmail"));
			typeValue(AccountLookUpPage.lookUpInput,getXMLData("ValidEmail"));
			log.info("Entered ValidEmail as Customer Look Up Value");	
			Thread.sleep(5000);
						
		}catch (Exception e) {
			log.error("GOT EXCEPTION in validEmail(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I enter invalid Email$")
	public void invalidEmail()
	{
		try {
			ExtentReporter.reportStep("BDD Step: I enter invalid Email", "INFO");
			Thread.sleep(5000);			
			clickElement(AccountLookUpPage.lookUpInput);
			System.out.println(getXMLData("InvalidEmail"));
			typeValue(AccountLookUpPage.lookUpInput,getXMLData("InvalidEmail"));
			log.info("Entered InvalidEmail as Customer Look Up Value");	
			Thread.sleep(5000);
						
		}catch (Exception e) {
			log.error("GOT EXCEPTION in invalidEmail(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I click on US Passport$")
	public void USpassport()  {
		try {
			ExtentReporter.reportStep("BDD Step: I click on US Passport", "INFO");
			clickElement(AccountLookUpPage.USPassport);
			log.info("Validated Customer ID using US passport");
			Thread.sleep(5000);
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in USpassport(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
	}
	
	@When("^I click on ID does not match above address or no ID available$")
	public void IDnotmatch()  {
		try {	
			ExtentReporter.reportStep("BDD Step: I click on ID does not match above address or no ID available", "INFO");
			clickElement(AccountLookUpPage.IDnotmatch);
			log.info("Clicked ID does not match above address or no ID available ");
			Thread.sleep(5000);
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in IDnotmatch(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I see the SSN validation page$")
	public void SSNvalidationpage()  {
		try {
			ExtentReporter.reportStep("BDD Step: I see the SSN validation page", "INFO");
			verifyText("SSN Validation");
			verifyText("Enter last four digits of customer social security number");
			log.info("Clicked ID does not match above address or no ID available ");
			Thread.sleep(5000);
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in SSNvalidationpage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I validate using valid SSN$")
	public void validSSN()  {
		try {
			//clickElement(AccountLookUpPage.SSN);
			ExtentReporter.reportStep("BDD Step: I validate using valid SSN", "INFO");
			typeValue(AccountLookUpPage.SSN,getXMLData("validSSN"));
			log.info("Entered valid SSN");
			clickElement(AccountLookUpPage.enterSSN);
			log.info("Clicked Enter button");
			Thread.sleep(5000);
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in validSSN(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@And("^I validate using incorrect SSN$")
	public void incorrectSSN() {
		try {
			//clickElement(AccountLookUpPage.SSN);
			ExtentReporter.reportStep("BDD Step: I validate using incorrect SSN", "INFO");
			typeValue(AccountLookUpPage.SSN,getXMLData("incorrectSSN"));
			log.info("Entered incorrect SSN");
			clickElement(AccountLookUpPage.enterSSN);
			log.info("Clicked Enter button");
			verifyText(" Digits entered are incorrect. Please try again.");
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in incorrectSSN(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@When("^I click on close button in SSN page$")
	public void closeSSN() {
		try {
			ExtentReporter.reportStep("BDD Step: I click on close button in SSN page", "INFO");
			clickElement(AccountLookUpPage.closeSSN);
			log.info("Clicked Close button");
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in closeSSN(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I see the page returned to Validate customer ID$")
	public void validateCustomer() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the page returned to Validate customer ID", "INFO");
			verifyText("Please validate customer ID");
			log.info("Customer ID page is displayed");
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in validateCustomer(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@When("^I click on cancel button in SSN page$")
	public void cancelSSN() {
		try {
			ExtentReporter.reportStep("BDD Step: I click on cancel button in SSN page", "INFO");
			clickElement(AccountLookUpPage.cancelSSN);
			log.info("Clicked Cancel button");
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in cancelSSN(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@When("^I close the cutomer ID verification Page$")
	public void closeID() {
		try {
			ExtentReporter.reportStep("BDD Step: I close the cutomer ID verification Page", "INFO");
			clickElement(AccountLookUpPage.closeID);
			log.info("Clicked Close button in Customer ID verification page");
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in closeID(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@Then("^I see the page returned to look up page$")
	public void lookupPage() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the page returned to look up page", "INFO");
			verifyText("Look Up Customer");
			log.info("Look Up Page is displayed");
		}
		
	catch (Exception e) {
			log.error("GOT EXCEPTION in lookupPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
}
	
	@When("^I enter invalid name$")
	public void invalidName() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter invalid name", "INFO");
			Thread.sleep(5000);			
			clickElement(AccountLookUpPage.lookUpInput);
			System.out.println(getXMLData("InvalidName"));
			typeValue(AccountLookUpPage.lookUpInput,getXMLData("InvalidName"));
			log.info("Entered InvalidName as Customer Look Up Value");	
			Thread.sleep(5000);
						
		}catch (Exception e) {
			log.error("GOT EXCEPTION in invalidName(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I enter invalid phone number$")
	public void invalidphone() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter invalid phone number", "INFO");
			Thread.sleep(5000);			
			clickElement(AccountLookUpPage.lookUpInput);
			System.out.println(getXMLData("InvalidPhone"));
			typeValue(AccountLookUpPage.lookUpInput,getXMLData("InvalidPhone"));
			log.info("Entered InvalidPhone as Customer Look Up Value");	
			Thread.sleep(5000);
						
		}catch (Exception e) {
			log.error("GOT EXCEPTION in invalidphone(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see no records message$") 
	public void noRecords() {
		try {
			ExtentReporter.reportStep("BDD Step: I see no records message", "INFO");
			verifyText("No results found. Please try again.");
			log.info("No results found for the searched input");	
			Thread.sleep(5000);
						
		}catch (Exception e) {
			log.error("GOT EXCEPTION in noRecords(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	
		
	
		
	@When("^I enter invalid account number$")
	public void invalidAccountNumber() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter invalid account number", "INFO");
			Thread.sleep(5000);
			clickElement(AccountLookUpPage.lookUpInput);
			typeValue(AccountLookUpPage.lookUpInput,getXMLData("InvalidAccountNumber"));
			log.info("Entered Invalid account number");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in invalidAccountNumber(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
	}	
	}
	@Given("^agent looks for an eligible customer with single active line$")
	public void customerLookup_activelines() throws Exception{
		try {
			ExtentReporter.reportStep("BDD Step: agent looks for an eligible customer with single active line", "INFO");
//			Thread.sleep(4000);
			enterValidAcctNumber();
			clickOnLookUp();
			acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
		
		if(isElementDisplayed(CustomerInfoPage.dobField,10))
		{
		custMoreInfoObj.enterValidDOB();
		}
		
		custMoreInfoObj.enterValidSSN();
		if(isElementDisplayed(CustomerInfoPage.deviceSection,10))
		{
		custMoreInfoObj.selectValidLines();
		verifyText("existing lines");
		}
		custMoreInfoObj.clickSubmit();
		
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account_LookUp_customerLookup(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I redirected to account lookup$")
	public void redirected_accountlookup() throws Exception 
	{
		try{
			isElementDisplayed(AccountLookUpPage.lookUP_header,5);
		
		log.info("Back to Profile button is clicked");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}

	
}



	
			


	

package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.CustomerPreSignaturePage;
import com.retail.pageObjects.SignaturePage;

import cucumber.api.java.en.*;


public class CustomerPreSignature extends CustomerPreSignaturePage{

	private static Logger log = Logger.getLogger(CustomerPreSignature.class);
	
	//CheckOut for a customer
	@Then("^I see estimated monthly charges$")	
	public  void verifyEstimatedcharges() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see estimated monthly charges", "INFO");
			String estimatedChargesToday=getValue(CustomerPreSignaturePage.estimatedChargesToday);
	        verifyText(estimatedChargesToday);
	      
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	@When("^I see  same as service address is checked$")	
	public  void checkServiceAddress() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: When I see  same as service address is checked", "INFO");
			Thread.sleep(5000);
			if(isElementDisplayed(CustomerPreSignaturePage.firstName,5)){
			String firstName = getDriver().findElement(CustomerPreSignaturePage.firstName).getAttribute("value");			
			if((firstName.isEmpty()))
		    {					
				clickElement(CustomerPreSignaturePage.sameServiceAddress);
		    }
			//clickElement(CustomerPreSignaturePage.sameServiceAddress);			
			log.info("Same as service address check box is checked");
		}}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see billing address is autopopulated$")	
	public  void verifyBillingAddress() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see billing address is autopopulated", "INFO");
			if(isElementDisplayed(CustomerPreSignaturePage.firstName,5)){
				String firstName=getValue(CustomerPreSignaturePage.firstName);
			    String lastName=getValue(CustomerPreSignaturePage.lastName);
			    String Address1=getValue(CustomerPreSignaturePage.address1);
			    //String Address2=getValue(CustomerPreSignaturePage.address2);
			    String city=getValue(CustomerPreSignaturePage.city);
			    String state=getValue(CustomerPreSignaturePage.state);
			    String zipcode=getValue(CustomerPreSignaturePage.zipcode);
			    if((!firstName.isEmpty()) && (!lastName.isEmpty()) && (!Address1.isEmpty())  && (!city.isEmpty()) &&(!state.isEmpty()) && (!zipcode.isEmpty()))
			    {
			    	ExtentReporter.reportStep(getDriver(), "Billing Address is autopopulated.", "PASS",  1);
			    }
			log.info("Billing Address is verified.");
		}}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I save billing address$")	
	public  void saveBillingAddress() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: When I save billing address", "INFO");
			Thread.sleep(6000);
			if(isElementDisplayed(CustomerPreSignaturePage.firstName,5)){
			clickElement(CustomerPreSignaturePage.save_billingAddress);			
			log.info("save button in billing address is clicked");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see billing address is saved$")	
	public  void billingAddressSaved() throws Exception {
		try {
				ExtentReporter.reportStep("BDD Step: Then I see billing address is saved", "INFO");
				if(isElementDisplayed(CustomerPreSignaturePage.firstName,5)){
				clickElement(CustomerPreSignaturePage.updateAddressRecommended);
				clickElement(CustomerPreSignaturePage.update_billingAddress);
				}
				isElementDisplayed(CustomerPreSignaturePage.edit_billingAddress,5);				
				log.info("billing address is saved");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I enter valid information for credit card details$")	
	public  void validCreditCardDetails() throws Exception {
		try {			
			ExtentReporter.reportStep("BDD Step: When I enter valid information for credit card details", "INFO");
	
			if(isElementDisplayed(CustomerPreSignaturePage.edit_paymentAddress,5))
			{				
		
				log.info("Credit information is saved already");
			}
			else
			{
				switchToFrame(0);
			clickElement(CustomerPreSignaturePage.creditCardNumber);
			System.out.println(getXMLData("CreditCardNumber"));
	        typeValue(CustomerPreSignaturePage.creditCardNumber,getXMLData("CreditCardNumber"));
	        clickElement(CustomerPreSignaturePage.expiration);
	        typeValue(CustomerPreSignaturePage.expiration,getXMLData("Expiration"));
	        clickElement(CustomerPreSignaturePage.cvv);
	        typeValue(CustomerPreSignaturePage.cvv,getXMLData("CVV"));
	    	exitFrame();
	        clickElement(CustomerPreSignaturePage.save_creditCard);
		
	       
				log.info("I enter valid information for credit card details");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the credit details are saved$")	
	public static void creditDetailsSaved() throws Exception {
		try {
			if(isElementDisplayed(CustomerPreSignaturePage.edit_paymentAddress,10)){			
				log.info("credit details are saved");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I give valid email address and phone number$")	
	public  void validContactDetails() throws Exception {
		try {
			if(isElementDisplayed(CustomerPreSignaturePage.edit_contactInfo,5))
			{
			log.info("Contact information is saved already");
			}
			if(isElementDisplayed(CustomerPreSignaturePage.Email_Address,5)){
				  	clickElement(CustomerPreSignaturePage.Email_Address);
			        getDriver().findElement(CustomerPreSignaturePage.Email_Address).clear();
			        typeValue(CustomerPreSignaturePage.Email_Address,getXMLData("Email_Address"));
			        clickElement(CustomerPreSignaturePage.phone_Number);
			        typeValue(CustomerPreSignaturePage.phone_Number,getXMLData("Phone_Number"));
			        clickElement(CustomerPreSignaturePage.save_contactInfo);
			        log.info("I enter valid information for contact");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the contact information is saved$")	
	public static void contactDetailsSaved() throws Exception {
		try {		
				isElementDisplayed(CustomerPreSignaturePage.edit_contactInfo,10);					
				log.info("contact details are saved");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I select the check in information is correct$")	
	public  void CheckInfo() throws Exception {
		try {
			Thread.sleep(7000);
	        clickElement(CustomerPreSignaturePage.verify_info);
	        log.info("I select the check in information is correct");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see collect signature button in Customer_Pre signature$")	
	public  void CollectSignature() throws Exception {
		try {
	        clickElement(CustomerPreSignaturePage.collect_signature);
	        log.info("I see collect signature button in Customer_Pre signature");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^agent sees the billing address details along with payment & contact info$")	
	public  void verifyDetails() throws Exception {
		try {		
			checkServiceAddress();
			verifyBillingAddress();
			saveBillingAddress();
			billingAddressSaved();
			validCreditCardDetails();
			creditDetailsSaved();
			validContactDetails();
			contactDetailsSaved();
			CheckInfo();
		    CollectSignature();
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@When("^agent submits the order$")
	public  void placeOrder() throws Exception {
		try {		
			//Click On Place Order			
			//clickElement(CustomerPreSignaturePage.placeOrderBtn); 
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page_placeOrder(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
}

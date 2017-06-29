package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.Customer_PreSignaturePage;
import cucumber.api.java.en.*;


public class Customer_PreSignature extends Customer_PreSignaturePage{

	private static Logger log = Logger.getLogger(Customer_PreSignature.class);
	
	//CheckOut for a customer
	@Then("^I see estimated monthly charges$")	
	public  void verifyEstimatedcharges()  {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see estimated monthly charges", "INFO");
			String estimatedChargesToday=getValue(Customer_PreSignaturePage.estimatedChargesToday);
	        verifyText(estimatedChargesToday);
	      
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	@When("^I see  same as service address is checked$")	
	public  void checkServiceAddress()  {
		try {
			ExtentReporter.reportStep("BDD Step: When I see  same as service address is checked", "INFO");
			Thread.sleep(5000);
			clickElement(Customer_PreSignaturePage.sameServiceAddress);
			log.info("Same as service address check box is checked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			
		}
	}
	@Then("^I see billing address is autopopulated$")	
	public  void verifyBillingAddress()  {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see billing address is autopopulated", "INFO");
				String firstName=getValue(Customer_PreSignaturePage.firstName);
			    String lastName=getValue(Customer_PreSignaturePage.lastName);
			    String Address1=getValue(Customer_PreSignaturePage.address1);
			    String Address2=getValue(Customer_PreSignaturePage.address2);
			    String city=getValue(Customer_PreSignaturePage.city);
			    String state=getValue(Customer_PreSignaturePage.state);
			    String zipcode=getValue(Customer_PreSignaturePage.zipcode);
			    if((!firstName.isEmpty()) && (!lastName.isEmpty()) && (!Address1.isEmpty()) &&(!Address2.isEmpty()) && (!city.isEmpty()) &&(!state.isEmpty()) && (!zipcode.isEmpty()))
			    {
			    	System.out.println(" billing address is autopopulated");
			    }
			log.info("Same as service address check box is checked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I save billing address$")	
	public  void saveBillingAddress()  {
		try {
			ExtentReporter.reportStep("BDD Step: When I save billing address", "INFO");
			clickElement(Customer_PreSignaturePage.save_billingAddress);
			log.info("save button in billing address is clicked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see billing address is saved$")	
	public  void billingAddressSaved()  {
		try {
				ExtentReporter.reportStep("BDD Step: Then I see billing address is saved", "INFO");
				clickElement(Customer_PreSignaturePage.updateAddressRecommended);
				clickElement(Customer_PreSignaturePage.update_billingAddress);
				isElementDisplayed(Customer_PreSignaturePage.edit_billingAddress,5);				
				log.info("billing address is saved");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I enter valid information for credit card details$")	
	public  void validCreditCardDetails()  {
		try {			
			ExtentReporter.reportStep("BDD Step: When I enter valid information for credit card details", "INFO");
			if(isElementDisplayed(Customer_PreSignaturePage.edit_paymentAddress,5000))
			{				
				log.info("Credit information is saved already");
			}
			else
			{
			clickElement(Customer_PreSignaturePage.creditCardNumber);
	        typeValue(Customer_PreSignaturePage.creditCardNumber,getExcelData("CreditCardNumber"));
	        clickElement(Customer_PreSignaturePage.expiration);
	        typeValue(Customer_PreSignaturePage.creditCardNumber,getExcelData("Expiration"));
	        clickElement(Customer_PreSignaturePage.cvv);
	        typeValue(Customer_PreSignaturePage.creditCardNumber,getExcelData("CVV"));
	        clickElement(Customer_PreSignaturePage.save_creditCard);
	        log.info("I enter valid information for credit card details");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the credit details are saved$")	
	public static void creditDetailsSaved()  {
		try {
			
				isElementDisplayed(Customer_PreSignaturePage.edit_paymentAddress,5000);				
				log.info("credit details are saved");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I give valid email address and phone number$")	
	public  void validContactDetails()  {
		try {
			if(isElementDisplayed(Customer_PreSignaturePage.edit_contactInfo,5000))
			{
			log.info("Contact information is saved already");
			}
			else{
				  	clickElement(Customer_PreSignaturePage.Email_Address);
			        getDriver().findElement(Customer_PreSignaturePage.Email_Address).clear();
			        typeValue(Customer_PreSignaturePage.Email_Address,getExcelData("Email_Address"));
			        clickElement(Customer_PreSignaturePage.phone_Number);
			        typeValue(Customer_PreSignaturePage.phone_Number,getExcelData("Phone_Number"));
			        clickElement(Customer_PreSignaturePage.save_contactInfo);
			        log.info("I enter valid information for contact");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the contact information is saved$")	
	public static void contactDetailsSaved()  {
		try {
			
				isElementDisplayed(Customer_PreSignaturePage.edit_contactInfo,5000);					
				log.info("contact details are saved");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I select the check in information is correct$")	
	public  void CheckInfo()  {
		try {
	        clickElement(Customer_PreSignaturePage.verify_info);
	        log.info("I select the check in information is correct");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see collect signature button in Customer_Pre signature$")	
	public  void CollectSignature()  {
		try {
	        clickElement(Customer_PreSignaturePage.collect_signature);
	        log.info("I see collect signature button in Customer_Pre signature");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^agent sees the billing address details along with payment & contact info$")	
	public  void verifyDetails()  {
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
		}
	}
	
	@When("^agent submits the order$")
	public  void placeOrder()  {
		try {
		
			//Click On Place Order			
			//clickElement(Customer_PreSignaturePage.placeOrderBtn); 
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page_placeOrder(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
}

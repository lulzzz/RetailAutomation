package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.ShoppingCartPage;

import cucumber.api.java.en.*;


public class ShoppingCart extends ShoppingCartPage{

	private static Logger log = Logger.getLogger(ShoppingCart.class);
	
	//CheckOut for a customer
	@When("^I select Continue to Checkout Button$")	
	public  void continueToCheckout() throws Exception  {
		try {
				
			clickElement(ShoppingCartPage.continueToCheckout);			
			log.info("Continue to check out");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	@Then("^I verify the device charges$")
	public  void verifyDeviceCharges() throws Exception {
		try {				
			Thread.sleep(5000);			
			String charges_ShoppingCart=getValue(ShoppingCartPage.estimatedMonthlycost_shoppingcart);
	        verifyText(charges_ShoppingCart);
	        String charges_oneTimeCharge=getValue(ShoppingCartPage.oneTimeCharge_shoppingcart);
	        verifyText(charges_oneTimeCharge);
			log.info("verify Estimated monthly cost");			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
	@Then("^agent does successful checkout$")
	public void successfulcheckout() throws Exception {
		try {			
			continueToCheckout();			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in successfulcheckout(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I select Add another line$")
	public  void add_anotherLine()  {
		try {
	       ExtentReporter.reportStep("BDD Step: When I select Add another line", "INFO");
			clickElement(ShoppingCartPage.add_AnotherLine);
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "PASS", 1);
			
		}catch (Exception e) {
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "Fail", 1);
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I select Add Accessory$")
	public  void add_Accessory()  {
		try {
	       ExtentReporter.reportStep("BDD Step: When I select Add Accessory", "INFO");
			clickElement(ShoppingCartPage.add_Accessory);
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "PASS", 1);
			
		}catch (Exception e) {
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "Fail", 1);
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Browse Accessories Page$")
	public void browseAccessories() throws Exception {
		try {
			verifyText("Accessories");
			log.info("Navigated to Accessories Page");		
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^I am in Shopping cart Page$")
	public void shopping_Cart() {
		try {
			ExtentReporter.reportStep("BDD Step: I am in Shopping cart Page", "INFO");
			clickElement(ShoppingCartPage.cartImage);
			log.info("Cart Image is clicked");
		}
		catch(Exception e) {
			log.error("GOT EXCEPTION in shopping_Cart():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I select Continue Customization$")
	public void continueCustom() {
		try {
			ExtentReporter.reportStep("BDD Step: I select Continue Customization", "INFO");
			clickElement(ShoppingCartPage.continueCustom);
			log.info("Clicked on Continue Customization");
			
		}catch (Exception e) {
			
			log.error("GOT EXCEPTION in continueCustom():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I select Delete Line$")
	public void deleteLine() {
		try {
			ExtentReporter.reportStep("BDD Step: I select Delete Line", "INFO");
			clickElement(ShoppingCartPage.deleteLine);
			log.info("Clicked on Delete Line");
			
		}catch (Exception e) {
			
			log.error("GOT EXCEPTION in deleteLine():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the cart text$")
	public void cartText() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the cart text", "INFO");
			String cartText=getValue(ShoppingCartPage.cartText);
			verifyText(cartText);			
		}
		catch (Exception e) {
			
			log.error("GOT EXCEPTION in cartText():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
}

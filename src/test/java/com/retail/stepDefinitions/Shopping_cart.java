package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Shopping_cartPage;

import cucumber.api.java.en.*;


public class Shopping_cart extends Shopping_cartPage{

	private static Logger log = Logger.getLogger(Shopping_cart.class);
	
	//CheckOut for a customer
	@When("^I select Continue to Checkout Button$")	
	public  void continueToCheckout()  {
		try {
				
			clickElement(Shopping_cartPage.continueToCheckout);			
			log.info("Continue to check out");	
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	@Then("^I verify the device charges$")
	public  void verifyDeviceCharges()  {
		try {				
			Thread.sleep(5000);			
			String charges_ShoppingCart=getValue(Shopping_cartPage.estimatedMonthlycost_shoppingcart);
	        verifyText(charges_ShoppingCart);
	        String charges_oneTimeCharge=getValue(Shopping_cartPage.oneTimeCharge_shoppingcart);
	        verifyText(charges_oneTimeCharge);
			log.info("verify Estimated monthly cost");	
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
	
}

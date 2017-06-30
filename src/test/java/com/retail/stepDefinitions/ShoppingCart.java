package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.ShoppingCartPage;

import cucumber.api.java.en.*;


public class ShoppingCart extends ShoppingCartPage{

	private static Logger log = Logger.getLogger(ShoppingCart.class);
	
	//CheckOut for a customer
	@When("^I select Continue to Checkout Button$")	
	public  void continueToCheckout()  {
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
	public  void verifyDeviceCharges()  {
		try {				
//			Thread.sleep(5000);			
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
	
}

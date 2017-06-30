package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.DeviceConfigPage;


import cucumber.api.java.en.*;


public class DeviceConfig extends DeviceConfigPage{

	private static Logger log = Logger.getLogger(DeviceConfig.class);	
	DeviceCustomize deviceCustomizeObj= new DeviceCustomize();
	ShoppingCart shopcart= new ShoppingCart();
	
	@When("^I choose a payment plan, Full or Monthly$")	
	public void paymentplan() throws Exception {
		try {
			WebOperations.verifyText("CHOOSE A PAYMENT PLAN");
			String paymentplan= getXMLData("PaymentPlan").toUpperCase();
			log.info(paymentplan);
			if(paymentplan.equalsIgnoreCase("Pay In Full"))
			{				
				clickElement(DeviceConfigPage.pay_in_full);
				log.info("Clicked Pay in Full Payment Plan");
				
			}else if(paymentplan.equalsIgnoreCase("Pay Monthly"))
			{
				clickElement(DeviceConfigPage.pay_monthly);
				log.info("Clicked Pay Monthly Payment Plan");
			}			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in paymentplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}

	@When("^I choose to have device protection or not$")
	public void protectionplan() throws Exception {
		try {
			WebOperations.verifyText("CHOOSE DEVICE PROTECTION");
			String deviceprotection= getXMLData("DeviceProtection").toUpperCase();
			log.info(deviceprotection);
			if(deviceprotection.equalsIgnoreCase("withXMPP"))
			{				
				clickElement(DeviceConfigPage.XMPP);
				log.info("Clicked XMPP Device Protection");
				
			}else if(deviceprotection.equalsIgnoreCase("withoutXMPP"))
			{
				clickElement(DeviceConfigPage.noXMPP);
				log.info("Clicked No XMPP");
			}
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in protectionplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}

	@When("^I choose the data plan, By the Gig or Unlimited$")
	public void dataplan() throws Exception {
		try {
			WebOperations.verifyText("CHOOSE A DATA OPTION");
			String dataoption= getXMLData("DataOption").toUpperCase();
			log.info(dataoption);
			if(dataoption.equalsIgnoreCase("Unlimited"))
			{				
				clickElement(DeviceConfigPage.unlimited);
				log.info("Clicked Unlimited Data option");
				
			}else if(dataoption.equalsIgnoreCase("By the Gig"))
			{
				clickElement(DeviceConfigPage.by_the_gig);
				log.info("Clicked By the Gig Data option");
			}
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in dataplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Next button in DeviceConfig$")
	public void nextdeviceconfig() throws Exception {
		try {
			clickElement(DeviceConfigPage.nextbutton);		
		}catch (Exception e) {
			log.error("GOT EXCEPTION in nextdeviceconfig(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	

	@When("^agent chooses data plan with number selection to do successful checkout$")
	public void deviceConfig() throws Exception
	{
		try{
		paymentplan();
		protectionplan();
		dataplan();
		nextdeviceconfig();	
		deviceCustomizeObj.choosenumber();
		deviceCustomizeObj.name();
		deviceCustomizeObj.addtocart();
		shopcart.verifyDeviceCharges();
		shopcart.continueToCheckout();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}

}
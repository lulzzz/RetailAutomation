package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Device_ConfigPage;


import cucumber.api.java.en.*;


public class Device_Config extends Device_ConfigPage{

	private static Logger log = Logger.getLogger(Device_Config.class);	
	Device_Customize deviceCustomizeObj= new Device_Customize();
	Shopping_cart shopcart= new Shopping_cart();
	
	@When("^I choose a payment plan, Full or Monthly$")	
	public void paymentplan()  {
		try {
			WebOperations.verifyText("CHOOSE A PAYMENT PLAN");
			String paymentplan= getXMLData("PaymentPlan").toUpperCase();
			log.info(paymentplan);
			if(paymentplan.equalsIgnoreCase("Pay In Full"))
			{				
				clickElement(Device_ConfigPage.pay_in_full);
				log.info("Clicked Pay in Full Payment Plan");
				
			}else if(paymentplan.equalsIgnoreCase("Pay Monthly"))
			{
				clickElement(Device_ConfigPage.pay_monthly);
				log.info("Clicked Pay Monthly Payment Plan");
			}			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in paymentplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}

	@When("^I choose to have device protection or not$")
	public void protectionplan()  {
		try {
			WebOperations.verifyText("CHOOSE DEVICE PROTECTION");
			String deviceprotection= getXMLData("DeviceProtection").toUpperCase();
			log.info(deviceprotection);
			if(deviceprotection.equalsIgnoreCase("withXMPP"))
			{				
				clickElement(Device_ConfigPage.XMPP);
				log.info("Clicked XMPP Device Protection");
				
			}else if(deviceprotection.equalsIgnoreCase("withoutXMPP"))
			{
				clickElement(Device_ConfigPage.noXMPP);
				log.info("Clicked No XMPP");
			}
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in protectionplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}

	@When("^I choose the data plan, By the Gig or Unlimited$")
	public void dataplan()  {
		try {
			WebOperations.verifyText("CHOOSE A DATA OPTION");
			String dataoption= getXMLData("DataOption").toUpperCase();
			log.info(dataoption);
			if(dataoption.equalsIgnoreCase("Unlimited"))
			{				
				clickElement(Device_ConfigPage.unlimited);
				log.info("Clicked Unlimited Data option");
				
			}else if(dataoption.equalsIgnoreCase("By the Gig"))
			{
				clickElement(Device_ConfigPage.by_the_gig);
				log.info("Clicked By the Gig Data option");
			}
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in dataplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I click on Next button in DeviceConfig$")
	public void nextdeviceconfig()  {
		try {
			clickElement(Device_ConfigPage.nextbutton);		
		}catch (Exception e) {
			log.error("GOT EXCEPTION in nextdeviceconfig(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}

	@When("^agent chooses data plan with number selection to do successful checkout$")
	public void deviceConfig() throws InterruptedException
	{
		paymentplan();
		protectionplan();
		dataplan();
		nextdeviceconfig();	
		deviceCustomizeObj.choosenumber();
		deviceCustomizeObj.name();
		deviceCustomizeObj.addtocart();
		shopcart.verifyDeviceCharges();
		shopcart.continueToCheckout();
	}

}
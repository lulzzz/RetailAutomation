package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.*;


import cucumber.api.java.en.*;


public class DeviceConfig extends DeviceConfigPage{

	private static Logger log = Logger.getLogger(DeviceConfig.class);	
	DeviceCustomize deviceCustomizeObj= new DeviceCustomize();
	ShoppingCart shopcart= new ShoppingCart();
	CustomerPreSignaturePage custPage= new CustomerPreSignaturePage();
	AccountLookUp acctlookup= new AccountLookUp();
	AccountDetailsPage acctdetail= new AccountDetailsPage();
	CustomerInfo custinfo= new CustomerInfo();
	DeviceBrand devicebrand= new DeviceBrand();
	BrowseDevice browseDevice= new BrowseDevice();
	
	@When("^I choose a payment plan, Full or Monthly$")	
	public void paymentplan()  {
		try {
			String flag= getXMLData("flag");
		if(flag.equals("H")){
			String paymentplan= getXMLData("PaymentPlan"+DeviceSearch.device_count).toUpperCase();
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
			
		}if(flag.equals("S")){
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
		}
		}
				
		catch (Exception e) {
			log.error("GOT EXCEPTION in paymentplan(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}

@When("^I choose to have device protection or not$")
public void protectionplan()  {
	try {
		String flag= getXMLData("flag");
		if(flag.equals("H")){
		String deviceprotection= getXMLData("DeviceProtection"+DeviceSearch.device_count).toUpperCase();
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
		}
		if(flag.equals("S")){
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
		}
		
	}catch (Exception e) {
		log.error("GOT EXCEPTION in protectionplan(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}

@When("^I choose the data plan, By the Gig or Unlimited$")
public void dataplan()  {
	try {
		String flag= getXMLData("flag");
		if(flag.equals("H")){
		String dataoption= getXMLData("DataOption"+DeviceSearch.device_count).toUpperCase();
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
		
	
		Thread.sleep(5000);}
		if(flag.equals("S")){
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
			Thread.sleep(5000);
		}
		
	}catch (Exception e) {
		log.error("GOT EXCEPTION in dataplan(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
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
	@When("^I click on Cancel button$")
	public void canceldeviceconfig() throws Exception {
		try {
			log.info("Cancel button is clicked");
			clickElement(DeviceConfigPage.cancel_button);		
		}catch (Exception e) {
			log.error("GOT EXCEPTION in deviceconfig(): " + LogUtils.logStackTrace(e));
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
	@When("^agent attempts to checkout$")
	public void checkout() throws Exception 
	{
		try{
		shopcart.verifyDeviceCharges();
		shopcart.continueToCheckout();
	}
		catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^agent attempts to do a successful checkout$")
	public void checkout_Multiple() throws Exception 
	{
		try{
			ExtentReporter.reportStep("BDD Step: And agent attempts to do a successful checkout", "INFO");
		shopcart.continueToCheckout();
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
	}
		catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^agent chooses data plan with number selection$")
	public void deviceSelect() throws Exception
	{
		try{
			ExtentReporter.reportStep("BDD Step:When agent chooses data plan with number selection", "INFO");
		paymentplan();
		protectionplan();
		dataplan();
		nextdeviceconfig();	
		deviceCustomizeObj.choosenumber();
		deviceCustomizeObj.name();
		deviceCustomizeObj.addtocart();
		shopcart.verifyDeviceCharges();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	
	
	
	@Then("^I see the configuration details of the selected device$")
	public void view_configurationDetails() throws Exception
	{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the configuration details of the selected device", "INFO");
			isElementDisplayed(DeviceConfigPage.device_image,5);
			String deviceName=getXMLData("Device_Name");
			String deviceConfig_devicename= getValue(DeviceConfigPage.deviceConfig_devicename);
			if(deviceName.matches(deviceConfig_devicename))
			{
				log.info("Device name is equal both in config and customize page");
			}
			else
			{
				log.error("Device name is not equal both in config and customize page ");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
	
		}
	}
	
	
	@And("^I must see the cost for the plan displayed$")
	public void view_cost_config() throws Exception 
	{
		try{
			ExtentReporter.reportStep("BDD Step: And I must see the cost for the plan displayed", "INFO");
			String cost= getValue(DeviceConfigPage.device_cost_monthly);
			String cost2= getValue(DeviceConfigPage.estimated_cost);
			if(cost.contains(cost2))
			{
				log.info("cost for the plan is displayed");
			}
		 
			
	}
		catch(Exception e){
			log.error("cost for the plan is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}

	@Then("^I see the selected option highlighted$")
	public void view_selected_payment() throws Exception 
	{
		try{
			String choice= getXMLData("choice");
			ExtentReporter.reportStep("BDD Step: Then I see the selected option highlighted", "INFO");
			String highlight="color";
		 if(choice.contains("Payment")){
			highlight = getDriver().findElement(DeviceConfigPage.pay_monthly).getCssValue("background-color");
		 }
		 if(choice.contains("Device"))
				 {
		highlight = getDriver().findElement(DeviceConfigPage.pay_monthly).getCssValue("background-color");
		 }
		 if(choice.contains("Data")){ 
		     highlight = getDriver().findElement(DeviceConfigPage.pay_monthly).getCssValue("background-color");
			 }
			if(highlight.contains("#0272B6"))
			{
				log.info("Element is highlighted");
				
			}
			else
			{
				log.info("Element is not highlighted");	
			}
	}
		catch(Exception e){
			log.error("cost for the plan is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I should be redirected to next page-Device_Customize$")
	public void redirect_DeviceCustomize() throws Exception 
	{
		try{
			isElementDisplayed(deviceCustomizeObj.keep_number,5);
			isElementDisplayed(deviceCustomizeObj.get_new_num,5);
			log.info("redirected to next page-Device_Customize");
			
	}
		catch(Exception e){
			log.error("Not redirected to next page-Device_Customize");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I select plans for payment,device protection and data$")
	public void select_plan() throws Exception 
	{
		try{
			paymentplan();
			protectionplan();
			dataplan();
			log.info("redirected to next page-Device_Customize");
			
	}
		catch(Exception e){
			log.error("Not redirected to next page-Device_Customize");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see a popup,asking the reason for cancellation$")
	public void popup_reason_cancellation() throws Exception 
	{
		try{
			isElementDisplayed(DeviceConfigPage.reason_cancellation,5);
			log.info("Pop up asking reason for cancellation");
			
	}
		catch(Exception e){
			log.error("Pop up id not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Learn more link$")
	public void click_learnmore() throws Exception 
	{
		try{
		log.info("Learn more link is click");
		clickElement(DeviceConfigPage.learn_more);
			
	}
		catch(Exception e){
			log.error("Learn more link is not clicked");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see a popup for XFINITY Mobile Protection Plan appears$")
	public void viewpopup_xmpp() throws Exception 
	{
		try{
		isElementDisplayed(DeviceConfigPage.popup,5);
			
	}
		catch(Exception e){
			log.error("Learn more link is not clicked");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^popup should have Remove Protection plan button$")
	public void view_remove_Protection_plan() throws Exception 
	{
		try{
		isElementDisplayed(DeviceConfigPage.remove_Protection,5);
		log.info("Remove button is displayed in pop up");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^popup should have Add Protection plan button$")
	public void view_add_Protection_plan() throws Exception 
	{
		try{
		isElementDisplayed(DeviceConfigPage.add_Protection,5);
		log.info("add button is displayed in pop up");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I click the link FAQ and Terms and condition$")
	public void view_links_faq_term() throws Exception 
	{
		try{
			clickElement(DeviceConfigPage.faq);
			clickElement(DeviceConfigPage.terms_conditions);
		log.info("Faq,terms and conditions is clicked");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I should be redirected to their pages$")
	public void redirected_terms() throws Exception 
	{
		try{
		isElementDisplayed(DeviceConfigPage.term_nextpage,5);
		log.info("redirected to the term page");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	
	
	@When("^I Click on Back to Profile button$")
	public void click_dropdowm_popup() throws Exception 
	{
		try{
			clickElement(DeviceConfigPage.back_profile);
		
		log.info("Back to Profile button is clicked");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^I see a dropdown listing different reasons for cancellation$")
	public void view_dropdown_cancellation() throws Exception 
	{
		try{
			isElementDisplayed(DeviceConfigPage.dropdownlist_cancellation,5);
		
		log.info("Dropdownlist is  displayed");
			
	}
		catch(Exception e){
			log.error("pop up is not displayed");
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Change Device link$")
	public void click_changeDevice() throws Exception 
	{
		try{
			clickElement(DeviceConfigPage.change_device);
		log.info("Change Device is clicked");
			
	}
		catch(Exception e){
			log.error("Error in DeviceConfig page");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see different options listed- Payment plan,protection plan,data option$")
	public void redirected_DeviceSearch() throws Exception 
	{
		try{
			isElementDisplayed(DeviceConfigPage.pay_monthly,5);
			isElementDisplayed(DeviceConfigPage.by_the_gig,5);
			isElementDisplayed(DeviceConfigPage.XMPP,5);
		log.info("All options are listed");
			
	}
		catch(Exception e){
			log.error("Error in DeviceConfig page");
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^it's redirects to the previous page - Device Search$")
	public void redirected_deviceSearch() throws Exception 
	{
		try{
			isElementDisplayed(DeviceConfigPage.DeviceSearch_title,5);
		
		log.info("redirected to the previous page - Device Search");
			
	}
		catch(Exception e){
			log.error("Error in DeviceConfig page");
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I click on Close icon$")
	public void click_close_learnmore() throws Exception 
	{
		try{
			clickElement(DeviceConfigPage.close_learnmore);
		
		log.info("Close Icon is clicked");
			
	}
		catch(Exception e){
			log.error("Error in DeviceConfig page");
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^the popup should close$")
	public void popUP_closed() throws Exception 
	{
		try{
			isElementDisplayed(DeviceConfigPage.pay_monthly,5);
			isElementDisplayed(DeviceConfigPage.by_the_gig,5);
			isElementDisplayed(DeviceConfigPage.XMPP,5);	
		log.info("Learn more popup is closed");
			
	}
		catch(Exception e){
			log.error("Error in DeviceConfig page");
			e.printStackTrace();
			throw(e);
		}
	}
	
}
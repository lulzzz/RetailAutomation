package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;


import cucumber.api.java.en.*;


public class DeviceBrand extends DeviceBrandPage{

	private static Logger log = Logger.getLogger(DeviceBrand.class);
	AccountDetailsPage acctdetailsPage = new AccountDetailsPage();
	DeviceSearchPage deviceSearch = new DeviceSearchPage();
	
	
@When("^I select a device brand$")	
	public void selectDeviceBrand() throws Exception {
		try {
			String flag=getXMLData("flag");
			System.out.println(flag);
			if(flag.equals("H"))
			{
			String deviceName=getXMLData("DeviceBrandName"+DeviceSearch.device_count);
		     DeviceBrandPage.selectDeviceBrand(deviceName);
			}
			if(flag.equals("S")){
			String deviceName=getXMLData("DeviceBrandName");
		     DeviceBrandPage.selectDeviceBrand(deviceName);
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
@Then("^I am redirected to Browse_Devices page$")
public void redirectedToBrowseDevice() throws Exception{
	try {
		isElementDisplayed(BrowseDevicePage.deviceButton,10);
		log.info("Redirected to Browse_Device Page");
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@When("^agent chooses a specific device$")
public void chooseDevice() throws Exception{
	try{
		selectDeviceBrand();
	redirectedToBrowseDevice();
	//BrowseDevice.selectDevice();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}

@When("^agent chooses a specific accessory category$")
public void chooseAccessory() throws Exception{
	try{
		selectAccessoryCategory();
		redirectedToBrowseAccessories();
	//BrowseDevice.selectDevice();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}
@When("^I select an accessory$")	
public void selectAccessoryCategory() throws Exception {
	try {
		String accessoryName=getXMLData("AccessoryCategory");
	     DeviceBrandPage.selectAccessoryCategory(accessoryName);
	}catch (Exception e) {
		log.error("GOT EXCEPTION in selectAccessoryCategory(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@When("^I click on View catalog link for Phones by Brand$")	
public void click_Catalog() throws Exception {
	try {
     ExtentReporter.reportStep("BDD: When I click on View catalog link for Phones by Brand","INFO");
     wait(30);
     clickElement(DeviceBrandPage.viewCatalog_device);
     ExtentReporter.reportStep(getDriver(),"View catalog is clicked","PASS",1);
	}catch (Exception e) {
		log.error("GOT EXCEPTION in selectAccessoryCategory(): " + LogUtils.logStackTrace(e));
		ExtentReporter.reportStep(getDriver(),"View catlaog is clicked","PASS",0);
		e.printStackTrace();
		throw(e);
	}
}

@Then("^I am redirected to Browse_Accessories page$")
public void redirectedToBrowseAccessories() throws Exception{
	try {
		isElementDisplayed(BrowseAccessoryPage.accessoryButton,10);
		log.info("Redirected to Browse_Accessories Page");
	}catch (Exception e) {
		log.error("GOT EXCEPTION in redirectedToBrowseAccessories(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@When("^I click on View catalog link for Accessories by Category$")
public void viewCatalog() {
	try {
  ExtentReporter.reportStep("BDD: When I click on View catalog link for Accessories by Category","INFO");
		wait(30);
	clickElement(DeviceBrandPage.ViewCatalog);
	log.info("Clicked View Catalog");
	}

	catch (Exception e) {
	log.error("GOT EXCEPTION in viewCatalog(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
	throw(e);
}
}
@Then("^I am in Device_Brands page$")
public void Device_Brand() throws Exception 
{
	try{
		isElementDisplayed(DeviceBrandPage.PhoneByBrand,5);
	log.info("In Device_Brands page");
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@Then("^I see tabs- Phones by Brand and Accessory$")
public void tabs_deviceBrand() throws Exception 
{
	try{
		isElementDisplayed(DeviceBrandPage.PhoneByBrand,5);
		 ExtentReporter.reportStep(getDriver(), "Phone By Brand is displayed","INFO", 0);
	   
	log.info("Tabs in device page is displayed");
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@When("^I do not select any device$")
public void no_device() throws Exception 
{
	try{
	   String value= getValue(DeviceBrandPage.carticonvalue);
	   if(value.isEmpty())
	   {
		   ExtentReporter.reportStep(getDriver(), "Device is not present","INFO", 0);
	   }
	   else
	   {
		   ExtentReporter.reportStep(getDriver(), "Device is present","FAIL", 0);
	   }
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@And("^add device to cart$")
public void add_cart_DeviceBrand() throws Exception 
{
	try{
	   String value= getValue(DeviceBrandPage.carticonvalue);
	   if(value.isEmpty())
	   {
		   ExtentReporter.reportStep(getDriver(), "Device is not present","FAIL", 0);
	   }
	   else
	   {
		   ExtentReporter.reportStep(getDriver(), "Device is present","PASS", 0);
	   }
	   clickElement(DeviceBrandPage.cust_name);
	   clickElement(acctdetailsPage.launchMobileBtn);
	   clickElement(deviceSearch.verifybutton);
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@Then("^I see the Accessory is displayed$")
public void accessory_displayed() throws Exception 
{
	try{
	    
	   if(isElementDisplayed(DeviceBrandPage.AccesoryByCategory,5))
	   {
		   ExtentReporter.reportStep(getDriver(), "Accessory is Displayed","PASS", 0);
	   }
	   else
	   {
		   ExtentReporter.reportStep(getDriver(), "Accessory is not displayed","FAIL", 0);
	   }
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@Then("^I do not see any accessory$")
public void accessory_notvisible_text() throws Exception 
{
	try{
	   if(isElementDisplayed(DeviceBrandPage.accessory_hidden_text,5))
	   {
		   ExtentReporter.reportStep(getDriver(), "Accessory is not present","INFO", 0);
	   }
	   else
	   {
		   ExtentReporter.reportStep(getDriver(), "Accessory is present","FAIL", 0);
	   }
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@And("^I am not able to select any accessory$")
public void accessory_notvisible() throws Exception 
{
	try{
	   if(isElementDisplayed(DeviceBrandPage.accessory_hidden,5))
	   {
		   ExtentReporter.reportStep(getDriver(), "Accessory is not present","INFO", 0);
	   }
	   else
	   {
		   ExtentReporter.reportStep(getDriver(), "Accessory is present","FAIL", 0);
	   }
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@And("^I select an Accessory brand$")
public void select_Accessory() throws Exception 
{
	try{
		String deviceName=getXMLData("AccessoryBrandName");
	    DeviceBrandPage.selectAccessoryCategory(deviceName);
	  ExtentReporter.reportStep(getDriver(),"Accesory brand is selected", "INFO", 0);
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
}

package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.retail.pageObjects.DeviceBrandPage;
import com.retail.pageObjects.DeviceSearchPage;

import cucumber.api.java.en.*;


public class DeviceSearch extends DeviceSearchPage{

	private static Logger log = Logger.getLogger(DeviceSearch.class);
	AccountLookUp accountlookup = new AccountLookUp();
	AccountDetails acctDetailsObj= new AccountDetails();
	CustomerInfo custMoreInfoObj= new CustomerInfo();
		
@When("^I enter valid IMEI with 15 digits$")	
	public void validIMEI() throws Exception {
		try {
			clickElement(DeviceSearchPage.IMEInum);
			log.info("Clicked on IMEI");	
			System.out.println(getXMLData("IMEInumber"));
			typeValue(DeviceSearchPage.IMEInum,getXMLData("IMEInumber"));
			log.info("Entered IMEI number");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in validIMEI(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	

@Then("^I click on Search button$") 
	public void searchbutton() throws Exception {
	try {
		clickElement(DeviceSearchPage.searchbutton);
		log.info("Clicked on search button");	
//		Thread.sleep(5000);	
		
	}catch (Exception e) {
		log.error("GOT EXCEPTION in searchbutton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}	

@Then("^I should see a Popup with Device details$")
	public void devicedetails() throws Exception {
	try {
		//WebOperations.verifyText("Sim Number");
		log.info("Device Search Page contains SIM NUMBER text");			
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in devicedetails(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@When("^I enter valid SIM number with 20 digits$")
public void validSIMnumber() throws Exception {
	try {	
		
		if(isElementDisplayed(DeviceSearchPage.editsim, 5))
		{
				clickElement(DeviceSearchPage.editsim);
				log.info("Clicked on Edit SIM");
//				Thread.sleep(2000);
//				System.out.println(getXMLData("SIMnumber"));
				clickElement(DeviceSearchPage.SIMnum);
				log.info("Clicked on SIM number");	
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"));				
				log.info("Entered SIM number");	

	}
		else
		{			
			clickElement(DeviceSearchPage.SIMnum);
			log.info("Clicked on SIM number");	
			System.out.println(getXMLData("SIMnumber"));
			typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"));
			log.info("Entered SIM number");	
		}		
					
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in validSIMnumber(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@Then("^I click on Next button$")
public void nextbutton() throws Exception {
	try {
		clickElement(DeviceSearchPage.nextbutton);
		log.info("Clicked on next button");	
//		Thread.sleep(5000);				
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in nextbutton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@And("^agent scans the device$")
		public void scanDevice() throws Exception
	{
		try{
		validIMEI();
		searchbutton();
		devicedetails();
		validSIMnumber();
		nextbutton();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
		
	}

@When("^I click on Verify Button$") 
public void clickVerify() throws Exception {
try {
	clickElement(DeviceSearchPage.verifybutton);
	log.info("Clicked on verify button");	
	
}catch (Exception e) {
	log.error("GOT EXCEPTION in verifybutton(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
	throw(e);
}
}

@Then("^I should get redirected to Device_Brands page$")
public void redirectToDevicBrand() throws Exception {
try {
	isElementDisplayed(DeviceBrandPage.PhoneByBrand,10);
	log.info("Verify Device Button");	
	
}catch (Exception e) {
	log.error("GOT EXCEPTION in verifybutton(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
	throw(e);
}
}
	
@Given("^agent navigates to 'verify' link to shop for a device$")
public void verifylink() throws Exception{
	try{
		accountlookup.enterValidAcctNumber();
	accountlookup.clickOnLookUp();
	accountlookup.acctDetailsPageLaunch();
	acctDetailsObj.launchMobile();
	custMoreInfoObj.enterValidDOB();	
	custMoreInfoObj.enterValidSSN();
	custMoreInfoObj.selectValidLines();
	clickVerify();
	redirectToDevicBrand();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}
}

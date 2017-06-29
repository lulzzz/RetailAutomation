package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Device_BrandPage;
import com.retail.pageObjects.Device_SearchPage;

import cucumber.api.java.en.*;


public class Device_Search extends Device_SearchPage{

	private static Logger log = Logger.getLogger(Device_Search.class);
	Account_LookUp accountlookup = new Account_LookUp();
	Account_Details acctDetailsObj= new Account_Details();
	Customer_MoreInfo custMoreInfoObj= new Customer_MoreInfo();
		
@When("^I enter valid IMEI with 15 digits$")	
	public void validIMEI()  {
		try {
			clickElement(Device_SearchPage.IMEInum);
			log.info("Clicked on IMEI");	
			System.out.println(getXMLData("IMEInumber"));
			typeValue(Device_SearchPage.IMEInum,getXMLData("IMEInumber"));
			log.info("Entered IMEI number");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in validIMEI(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	

@Then("^I click on Search button$") 
	public void searchbutton()  {
	try {
		clickElement(Device_SearchPage.searchbutton);
		log.info("Clicked on search button");	
		Thread.sleep(5000);	
		
	}catch (Exception e) {
		log.error("GOT EXCEPTION in searchbutton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}	

@Then("^I should see a Popup with Device details$")
	public void devicedetails()  {
	try {
		WebOperations.verifyText("SIM NUMBER");
		log.info("Device Search Page contains SIM NUMBER text");			
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in devicedetails(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}

@When("^I enter valid SIM number with 20 digits$")
public void validSIMnumber()  {
	try {	
		
		if(isElementDisplayed(Device_SearchPage.editsim, 5))
		{
				clickElement(Device_SearchPage.editsim);
				log.info("Clicked on Edit SIM");
				Thread.sleep(2000);
				System.out.println(getXMLData("SIMnumber"));
				clickElement(Device_SearchPage.SIMnum);
				log.info("Clicked on SIM number");	
				typeValue(Device_SearchPage.SIMnum,getXMLData("SIMnumber"));				
				log.info("Entered SIM number");	

	}
		else
		{			
			clickElement(Device_SearchPage.SIMnum);
			log.info("Clicked on SIM number");	
			System.out.println(getXMLData("SIMnumber"));
			typeValue(Device_SearchPage.SIMnum,getXMLData("SIMnumber"));
			log.info("Entered SIM number");	
		}		
					
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in validSIMnumber(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}

@Then("^I click on Next button$")
public void nextbutton()  {
	try {
		clickElement(Device_SearchPage.nextbutton);
		log.info("Clicked on next button");	
		Thread.sleep(5000);				
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in nextbutton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}

@And("^agent scans the device$")
		public void scanDevice()
	{
		validIMEI();
		searchbutton();
		devicedetails();
		validSIMnumber();
		nextbutton();
		
	}

@When("^I click on Verify Button$") 
public void clickVerify()  {
try {
	clickElement(Device_SearchPage.verifybutton);
	log.info("Clicked on verify button");	
	
}catch (Exception e) {
	log.error("GOT EXCEPTION in verifybutton(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
}
}

@Then("^I should get redirected to Device_Brands page$")
public void redirectToDevicBrand()  {
try {
	isElementDisplayed(Device_BrandPage.PhoneByBrand,5000);
	log.info("Verify Device Button");	
	
}catch (Exception e) {
	log.error("GOT EXCEPTION in verifybutton(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
}
}
	
@Given("^agent navigates to 'verify' link to shop for a device$")
public void verifylink(){
	accountlookup.enterValidAcctNumber();
	accountlookup.clickOnLookUp();
	accountlookup.acctDetailsPageLaunch();
	acctDetailsObj.launchMobile();
	custMoreInfoObj.enterValidDOB();	
	custMoreInfoObj.enterValidSSN();
	custMoreInfoObj.selectValidLines();
	clickVerify();
	redirectToDevicBrand();
	
}
}

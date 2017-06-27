package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.Device_SearchPage;

import cucumber.api.java.en.*;


public class Device_Search extends WebOperations{

	private static Logger log = Logger.getLogger(Device_Search.class);
		
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
		String Edit_Sim =getXMLData("EditSIM");
		
		if(checkElement(Device_SearchPage.editsim))
		{
			if(Edit_Sim.equalsIgnoreCase("Yes"))
			{				
				clickElement(Device_SearchPage.editsim);
				log.info("Clicked on Edit SIM");	
				typeValue(Device_SearchPage.SIMnum,getXMLData("SIMnumber"));				
				log.info("Entered SIM number");	
			}else
			{							
				log.info("Unedited Sim Number");	
			}
		}else
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
	
}

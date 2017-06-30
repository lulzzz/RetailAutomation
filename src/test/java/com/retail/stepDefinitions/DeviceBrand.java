package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;


import cucumber.api.java.en.*;


public class DeviceBrand extends DeviceBrandPage{

	private static Logger log = Logger.getLogger(DeviceBrand.class);
	BrowseDevice BrowseDevice = new BrowseDevice();
	
	
@When("^I select a device$")	
	public void selectDeviceBrand() throws Exception {
		try {
			String deviceName=getXMLData("DeviceBrandName");
		     DeviceBrandPage.selectDeviceBrand(deviceName);
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
@Then("^Then I am redirected to Browse_Devices page$")
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
}

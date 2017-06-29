package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;


import cucumber.api.java.en.*;


public class Device_Brand extends Device_BrandPage{

	private static Logger log = Logger.getLogger(Device_Brand.class);
	Browse_Device BrowseDevice = new Browse_Device();
	
	
@When("^I select a device$")	
	public void selectDeviceBrand()  {
		try {
			String deviceName=getXMLData("DeviceBrandName");
		     Device_BrandPage.selectDeviceBrand(deviceName);
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
@Then("^Then I am redirected to Browse_Devices page$")
public void redirectedToBrowseDevice(){
	try {
		isElementDisplayed(Browse_DevicePage.deviceButton,5000);
		log.info("Redirected to Browse_Device Page");
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
@When("^agent chooses a specific device$")
public void chooseDevice(){
	selectDeviceBrand();
	redirectedToBrowseDevice();
	//BrowseDevice.selectDevice();
}
}

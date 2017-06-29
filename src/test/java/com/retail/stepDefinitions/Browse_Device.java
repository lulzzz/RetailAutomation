package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;

public class Browse_Device extends Browse_DevicePage{

	private static Logger log = Logger.getLogger(Browse_Device.class);	
	
@When("^Click on any Device in catalog$")	
	public void selectDevice_Verify()  {
		try {
			ExtentReporter.reportStep("BDD Step: When Click on any Device in catalog", "INFO");
			String deviceName=getXMLData("Device_Name");
		     Browse_DevicePage.selectDevice(deviceName);
		     log.info("Click on any Device");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
@And("^Select Color$")	
public void selectColor_Verify()  {
	try {
		ExtentReporter.reportStep("BDD Step: And Select Color", "INFO");
		//String deviceColor=getXMLData("Color");
	    // Browse_DevicePage.selectColor(deviceColor);
		clickElement(Browse_DevicePage.deviceColor);
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
@And("^Select Storage$")	
public void selectStorage_Verify()  {
	try {
		ExtentReporter.reportStep("BDD Step: And Select Storage", "INFO");
		String deviceCapacity=getXMLData("Capacity");
	     Browse_DevicePage.selectCapacity(deviceCapacity);
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
@Then("^Verify total amount$")	
public void verifyTotalAmount()  {
	try {
		 ExtentReporter.reportStep("BDD Step: Then Verify total amount", "INFO");
	     checkElement(Browse_DevicePage.Total);
	     
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
@Then("^Click on Select$")	
public void clickSelect()  {
	try {
		ExtentReporter.reportStep("BDD Step: Then Click on Select", "INFO");
	     clickElement(Browse_DevicePage.deviceSelect);	     
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
@And("^it redirects to Device_Config page$")	
public void redirectToDeviceConfig()  {
	try {
		ExtentReporter.reportStep("BDD Step: And it redirects to Device_Config page", "INFO");
	     clickElement(Browse_DevicePage.deviceSelect);
	     
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
@Then("^agent selects the device color and capacity$")
public void agentSelect(){
	ExtentReporter.reportStep("BDD Step: Then agent selects the device color and capacity", "INFO");
	selectDevice_Verify();
	selectStorage_Verify();
	selectColor_Verify();
	verifyTotalAmount();
	clickSelect();
}
}

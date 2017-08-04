package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;

public class BrowseDevice extends BrowseDevicePage{

	private static Logger log = Logger.getLogger(BrowseDevice.class);	
	DeviceBrand devicebrand = new DeviceBrand();
	
@When("^Click on any Device in catalog$")	
	public void selectDevice_Verify()  throws Exception{
		try 
		{
			String flag=getXMLData("flag");
				if(flag.equals("H"))
				{
				ExtentReporter.reportStep("BDD Step: When Click on any Device in catalog", "INFO");
				String deviceName=getXMLData("Device_Name"+DeviceSearch.device_count);
			     BrowseDevicePage.selectDevice(deviceName);
			     log.info("Click on any Device");
				}
				if(flag.equals("S")){
					String deviceName=getXMLData("Device_Name");
				     BrowseDevicePage.selectDevice(deviceName);
				     log.info("Click on any Device");
				}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
@And("^Select Color$")	
public void selectColor_Verify()  throws Exception{
	try {
		ExtentReporter.reportStep("BDD Step: And Select Color", "INFO");
		String flag=getXMLData("flag");		
		if(flag.equals("H"))
		{
		String deviceColor=getXMLData("Color"+DeviceSearch.device_count);
	    BrowseDevicePage.selectColor(deviceColor);
		}
		if(flag.equals("S"))
		{
		String deviceColor=getXMLData("Color");
	    BrowseDevicePage.selectColor(deviceColor);
		}
		//clickElement(BrowseDevicePage.deviceColor);
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@And("^Select Storage$")	
public void selectStorage_Verify() throws Exception {
	try {
		String flag=getXMLData("flag");		
		if(flag.equals("H"))
		{
		ExtentReporter.reportStep("BDD Step: And Select Storage", "INFO");
		String deviceCapacity=getXMLData("Capacity"+DeviceSearch.device_count);
	     BrowseDevicePage.selectCapacity(deviceCapacity);
		}
		if(flag.equals("S")){
			ExtentReporter.reportStep("BDD Step: And Select Storage", "INFO");
			String deviceCapacity=getXMLData("Capacity");
		     BrowseDevicePage.selectCapacity(deviceCapacity);
		}
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@Then("^Verify total amount$")	
public void verifyTotalAmount() throws Exception {
	try {
		 ExtentReporter.reportStep("BDD Step: Then Verify total amount", "INFO");
	     //checkElement(BrowseDevicePage.Total);
	     
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@Then("^Click on Select$")	
public void clickSelect() throws Exception {
	try {
		ExtentReporter.reportStep("BDD Step: Then Click on Select", "INFO");
		System.out.println("Click on Select");
		if(getXMLData("NumberOfLines").contains("Accessories"))
		{	
			System.out.println("If part");
			clickElement(BrowseAccessoryPage.accessorySelectBtn);
		}else
		{
			System.out.println("Else part");
			clickElement(BrowseDevicePage.deviceSelect);
		}
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@And("^it redirects to Device_Config page$")	
public void redirectToDeviceConfig() throws Exception {
	try {
		ExtentReporter.reportStep("BDD Step: And it redirects to Device_Config page", "INFO");
	     clickElement(BrowseDevicePage.deviceSelect);
	     
	}catch (Exception e) {
		log.error("GOT EXCEPTION in Device_Brand(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@Then("^agent selects the device color and capacity$")
public void agentSelect() throws Exception{
	try{
	ExtentReporter.reportStep("BDD Step: Then agent selects the device color and capacity", "INFO");
	selectDevice_Verify();
	selectStorage_Verify();
	selectColor_Verify();
	verifyTotalAmount();
	clickSelect();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}

@When("^I select a device with its customization through ship flow$")
public void select_device_customize_ship() throws Exception
{
	try{
		ExtentReporter.reportStep("BDD Step: When I select a device with its customization through ship flow", "INFO");
		devicebrand.selectDeviceBrand();
		devicebrand.redirectedToBrowseDevice();
		agentSelect();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
}

}
@When("^I select a device$")
public void device_select_config() throws Exception 
{
	try{
	   agentSelect();
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@Given("^I am in Device Catalog page$")
public void device_catalog() throws Exception 
{
	try{
	  if(isElementDisplayed(BrowseDevicePage.deviceButton,5))
	  {
			ExtentReporter.reportStep(getDriver(),"Device Catalog page is displayed", "INFO",0);
	  }
	  else
	  {
			ExtentReporter.reportStep(getDriver(),"Device Catalog page is not displayed", "INFO",0);
	  }
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@And("^Click on Accessory in catalog page$")
public void click_Accessory_browseDevice() throws Exception 
{
	try{
		ExtentReporter.reportStep("BDD: And Click on Accessory in catalog page", "INFO");
	 clickElement(BrowseDevicePage.accessoryButton);
		
	  
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
@Then("^it redirects to Browse_Accessories page$")
public void redirected_Browse_accesories() throws Exception 
{
	try{
		ExtentReporter.reportStep("BDD:Then it redirects to Browse_Accessories page", "INFO");
	 if(isElementDisplayed(BrowseDevicePage.accessoryButton,5)){

			ExtentReporter.reportStep(getDriver(),"Browse_Accessories page is displayed", "INFO",0);
	  }
	  else
	  {
			ExtentReporter.reportStep(getDriver(),"Browse_Accessories page is not displayed", "INFO",0);
	  }
		
		
	  
		
}
	catch(Exception e){
		log.error("Error in DeviceBrand page");
		e.printStackTrace();
		throw(e);
	}
}
}

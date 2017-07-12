package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;

public class BrowseAccessory extends BrowseDevicePage{

	private static Logger log = Logger.getLogger(BrowseAccessory.class);
	BrowseDevice browseDeviceobj = new BrowseDevice();
	
	@And("^agent selects particular accessory and color$")
	public void accessorySelection() throws Exception{
		try{
		ExtentReporter.reportStep("BDD Step: agent selects particular accessory and color", "INFO");
		selectAccessory();
		colorAccessory();
		browseDeviceobj.verifyTotalAmount();
		browseDeviceobj.clickSelect();
	}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	
	@When("^Click on any Accessory in catalog$")	
	public void selectAccessory()  throws Exception{
		try {
			ExtentReporter.reportStep("BDD Step: When Click on any Accessory in catalog", "INFO");
			String accessoryName=getXMLData("AccessoryName");
		    BrowseAccessoryPage.selectAccessory(accessoryName);
		    System.out.println("Selected accessory"); 
		}catch (Exception e) {
			log.error("GOT EXCEPTION in selectAccessory(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@And("^Select Color of Accessory$")	
	public void colorAccessory()  throws Exception{
		try {
			ExtentReporter.reportStep("BDD Step: Select Color of Accessory", "INFO");
			String accessoryColor=getXMLData("Color");
			System.out.println("Color Accessory: "+accessoryColor);
			BrowseAccessoryPage.accessoryColor(accessoryColor);			
			}catch (Exception e) {
			log.error("GOT EXCEPTION in colorAccessory(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
}

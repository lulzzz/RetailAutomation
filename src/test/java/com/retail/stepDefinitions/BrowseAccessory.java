package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;

public class BrowseAccessory extends BrowseDevicePage{

	private static Logger log = Logger.getLogger(BrowseAccessory.class);
	BrowseDevice browseDeviceobj = new BrowseDevice();
	ShoppingCart shopcart= new ShoppingCart();
	
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
			ExtentReporter.reportStep("BDD Step: When I Click on any Accessory in catalog", "INFO");
			String flag= getXMLData("flag");
			if(flag.equals("H")){
			ExtentReporter.reportStep("BDD Step: When Click on any Accessory in catalog", "INFO");
			String accessoryName=getXMLData("AccessoryName"+DeviceSearch.device_count);
		    BrowseAccessoryPage.selectAccessory(accessoryName);}
			if(flag.equals("S")){
				ExtentReporter.reportStep("BDD Step: When Click on any Accessory in catalog", "INFO");
				String accessoryName=getXMLData("AccessoryName");
			    BrowseAccessoryPage.selectAccessory(accessoryName);
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in selectAccessory(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@And("^Select Color of Accessory$")	
	public void colorAccessory()  throws Exception{
		try {
			String flag= getXMLData("flag");
			if(flag.equals("H")){
			ExtentReporter.reportStep("BDD Step: Select Color of Accessory", "INFO");
			String accessoryColor=getXMLData("ColorAccessory"+DeviceSearch.device_count);
			System.out.println("Color Accessory: "+accessoryColor);
			BrowseAccessoryPage.accessoryColor(accessoryColor);	
			}
			if(flag.equals("S")){
				ExtentReporter.reportStep("BDD Step: Select Color of Accessory", "INFO");
				String accessoryColor=getXMLData("ColorAccessory");
				System.out.println("Color Accessory: "+accessoryColor);
				BrowseAccessoryPage.accessoryColor(accessoryColor);	
				}
			
			}catch (Exception e) {
			log.error("GOT EXCEPTION in colorAccessory(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^agent add multiple accessories and select the accessory color$")
	public void addMultipleAccessory()  throws Exception{
			ExtentReporter.reportStep("BDD Step: agent add multiple accessories and select the accessory color", "INFO");
			int accessory = 1;	
			while(accessory<=5)
			 {
				shopcart.add_Accessory();
				shopcart.browseAccessories();
			 accessorySelection();
			 accessory=accessory+1;
			 DeviceSearch.device_count=DeviceSearch.device_count+1;
			 }
			accessory=accessory+1;
			
			DeviceSearch.device_count=1;
		

		
	}
	@And("^agent add accessories and select the accessory color$")
	public void addAccessory()  throws Exception{
		try {
			ExtentReporter.reportStep("BDD Step: Agent add accessories and select the specific accessory category", "INFO");
			shopcart.add_Accessory();
			shopcart.browseAccessories();
			accessorySelection();
			}catch (Exception e) {
			log.error("GOT EXCEPTION in addAccessory(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Accessories button$")
	public void accessoryButton() {
		try {
			clickElement(BrowseAccessoryPage.accessoryButton);
			log.info("Clicked Accessories button");			
		}
		catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	
	
}

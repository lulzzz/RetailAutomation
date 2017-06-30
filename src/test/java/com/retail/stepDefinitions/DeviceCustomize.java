package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;
import com.retail.pageObjects.DeviceCustomizePage;
import cucumber.api.java.en.*;


public class DeviceCustomize extends DeviceCustomizePage{

	private static Logger log = Logger.getLogger(DeviceCustomize.class);

	@When("^I Choose the option, Get a new number or Keep Number$")
	public void choosenumber() throws Exception  {
		try
	  {
		WebOperations.verifyText("CHOOSE A NUMBER");
		String choosenumber= getXMLData("ChooseNumber").toUpperCase();
		log.info(choosenumber);
		if(choosenumber.equalsIgnoreCase("Keep Number"))
		{				
			clickElement(DeviceCustomizePage.keep_number);
			log.info("Clicked Keep Number");
			typeValue(DeviceCustomizePage.current_phone_number,getXMLData("CurrentPhoneNumber"));			
			Select select = new Select(getDriver().findElement(By.xpath("//SPAN[@id='dropdown']")));
			select.selectByVisibleText("AT&T");
					
		}else if(choosenumber.equalsIgnoreCase("Get New Number"))
		{
			clickElement(DeviceCustomizePage.get_new_num);
			log.info("Clicked Get New Number");
		}
		
	  }		
		catch (Exception e) {
			log.error("GOT EXCEPTION in choosenumber(): " +LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
	}
	}
	
@Then("^I enter the name of the user$")
public void name() throws Exception {
   try {
	//WebOperations.verifyText("WHO IS THE PHONE FOR?");
	typeValue(DeviceCustomizePage.name,getXMLData("Name"));
	log.info("Entered Name");		
}
	
	catch (Exception e) {
		log.error("GOT EXCEPTION in name(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
}
}

@When("^I click on add to cart after filling all the details$") 
public void addtocart() throws Exception {
	   try {						
		clickElement(DeviceCustomizePage.add_to_cart);
		log.info("Clicked Add to Cart");
	}
		
		catch (Exception e) {
			log.error("GOT EXCEPTION in addtocart(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
	}

}

}
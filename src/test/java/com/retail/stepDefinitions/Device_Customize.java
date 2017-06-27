package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


import com.framework.wrapper.*;
import com.retail.pageObjects.Device_CustomizePage;
import cucumber.api.java.en.*;


public class Device_Customize extends WebOperations{

	private static Logger log = Logger.getLogger(Device_Customize.class);

	@When("^I Choose the option, Get a new number$")
	public void getNewNumber() 
	{	
		
		String choosenumber= getXMLData("ChooseNumber").toUpperCase();
		log.info(choosenumber);
		if(choosenumber.equalsIgnoreCase("Keep Number"))
		{				
			clickElement(Device_CustomizePage.keep_number);
			log.info("Clicked Keep Number");
			typeValue(Device_CustomizePage.current_phone_number,getXMLData("CurrentPhoneNumber"));			
			Select select = new Select(getDriver().findElement(By.xpath("//SPAN[@id='dropdown']")));
			select.selectByVisibleText("AT&T");
					
		}else if(choosenumber.equalsIgnoreCase("Get New Number"))
		{
			clickElement(Device_CustomizePage.get_new_num);
			log.info("Clicked Get New Number");
		}
		
		typeValue(Device_CustomizePage.name,getXMLData("Name"));
		log.info("Entered Name");	
		
		clickElement(Device_CustomizePage.add_to_cart);
	}



}
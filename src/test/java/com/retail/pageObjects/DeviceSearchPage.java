package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.wrapper.WebOperations;

public class DeviceSearchPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	
	scantext = By.xpath("//h1[text()='Scan the IMEI to begin.']"),
    IMEInum = By.xpath("//input[@name='imei']"),
    searchbutton = By.xpath("//button[text()='Search']"), 
    SIMnum = By.xpath("//INPUT[@_ngcontent-c5='']"),
    editsim = By.linkText("Edit SIM"),
    verifybutton = By.xpath("//button[text()='Verify']"),
    nextbutton = By.xpath("//button[text()='Next']"); 	
}

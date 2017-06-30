package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.wrapper.WebOperations;

public class DeviceSearchPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	
	scantext = By.xpath("//h1[@_ngcontent-c11='']"),
	IMEInum = By.xpath("//INPUT[@_ngcontent-c11='']"),
	searchbutton = By.xpath("/html/body/my-app/main/my-device-search/div[1]/form/div/div/div[2]/my-btn/button"),	
	SIMnum = By.xpath("//INPUT[@_ngcontent-c5='']"),
	editsim = By.linkText("Edit SIM"),
	verifybutton = By.xpath("//button[@_ngcontent-c8=''][text()='Verify']"),
	nextbutton = By.xpath("//*[@id='primarynextbtn']/button");	
	
}

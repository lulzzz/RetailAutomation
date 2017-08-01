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
    nextbutton = By.xpath("//button[text()='Next']"),
    //IMEIrow = By.xpath("//div[@class='row']"),
    verifyShipping = By.xpath("//h2[text()='Device out of stock? Verify Shipping Address.']"),
    shippingAddress = By.xpath("//h4[text()='Shipping Address']"),
    name = By.xpath("//div//p[1]"),
    address1 = By.xpath("//div//p[2]"),
    address2 = By.xpath("//div//p[3]"),
    city = By.xpath("//div//p[4]"),
    phoneName = By.xpath("//div[@class='box text-left']//h2"),
    phoneColor = By.xpath("//div[@class='box text-left']//p[1]"),
    editButton = By.xpath("//button[text()='Edit']"),
    firstName = By.xpath("//label[contains(text(),'First Name')]//input"),
    lastName = By.xpath("//label[contains(text(),'Last Name')]//input"),
    address = By.xpath("//label[contains(text(),'Address')]//input"),
    cityName = By.xpath("//label[contains(text(),'City')]//input"),
    zip = By.xpath("//label[contains(text(),'Zip Code')]//input"),
    state = By.xpath("//button//span//span[@class='box']"),
    save = By.xpath("//button[text()='Save']"),
    serviceAddress= By.xpath("//label[@class='address-checkbox']"),
    cancel = By.xpath("//button[text()='Cancel']"),
    phoneDet = By.xpath("//div[@class='modal-container']"),
    close = By.xpath("//button[@class='close']"),
    errorMessage = By.xpath("//div[text()='SIM requires 20 numeric digits']"),
    BYOD = By.xpath("//label[@class='checkbox']"),
    settingsText1 = By.xpath("//div[@class='byod-options text-left']//p[contains(text(),'*#060# on the devices phone dial pad')]"),
    settingsText2 = By.xpath("//div[@class='byod-options text-left']//p[contains(text(),'Scroll down to locate the IMEI number')]"),
    
    
    phoneIMEI = By.xpath("//div[@class='box text-left']//p[2]");
    
	
	private String getCssvalue(By iMEIrow) {
		// TODO Auto-generated method stub
		return null;
	}
}

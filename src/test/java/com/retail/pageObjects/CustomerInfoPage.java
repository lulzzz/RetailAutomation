package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class CustomerInfoPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	dobField = By.xpath("//input[@type='date']"),
	ssnField = By.xpath("//label[contains(text(),'Last 4 SSN')]//input"),
	//justAccessories = By.xpath("//BUTTON[@_ngcontent-c4=''][1]"),
	justAccessories = By.xpath("//div[@class='verify-card text-left']//button[1]"),
	singleLine = By.xpath("//div[@class='verify-card text-left']//button[2]"),
	//singleLine = By.xpath("//BUTTON[@_ngcontent-c4=''][2]"),
	ssnField2 = By.xpath("//label[contains(text(),'SSN')]//input"),
	storeName = By.xpath("//label[contains(text(),'Store Name')]//input"),
	storeNumber = By.xpath("//label[contains(text(),'Store Number')]//input"),
	address = By.xpath("//label[contains(text(),'Address')]//input"),
	city = By.xpath("//label[contains(text(),'City')]//input"),
	Zip = By.xpath("//label[contains(text(),'Zip')]//input"),
	deviceSection = By.xpath("//div[@class='verify-card text-left']"),
	state = By.xpath("//button//span//span[contains(text(),'Select')]"),
	submitBtn = By.xpath("//BUTTON[text()='Submit']");	
	public static void selectState(String state) 
	{
		By stateSelect = By.xpath("//ul[@class='dropdown-menu']//li//a[text()='"+state+"']");
		clickElement(stateSelect);
	}
}

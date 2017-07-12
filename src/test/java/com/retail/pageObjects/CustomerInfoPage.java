package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class CustomerInfoPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	dobField = By.xpath("//input[@type='date']"),
	ssnField = By.xpath("//input[@type='text']"),
	//justAccessories = By.xpath("//BUTTON[@_ngcontent-c4=''][1]"),
	justAccessories = By.xpath("//div[@class='verify-card text-left']//button[1]"),
	singleLine = By.xpath("//div[@class='verify-card text-left']//button[2]"),
	//singleLine = By.xpath("//BUTTON[@_ngcontent-c4=''][2]"),
	submitBtn = By.xpath("//BUTTON[text()='Submit']");	
	
}

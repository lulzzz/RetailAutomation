package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class AccountLookUpPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	lookUpInput = By.xpath("//INPUT[@id='input_1']"),
	lookUpButton = By.xpath("//BUTTON[@class='md-primary btn-lookup md-button md-ink-ripple']"),
	driverLicense = By.xpath("//A[@href='javascript:;'][text()='Driver ’s License']"),
	stateID = By.xpath("//A[@href='javascript:;'][text()='State ID']"),
	USPassport = By.xpath("//A[@href='javascript:;'][text()='US Passport']");
}

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
	USPassport = By.xpath("//A[@href='javascript:;'][text()='US Passport']"),
	
	scanbill = By.xpath("//button[@class='md-primary barcode md-button md-ink-ripple']"),
	scanclose = By.xpath("//md-dialog[@class='_md md-transition-in']//md-icon[text()=' clear ']"),
	scancancel = By.xpath("//md-dialog[@class='_md md-transition-in']//button[text()='Cancel']"),
	IDnotmatch = By.linkText("ID does not match above address, or no ID available"),
	SSN = By.xpath("//div[@class='md-dialog-content']//input[@id='input_0']"),
	
	enterSSN = By.xpath("//md-dialog-actions//button[text()='Enter']"),
	cancelSSN = By.xpath("//md-dialog[@class='_md md-transition-in']//button[text()='Cancel']"),
	closeSSN = By.xpath("//md-dialog[@aria-label='Enter last ...']//md-icon[text()=' clear ']"),
	closeID = By.xpath("//*[@class='_md md-transition-in']//md-icon[text()=' clear ']");
	}

package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class AccountLookUpPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	
	lookUpInput = By.xpath("//INPUT[@id='input_1']"),
	lookUpButton = By.xpath("//BUTTON[text()='Look Up']"),
	driverLicense = By.xpath("//A[text()='Driver �s License']"),
	stateID = By.xpath("//A[text()='State ID']"),
	USPassport = By.xpath("//A[text()='US Passport']"),
	
	scanbill = By.xpath("//button[@class='md-primary barcode md-button md-ink-ripple']"),
	scanclose = By.xpath("/html/body/modal/form/md-dialog/md-toolbar/div/button/md-icon"),
	scancancel = By.xpath("/html/body/modal/form/md-dialog/md-dialog-actions/button"),
	IDnotmatch = By.linkText("ID does not match above address, or no ID available"),
	SSN = By.xpath("//div[@class='md-dialog-content']//input[@id='input_0']");
}

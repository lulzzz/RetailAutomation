package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class AccountDetailsPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	launchMobileBtn = By.xpath("//BUTTON[text()='Launch Mobile']"),
	launchMobileRtBtn = By.xpath("//BUTTON[text()='Launch Mobile']"),
	manageMobileLink = By.xpath("//A[text()='Manage Mobile Devices']");
	
	
}

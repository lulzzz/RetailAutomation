package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class Account_DetailsPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	launchMobileBtn = By.xpath("//BUTTON[@class='md-primary btn-blue md-button md-ink-ripple']"),
	launchMobileRtBtn = By.xpath("//BUTTON[@class='md-primary btn-blue md-button md-ink-ripple']"),
	manageMobileLink = By.xpath("//A[@href=''][text()='Manage Mobile Devices']");
	
	
}

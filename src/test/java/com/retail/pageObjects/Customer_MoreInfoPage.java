package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class Customer_MoreInfoPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	dobField = By.xpath("(//INPUT[@_ngcontent-c5=''])[1]"),
	ssnField = By.xpath("(//INPUT[@_ngcontent-c5=''])[2]"),
	justAccessories = By.xpath("//BUTTON[@_ngcontent-c4=''][1]"),
	singleLine = By.xpath("//BUTTON[@_ngcontent-c4=''][2]"),
	submitBtn = By.xpath("//BUTTON[@_ngcontent-c8=''][text()='Submit']");	
	
}

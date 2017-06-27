package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class Shopping_cartPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
    estimatedMonthlycost_shoppingcart =By.xpath("//DIV[@_ngcontent-c24=''][text()='ESTIMATED MONTHLY']"),
    continueToCheckout = By.xpath("(//button[@_ngcontent-c8=''])[7]"),
	oneTimeCharge_shoppingcart =By.xpath("//DIV[@_ngcontent-c24=''][text()='ONE TIME CHARGE']");
}

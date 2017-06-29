package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class Shopping_cartPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
    estimatedMonthlycost_shoppingcart =By.xpath("//DIV[@_ngcontent-c24=''][text()='ESTIMATED MONTHLY']"),
    continueToCheckout = By.xpath("/html/body/my-app/main/my-cart-container/div/div/div[4]/div/div[2]/my-btn[2]/button"),
	oneTimeCharge_shoppingcart =By.xpath("//DIV[@_ngcontent-c24=''][text()='ONE TIME CHARGE']");
}

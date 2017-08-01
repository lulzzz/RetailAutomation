package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class ShoppingCartPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	estimatedMonthlycost_shoppingcart=By.xpath("//div[text()='ESTIMATED MONTHLY']"),
	continueToCheckout= By.xpath("//button[text()='Continue to Checkout']"),
	add_AnotherLine  = By.xpath("//button[text()='Add Another Line']"),
	add_Accessory = By.xpath("//button[text()='Add Accessories']"),
    deleteLine = By.xpath("//button[text()='Delete Line']"),
	continueCustom = By.xpath("//button[text()='Continue Customization']"),
	cartText = By.xpath("//div[contains(text(),'nothing in the cart.')]"),
	cartImage = By.xpath("//div[@class='hidden-print']//img"), 
	oneTimeCharge_shoppingcart=By.xpath("//div[text()='ONE TIME CHARGE']");
}

package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class ShoppingCartPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	estimatedMonthlycost_shoppingcart=By.xpath("//div[text()='ESTIMATED MONTHLY']"),
	continueToCheckout= By.xpath("//button[text()='Continue to Checkout']"),
	continueCustom = By.xpath("//button[text()='Continue Customization']"),
	add_AnotherLine  = By.xpath("//button[text()='Add Another Line']"),
	cartSummary = By.xpath("//div[text()='Cart Summary']"),
	incompleteLines = By.xpath("//div[text()='Incomplete Lines']"),
	print = By.xpath("//button[text()='Print']"),
	pages = By.xpath("//h1[text()='Pages']"),
	topEditCart = By.xpath("//div[@class='col-xs text-right non-printable']//button[text()='Edit Cart']"),
	editOrderText = By.xpath("//div[text()=' EDIT ORDER ']"),
	bottomEditCart = By.xpath("//div[@class='row link-part non-printable']//button[text()='Edit Cart']"),
	done = By.xpath("//button[text()='Done']"),
	paymentDetails = By.xpath("//button[text()='Payment Details']"),
	custOrder_Cart = By.xpath("//div[text()=' CUSTOMER ORDER REVIEW ']"),
	deleteLine = By.xpath("//button[text()='Delete Line']"),
	add_Accessory = By.xpath("//button[text()='Add Accessories']"),
	cartText = By.xpath("//div[contains(text(),'nothing in the cart.')]"),
	cartImage = By.xpath("//div[@class='hidden-print']//img"),
	cancel = By.xpath("//button[contains(text(),'Cancel')]"),
	add_Line = By.xpath("//button[text()='Add a Line']"),
	cancelSale = By.xpath("//h2[text()='Cancel this Sale?']"),
	backArrow = By.xpath("//img[@class='adjust-icon']"),
	deviceName = By.xpath("//div[@class='bold-font']//p[1]"),
	lineDetails = By.xpath("//button[text()='Line Details']"),
			deviceColor_Storage = By.xpath("//div[@class='small-font']//p[1]"),
			deviceCharge = By.xpath("//div[@class='small-font']//p[2]"),
			deviceNumber = By.xpath("//div[@class='small-font']//p[3]"),
	
	
	oneTimeCharge_shoppingcart=By.xpath("//div[text()='ONE TIME CHARGE']");
	
	public static void selectReason(String reason) 
	{
		By reasonSelect = By.xpath("//span[text()='"+reason+"']");
		clickElement(reasonSelect);
	}
}

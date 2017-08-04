package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class CustomerPreSignaturePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	estimatedChargesToday= By.xpath("//*[@class='col-xs']/my-btn/button"),
	sameServiceAddress= By.xpath("//*[@class='address-checkbox']/span"),
	firstName= By.xpath("//label[contains(text(),'First Name')]/input"),
	lastName= By.xpath("//label[contains(text(),'Last Name')]/input"),
	address1= By.xpath("//label[contains(text(),'Address')]/input"),
	address2= By.xpath("(//INPUT[@_ngcontent-c5=''])[4]"),
	city= By.xpath("//label[contains(text(),'City')]/input"),
	zipcode= By.xpath("//label[contains(text(),'Zip Code')]/input"),
	save_billingAddress= By.xpath("//div[@class='button-container']/my-btn/button"),	
	updateAddressRecommended= By.cssSelector(".col-xs.text-left.recommended"),
	update_billingAddress= By.xpath("//div[@class='modal-footer']/my-btn[2]/button"),
	edit_billingAddress= By.xpath("//my-address/div/my-btn/button[text()='Edit']"),
	creditCardNumber= By.xpath("//*[@id='cardNumber']"),
	iframe= By.xpath("//iframe[@class='payment-frame']"),
	expiration= By.xpath("//*[@id='expiration']"),
	cvv= By.xpath("//*[@id='cvv']"),
	save_creditCard= By.xpath("//*[@id='data-form']//button"),
	edit_paymentAddress= By.xpath("//my-customer-billing-info//my-btn/button[text()='Edit']"),
	Email_Address= By.xpath("//label[contains(text(),'Email')]//input"),
	phone_Number= By.xpath("//label[contains(text(),'Phone Number')]//input"),
	save_contactInfo= By.xpath("//div[@class='button-container']/my-btn/button"),
	edit_contactInfo= By.xpath("//my-customer-contact//div/my-btn/button"),
	verify_info= By.xpath("//span[@class='new-checkbox']"),
	collect_signature= By.xpath("//div[@class='col-xs text-right']/my-btn/button"),
	disclosureAccpeted= By.id("disclosureAccepted"),
	billingAddressText = By.xpath("//h4[text()='Billing Address']"),
	state= By.xpath("//label[text()='State']/following-sibling::button"),
	run_creditCheck= By.xpath("//button[text()='Run Credit Check']"),
	close= By.xpath("//button[text()='Close']"),
	approved_check= By.xpath("//div//p[contains(text(),'approved ')]"),
	placeOrderBtn=By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[7]/my-btn[2]/button");	
		
}

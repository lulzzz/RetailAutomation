package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class CustomerPreSignaturePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	estimatedChargesToday= By.xpath("//SPAN[@_ngcontent-c4=''][2]"),
	sameServiceAddress= By.xpath("//*[@class='address-checkbox']/span"),
	firstName= By.xpath("//label[contains(text(),'First Name')]/input"),
	lastName= By.xpath("//label[contains(text(),'Last Name')]/input"),
	address1= By.xpath("//label[contains(text(),'Address')]/input"),
	address2= By.xpath("(//INPUT[@_ngcontent-c5=''])[4]"),
	city= By.xpath("//label[contains(text(),'City')]/input"),
	zipcode= By.xpath("//label[contains(text(),'Zip Code')]/input"),
	save_billingAddress= By.xpath("//my-address/div/form/div[6]/my-btn/button"),	
	updateAddressRecommended= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/ngb-modal-window/div/div/my-address-recommendation/div[2]/div/div/div[2]"),
	update_billingAddress= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/ngb-modal-window/div/div/my-address-recommendation/div[3]/my-btn[2]/button"),
	edit_billingAddress= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/my-btn/button"),
	creditCardNumber= By.xpath("//*[@id='cardNumber']"),
	expiration= By.xpath("//*[@id='expiration']"),
	cvv= By.xpath("//*[@id='cvv']"),
	save_creditCard= By.xpath("(//button[@_ngcontent-c5=''])[4][text()='Save']"),
	edit_paymentAddress= By.xpath("//my-customer-billing-info/div[1]/div/div/my-btn/button[1]"),
	Email_Address= By.xpath("(//INPUT[@_ngcontent-c12=''])[1]"),
	phone_Number= By.xpath("(//INPUT[@_ngcontent-c12=''])[2]"),
	save_contactInfo= By.xpath("(//button[@_ngcontent-c5=''])[6][text()='Save']"),
	edit_contactInfo= By.xpath("//my-customer-contact/div/my-btn/button"),
	verify_info= By.xpath("//*[@class='final-verify-checkbox']"),
	collect_signature= By.xpath("//my-customer-signature-link/div[1]/div[2]/my-btn/button[1]"),
	disclosureAccpeted= By.id("disclosureAccepted"),
	state= By.xpath("//label[text()='State']/following-sibling::button"),
	placeOrderBtn=By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[7]/my-btn[2]/button");	
		
}

package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class CustomerPreSignaturePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	estimatedChargesToday= By.xpath("//SPAN[@_ngcontent-c4=''][2]"),
	sameServiceAddress= By.xpath("//*[@class='address-checkbox']/span"),//"/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/div/div[2]/label/span"),
	firstName= By.xpath("//label[contains(text(),'First Name')]/input"),//"/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/form/div[1]/div[1]/my-input/label/input"),
	lastName= By.xpath("//label[contains(text(),'Last Name')]/input"),//"/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/form/div[1]/div[2]/my-input/label/input"),
	address1= By.xpath("//label[contains(text(),'Address')]/input"),//"(//INPUT[@_ngcontent-c5=''])[3]"),
	address2= By.xpath("(//INPUT[@_ngcontent-c5=''])[4]"),
	city= By.xpath("//label[contains(text(),'City')]/input"),//"(//INPUT[@_ngcontent-c5=''])[5]"),
	zipcode= By.xpath("//label[contains(text(),'Zip Code')]/input"),//"(//INPUT[@_ngcontent-c5=''])[6]"),
	save_billingAddress= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/form/div[6]/my-btn/button"),
	updateAddressRecommended= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/ngb-modal-window/div/div/my-address-recommendation/div[2]/div/div/div[2]"),
	update_billingAddress= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/ngb-modal-window/div/div/my-address-recommendation/div[3]/my-btn[2]/button"),
	edit_billingAddress= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/my-btn/button"),
	creditCardNumber= By.xpath("//*[@id='cardNumber']"),
	expiration= By.xpath("//*[@id='expiration']"),
	cvv= By.xpath("//*[@id='cvv']"),
	save_creditCard= By.xpath("(//button[@_ngcontent-c5=''])[4][text()='Save']"),
	edit_paymentAddress= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[3]/my-customer-billing-info/div/div/div[1]/my-btn/button"),
	Email_Address= By.xpath("(//INPUT[@_ngcontent-c12=''])[1]"),
	phone_Number= By.xpath("(//INPUT[@_ngcontent-c12=''])[2]"),
	save_contactInfo= By.xpath("(//button[@_ngcontent-c5=''])[6][text()='Save']"),
	edit_contactInfo= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[4]/div/my-customer-contact/div/my-btn/button"),
	verify_info= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[6]/div/my-customer-signature-link/div[1]/div[1]/label/span"),
	collect_signature= By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[6]/div/my-customer-signature-link/div[1]/div[2]/my-btn/button"),
	disclosureAccpeted= By.id("disclosureAccepted"),
	state= By.xpath("//label[text()='State']/following-sibling::button"),//"/html/body/my-app/main/my-customer-pre-signature/div/div[2]/div[1]/my-address/div/form/div[5]/div[1]/my-select/div/button/span/span[1]"),
	placeOrderBtn=By.xpath("/html/body/my-app/main/my-customer-pre-signature/div/div[7]/my-btn[2]/button");	
	
	
}

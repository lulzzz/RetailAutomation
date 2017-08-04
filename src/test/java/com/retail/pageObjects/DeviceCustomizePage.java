package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class DeviceCustomizePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	
	keep_number = By.xpath("//label[@for='number1']"),
	get_new_num = By.xpath("//label[@for='number2']"),
	deviceName = By.xpath("//h2[@class='device-brand-name']"),
	deviceColor = By.xpath("//div[@class='device-info']//div[1]"),
	deviceIMEI = By.xpath("//div[@class='device-info']//div[2]"),
			paymentplan = By.xpath("//div[@class='plan-info']//div[1]"),
			deviceProtect = By.xpath("//div[@class='plan-info']//div[2]"),
			dataOption = By.xpath("//div[@class='plan-info']//div[3]"),
	current_phone_number = By.xpath("//label[@class='control-label ']/input"),
	current_carrier = By.xpath("//span[@id='dropdown']"),
	AT_select=By.xpath("//*[contains(@id,'dropdown')][text()='AT&T']"),
	name = By.xpath(" //label[@class='control-label all-caps']/input"),
	add_to_cart = By.xpath("//button[@type='gocart']");
		
}

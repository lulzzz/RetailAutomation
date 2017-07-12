package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class DeviceBrandPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);
 public static By
 
 PhoneByBrand = By.xpath("//h2[text()='Phones by Brand']");


	public static void selectDeviceBrand(String deviceName) 
	{
		System.out.println(deviceName);
		By deviceSelect = By.xpath("//a[text()='"+deviceName+"']");
		clickElement(deviceSelect);
	}
	
	public static void selectAccessoryCategory(String accessoryName) {
		System.out.println(accessoryName);
		By accesorySelect = By.xpath("//a[text()='"+accessoryName+"']");
		clickElement(accesorySelect);
		
	}
}			
					
							
	


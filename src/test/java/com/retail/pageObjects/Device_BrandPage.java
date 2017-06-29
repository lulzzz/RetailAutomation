package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class Device_BrandPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);
 public static By
 
 PhoneByBrand = By.xpath("//h2[@_ngcontent-c13=''][text()='Phones by Brand']");


	public static void selectDeviceBrand(String deviceName) 
	{
		System.out.println(deviceName);
		By deviceSelect = By.xpath("//a[@_ngcontent-c13=''][text()='"+deviceName+"']");
		clickElement(deviceSelect);
		System.out.println(deviceSelect);
	}
		}			
					
							
	


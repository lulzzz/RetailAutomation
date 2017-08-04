package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class DeviceBrandPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);
 public static By
 
 PhoneByBrand = By.xpath("//h2[text()='Phones by Brand']"),
 ViewCatalog = By.xpath("//div[@class='brands-container accessories']//button[text()='View Catalog']"),
 carticonvalue = By.xpath("//div[@class='hidden-print']"),
 accessory_hidden = By.xpath("//div[@class='disabled-cover v-center']"),
 AccesoryByCategory = By.xpath("//h2[text()='Accessories by Category']"),
 cust_name= By.xpath("//span[@class='cust-name']//a"),
 accessory_hidden_text = By.xpath("//h2[contains(text(),'In order to ship an accessory, first add a device to the cart.')]"),
 viewCatalog_device = By.xpath("//div[@class='brands-container']//button[text()='View Catalog']");


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
					
							
	


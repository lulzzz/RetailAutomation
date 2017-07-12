package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.wrapper.WebOperations;

public class BrowseDevicePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);
 public static By
   //Total=By.xpath("//div[@class='price-pane add-info-pane']/div/div/div"),
   deviceSelect =By.xpath("/html/body/my-app/main/my-browse/div/div[1]/div[2]/div[1]/div[1]/my-device-preview/div[2]/div[3]/div/div[2]/my-btn/button"),   
   deviceButton = By.xpath("//button[text()='Devices']"),
   deviceColor=By.xpath("/html/body/my-app/main/my-browse/div/div[1]/div[2]/div[1]/div[1]/my-device-preview/div[2]/div[2]/div/my-color-radio/form/label[1]/div[1]/div");
   
	public static void selectDevice(String deviceName) 
	{		
		By deviceSelect = By.xpath("//h3[text()='"+deviceName+"']");		
		clickElement(deviceSelect);
	}
	public static void selectColor(String deviceColor) throws InterruptedException 
	{		
		By deviceColorSelect = By.xpath("//div[@class='title'][@_ngcontent-c12=''][text()='"+deviceColor+"']");
		wait(4000);
		clickElement(deviceColorSelect);
	}
	public static void selectCapacity(String Capacity) 
	{
		By deviceSelect = By.xpath("//label[@for='"+Capacity+"']");
		System.out.println(deviceSelect);
		clickElement(deviceSelect);
	}
		}			
					
							
	


package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.wrapper.WebOperations;

public class BrowseAccessoryPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);
 public static By
 
 	accessoryButton = By.xpath("//button[text()='Accessories']"),
 	accessorySelectBtn=By.xpath("/html/body/my-app/main/my-browse/div/div[1]/div[2]/div[1]/div/my-preview/div[2]/div[2]/div/div[2]/my-btn/button");

 public static void selectAccessory(String accessoryName) 
	{
		System.out.println(accessoryName);
		By accessorySelect = By.xpath("//h3[contains(text(),'"+accessoryName+"')]");
		System.out.println(accessorySelect);
		clickElement(accessorySelect);
	}
 
 public static void accessoryColor(String accessoryColor) throws InterruptedException 
	{
		System.out.println(accessoryColor);
		By selectaccessoryColor = By.xpath("//div[contains(text(),'"+accessoryColor+"')]");
		System.out.println(selectaccessoryColor);
		Thread.sleep(10000);
		clickElement(selectaccessoryColor);
	}
	
 
		}			
					
							
	


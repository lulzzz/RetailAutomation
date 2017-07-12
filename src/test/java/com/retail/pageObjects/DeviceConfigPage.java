package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.wrapper.WebOperations;

public class DeviceConfigPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	pay_in_full = By.xpath("//span[text()='Pay In Full']"),
    pay_monthly = By.xpath("//span[text()='Pay Monthly']"),
    XMPP = By.xpath("//span[text()='Xfinity Mobile Protection Plan (XMPP)']"),
    noXMPP = By.xpath("//span[text()='No Xfinity Mobile Protection Plan (XMPP)']"),
    unlimited = By.xpath("//span[text()='Unlimited']"),
    by_the_gig = By.xpath("//span[text()='By the Gig']"),
    nextbutton = By.xpath("//button[text()='Next']");	
		}			
					
							
	


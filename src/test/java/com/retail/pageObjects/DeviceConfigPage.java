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
    close_learnmore= By.xpath("//my-device-protection-learnmore//button[@class='close']"),
    deviceConfig_devicename= By.xpath("//h2[@class='device-brand-name']"),
    device_image= By.xpath("//div[@class='box device-shot']"),
    device_custom= By.xpath("//div[@class='device-info']/div"),
    estimated_cost= By.xpath("//my-device-estimated-monthly-bill//div[@class='price']"),
    device_cost_monthly= By.xpath("//my-radio-btn[1]/form/div/div[2]/label/span[2]"),
    cancel_button= By.xpath("//button[text()='Cancel']"),
    back_profile= By.xpath("//button[text()='Back to Profile']"),
    reason_cancellation= By.xpath("//h2[text()='Cancel this Sale?']"),
    learn_more= By.xpath("//a[text()='Learn More']"),
    popup= By.xpath("//h2[text()='XFINITY Mobile Protection Plan']"),
    remove_Protection= By.xpath("//button[text()='Remove Protection']"),
    add_Protection= By.xpath("//button[text()='Add Protection']"),
    faq= By.xpath("//a[text()='Frequently Asked Questions']"),
    terms_conditions= By.xpath("//a[text()='Terms and Conditions.']"),
    cancellation_dropdown= By.xpath("//span[@class='box caret']"),
    dropdownlist_cancellation= By.xpath("//ul[@class='dropdown-menu']"),
    		 estimatedMonthly = By.xpath("//div[text()='ESTIMATED MONTHLY (Taxes not Included)']"),
    		 oneTimeCharge = By.xpath("//div[text()='ONE TIME CHARGE (Taxes not Included)']"),
    		oneTimeCost = By.xpath("//my-device-one-time-charge//div[@class='price']"),
    term_nextpage= By.xpath("//embed[@id='plugin']"),
     DeviceSearch_title= By.xpath("//h1[contains(text(),'Scan the IMEI to begin.')]"),
    change_device= By.xpath("//p[@class='change-device']"),
    		 pay_plan = By.xpath("//div[text()='CHOOSE A PAYMENT PLAN']"),
    		    deviceProtect = By.xpath("//div[text()='CHOOSE DEVICE PROTECTION']"),
    		    dataOption = By.xpath("//div[text()='CHOOSE A DATA OPTION']"),
    nextbutton = By.xpath("//button[text()='Next']");
	
		}			
					
							
	


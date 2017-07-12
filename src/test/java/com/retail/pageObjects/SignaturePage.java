package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class SignaturePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	agreementSelect=By.xpath("//input[@id='disclosureAccepted']"),
	continue_button=By.xpath("//span[@class='continue-button-wrapper']"),
	signature_tab=By.xpath("//div[@class='signature-tab-content']"),
	draw=By.xpath("//button[@aria-label='Draw']"),
	adopt_Sign=By.xpath("//button[@value='signature']"),
	wbCanvas=By.xpath("//*[@id='draw']/div/div/canvas"),
	finishBtn= By.xpath("//button[@id='action-bar-btn-finish']");
	
	
}

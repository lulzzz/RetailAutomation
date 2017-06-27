package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class SignaturePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 

	agreementSelect=By.xpath("//INPUT[@id='disclosureAccepted']"),
	continue_button=By.xpath("//SPAN[@class='continue-button-wrapper']"),
	signature_tab=By.xpath("//DIV[@class='signature-tab-content']"),
	draw=By.xpath("//BUTTON[@data-qa='adopt-draw'][text()='Draw']"),
	adopt_Sign=By.xpath("//*[@id='adopt-dialog']/div/div[3]/button[1]"),
	wbCanvas=By.xpath("//*[@id='draw']/div/div/canvas"),
	finishBtn= By.xpath("//*[@id='action-bar-btn-finish']");
	
	
}

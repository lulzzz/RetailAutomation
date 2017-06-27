package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.framework.utils.LogUtils;
import com.framework.wrapper.*;

import com.retail.pageObjects.SignaturePage;

import cucumber.api.java.en.*;

public class Signature extends WebOperations{

	private static Logger log = Logger.getLogger(Signature.class);
	
	Customer_PreSignature custPreSignObj= new Customer_PreSignature();
	
	//CheckOut for a customer
@When("^I check the check box for I agree to use electronic records and signatures$")	
	public  void checkAgreement()  {
		try {
			clickElement(SignaturePage.agreementSelect);
		 log.info("Agreement is selected");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
@Then("^I see the Continue button is enabled$")	
	public  void checkContinue()  {
		try {
		    checkElement(SignaturePage.continue_button);
		    log.info("Continue button is enabled");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}	
@Then("^I click continue$")	
	public  void clickContinue_Signature()  {
		try {
		    clickElement(SignaturePage.continue_button);
		    log.info("Continue button is clicked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
@When("^I select continue and click sign$")	
	public  void clickSign_Signature()  {
		try {
		    clickElement(SignaturePage.signature_tab);
		    clickElement(SignaturePage.draw);
		    log.info("Signature tab is clicked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
@And("^agent provides digital signature and accepts to T&C$")		
	public  void agreeToSign() throws Exception {
		try {
			checkAgreement();
			 checkContinue();
			 clickContinue_Signature();
			 clickSign_Signature();				 
			 
			 WebElement wbCanvas = getDriver().findElement(SignaturePage.wbCanvas);
						
			 Actions actionBuilder=new Actions(getDriver());         
		
			 for(int i= -50;i<50;i++){
			 Action drawOnCanvas=actionBuilder.moveToElement(wbCanvas)					 							 	
					 	.clickAndHold(wbCanvas)
		                .moveByOffset(60, 80)
		                .moveByOffset(70, 80)
		                .moveByOffset(-10,-100)	
		                .dragAndDropBy(wbCanvas, 33, i)
		                .doubleClick()
		                .release(wbCanvas)
		                .build();				
			 drawOnCanvas.perform();
			 }
			 
			 Thread.sleep(5000);
		
			//Click On Adopt and sign
			Thread.sleep(5000);
			clickElement(SignaturePage.adopt_Sign);
				 
			//Click on Finish Button
			Thread.sleep(5000);
			clickElement(SignaturePage.finishBtn);			
			Thread.sleep(5000);
			
			//Place Order
			//custPreSignObj.placeOrder();
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
}

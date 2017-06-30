package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.framework.utils.LogUtils;


import com.retail.pageObjects.SignaturePage;

import cucumber.api.java.en.*;

public class Signature extends SignaturePage{

	private static Logger log = Logger.getLogger(Signature.class);
	
	CustomerPreSignature custPreSignObj= new CustomerPreSignature();
	
//CheckOut for a customer
@When("^I check the check box for I agree to use electronic records and signatures$")	
	public  void checkAgreement() throws Exception {
		try {
			clickElement(SignaturePage.agreementSelect);
		 log.info("Agreement is selected");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
@Then("^I see the Continue button is enabled$")	
	public  void checkContinue() throws Exception {
		try {
			isElementDisplayed(SignaturePage.continue_button,10);
		    log.info("Continue button is enabled");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
@Then("^I click continue$")	
	public  void clickContinue_Signature() throws Exception {
		try {
		    clickElement(SignaturePage.continue_button);
		    log.info("Continue button is clicked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
@When("^I select continue and click sign$")	
	public  void clickSign_Signature() throws Exception {
		try {
		    clickElement(SignaturePage.signature_tab);
		    clickElement(SignaturePage.draw);
		    log.info("Signature tab is clicked");
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
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
			
		
			//Click On Adopt and sign			
			clickElement(SignaturePage.adopt_Sign);
				 
			//Click on Finish Button			
			clickElement(SignaturePage.finishBtn);			
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Customer Presignature Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
}

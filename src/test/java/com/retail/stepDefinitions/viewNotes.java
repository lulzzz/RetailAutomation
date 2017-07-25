package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.framework.utils.LogUtils;
import com.retail.pageObjects.AccountDetailsPage;
import com.retail.pageObjects.AccountDevicesPage;
import com.retail.pageObjects.SignaturePage;
import com.retail.pageObjects.viewNotesPage;

import cucumber.api.java.en.*;

public class viewNotes extends viewNotesPage{

	private static Logger log = Logger.getLogger(viewNotes.class);

	AccountLookUp acctLookUpObj= new AccountLookUp();	
	
	@Given ("^I am in View Notes page$")
	public void notesPage() {
		try {
			Thread.sleep(5000);
			acctLookUpObj.enterValidAcctNumber();
			acctLookUpObj.clickOnLookUp();
			acctLookUpObj.acctDetailsPageLaunch();
			log.info("Navigated to accounts page");
			if(isElementDisplayed(viewNotesPage.viewAllButton, maxWait)) {
				clickElement(viewNotesPage.viewAllButton);
			}
			else {
				log.info("There are no notes to be displayed");
			}
			
		}
		catch(Exception e){
			log.error("GOT EXCEPTION in navigating to accounts page " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When ("^I click Back Button$")
	public void backButton(){
		try {
			Thread.sleep(5000);
			clickElement(viewNotesPage.backButton);
			log.info("Back button is clicked");
			
		}
		catch (Exception e){
			log.error("GOT EXCEPTION in clicking back button(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			
		}
		
	}
	
	@Then ("^I am navigated to Account details page$")
	public void accountDetailsPage() {
		try {
			Thread.sleep(5000);
			if(isElementDisplayed(AccountDetailsPage.Appointments, maxWait)) {
				log.info("The user is navigated to the Account Details page");
			}
			else {
				log.info("Something went wrong");
			}
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in navigating to the Account Details Page");
		}
	}
	
	@Then ("^I see all the fields are displayed in table$")
	public void notesFields(){
		try {
			Thread.sleep(2000);
			if(isElementDisplayed(viewNotesPage.message, maxWait)) {
				log.info("Message Field is displayed");
			}
			if(isElementDisplayed(viewNotesPage.source, maxWait)) {
				log.info("Source Field is displayed");
			}
			if(isElementDisplayed(viewNotesPage.name, maxWait)) {
				log.info("Name Field is displayed");
			}
			if(isElementDisplayed(viewNotesPage.subject, maxWait)) {
				log.info("Subject Field is displayed");
			}
			if(isElementDisplayed(viewNotesPage.type, maxWait)) {
				log.info("Type Field is displayed");
			}
		}
		catch (Exception e){
			log.error("GOT EXCEPTION in clicking back button(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			}	
	}
	
	@Then ("^I see the sorting button is displayed in Date/Time$")
	public void sortingButton() {
		try {
			if(isElementDisplayed(viewNotesPage.sortingButton, maxWait)) {
				log.info("Sorting button is displayed");
			}
		}
		catch (Exception e){
		log.error("GOT EXCEPTION in clicking back button(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		}
		}
}

package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.AccountDetailsPage;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;

public class AccountDetails extends AccountDetailsPage{
	private static Logger log = Logger.getLogger(AccountDetails.class);
	CustomerInfoPage custinfo= new CustomerInfoPage();
	
	
	//Looks up for customer details
	@When("^I click Launch Mobile$")	
	public void launchMobile() throws Exception {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Launch Mobile", "INFO");
			if(isElementDisplayed(AccountDetailsPage.manageMobileLink,5))
			{								
				clickElement(AccountDetailsPage.launchMobileRtBtn);
			}else
			{						
				clickElement(AccountDetailsPage.launchMobileBtn);	
			}				
			log.info("Clicked on Launch Mobile");				
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Account_Details_launchMobile(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I see the customer details$")
	public void customerDetails() throws Exception{
		try{
		ExtentReporter.reportStep("BDD Step: Then I see the customer details", "INFO");
		isElementDisplayed(Address,5);
		isElementDisplayed(Telephone,5);
		isElementDisplayed(Account,5);
		isElementDisplayed(Email_Address,5);
		isElementDisplayed(Customer_for,5);
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Customer Information page$")
	public void customerinfoPage() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Customer Information page", "INFO");
			isElementDisplayed(custinfo.dobField,5);
			log.info("I see the Customer Information page");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the appointment details$")
	public void appointment() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the appointment details", "INFO");
			isElementDisplayed(AccountDetailsPage.Appointments,5);
			log.info("appointment details are present");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the service images$")
	public void serviceImages() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the service images", "INFO");
			isElementDisplayed(AccountDetailsPage.serviceimages,5);
			log.info("service images are present");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on View All$")
	public void viewAll() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click on View All", "INFO");
			clickElement(AccountDetailsPage.viewAll);
			log.info("View All is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the View Notes page$")
	public void viewNotes() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the View Notes page", "INFO");
			isElementDisplayed(AccountDetailsPage.Source,5);
			log.info("View notes page is displayed");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Add Note$")
	public void clickAddNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click on Add Note", "INFO");
			clickElement(AccountDetailsPage.addNote);
			log.info("View All is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Add New Note$")
	public void viewAddNewNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Add New Note", "INFO");
			isElementDisplayed(AccountDetailsPage.addNewnote,5);
			log.info("View notes page is displayed");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the select Note Type, Subject and Message$")
	public void viewselectNoteType() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the select Note Type, Subject and Message", "INFO");
			isElementDisplayed(AccountDetailsPage.selectNotetype,5);
			isElementDisplayed(AccountDetailsPage.Subject,5);
			isElementDisplayed(AccountDetailsPage.Message,5);
			log.info("Select Note Type, Subject and Message is displayed");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I close Add New Note$")
	public void closeAddNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I close Add New Note", "INFO");
			clickElement(AccountDetailsPage.closeAddnote);
			log.info("AddNote close icon is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I see the Account details page$")
	public void inAccountDetails() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Account details page", "INFO");
			isElementDisplayed(Address,5);
			isElementDisplayed(Telephone,5);
			isElementDisplayed(Account,5);
			isElementDisplayed(Email_Address,5);
			isElementDisplayed(Customer_for,5);	
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click cancel in Add New Note$")
	public void clickCancelAddnewnote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click cancel in Add New Note", "INFO");
			clickElement(AccountDetailsPage.cancelAddnote);
			log.info("AddNote cancel button is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Account status$")
	public void viewAccountStatus() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Account status", "INFO");
			isElementDisplayed(AccountDetailsPage.AccountStatus,5);
			log.info("Account status is displayed");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I see the Notes section$")
	public void viewNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I see the Notes section", "INFO");
			isElementDisplayed(AccountDetailsPage.addNewnote,5);
			log.info("AddNote cancel button is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^I click on Notes$")
	public void clickNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: And I click on Notes", "INFO");
			clickElement(AccountDetailsPage.Notes);
			log.info("Notes is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click Compare Bills$")
	public void clickCompareBills() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click Compare Bills", "INFO");
			clickElement(AccountDetailsPage.compareBills);
			log.info("AddNote cancel button is clicked");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Bill comparison$")
	public void viewbillComparison() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step:Then I see the Bill comparison", "INFO");
			isElementDisplayed(AccountDetailsPage.Compare2,5);
			log.info("Bill comparison is displayed");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click Manage Devices$")
	public void manageDevices() {
		try {
			clickElement(AccountDetailsPage.manageDev);	
			log.info("Clicked Manage Devices");
			Thread.sleep(5000);
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the Devices page$")
	public void devicesPage() {
		try {
			verifyText("Manage Devices");	
			log.info("Manage Devices Page is displayed");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I click on Add Note in Add New Note page$")
	public void Addnote_Addnewnote() {
		try {
			clickElement(AccountDetails.addNewNote_button);
			log.info("Clicked on Add Note in Add New Note page");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Note type required message$")
	public void notetyepe_required() {
		try {
			if(isElementDisplayed(AccountDetails.addNewNote_button,5))
			{
			log.info("Note type required message is displayed");			
		}
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I close the Note type$")
	public void closeNotetype_required() {
		try {
			clickElement(AccountDetails.close_NotetypeRequired);
			log.info("Note type Required is closed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@And("^I select the note type$")
	public void SelectNotetype() {
		try {
			String notetype= getXMLData("notetype");
			AccountDetails.selectNotetype(notetype);
			log.info("Note type is selected");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I click ok in Note type$")
	public void OkayNotetype_required() {
		try {
			clickElement(AccountDetails.Ok_NotetypeRequired);
			log.info("Note type Required  is accepted");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I close the Message required$")
	public void close_Message() {
		try {
			clickElement(AccountDetails.close_message);
			log.info("Message Required is close");
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I click ok in Message required$")
	public void ok_Message() {
		try {
			clickElement(AccountDetails.ok_message);
			log.info("Message Required is accepeted");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Message required text$")
	public void message_required() {
		try {
			if(isElementDisplayed(AccountDetails.message_required,5))
			{
				log.info("Message Required is displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Mobile Details section$")
	public void verify_mobileDetail() {
		try {
			if(isElementDisplayed(AccountDetails.mobileDetails,5))
			{
				log.info("Mobile Details is displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I click View Bill$")
	public void click_bill() {
		try {
			clickElement(AccountDetails.viewbill);
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Icon for eligible$")
	public void verify_Eligibleicon() {
		try {
			if(isElementDisplayed(AccountDetails.eligible_icon,5))
			{
				log.info("Eligibility icon is displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@And("^I see the Eligible text$")
	public void verify_Eligibletext() {
		try {
			if(isElementDisplayed(AccountDetails.eligibility_text,5))
			{
				log.info("Eligibility text is displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Bill details$")
	public void verify_bill() {
		try {
			if(isElementDisplayed(AccountDetails.verify_bill,5))
			{
				log.info("bill is displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Account Details Page(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
}

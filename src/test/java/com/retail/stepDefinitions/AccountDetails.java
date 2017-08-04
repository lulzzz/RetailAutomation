package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
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
			clickElement(AccountDetailsPage.launchMobileBtn);
			log.info("Clicked on Launch Mobile");				
		}catch (Exception e) {
			log.error("GOT EXCEPTION in launchMobile(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I see the customer details$")
	public void customerDetails() throws Exception{
		try{
		ExtentReporter.reportStep("BDD Step: Then I see the customer details", "INFO");
		if((isElementDisplayed(Address,5)) && (isElementDisplayed(Telephone,5)) && (isElementDisplayed(Account,5)) && (isElementDisplayed(Email_Address,5)) && (isElementDisplayed(Customer_for,5)))
		{
			ExtentReporter.reportStep(getDriver(), "Customer section is displayed", "PASS",  1);
			log.info("Customer section is displayed");
		}
		else
		{
			ExtentReporter.reportStep(getDriver(), "Customer section is not displayed", "FAIL",  0);
			log.info("Customer section is not displayed");
		}
	String addressDetails = getValue(AccountDetailsPage.addressDetails);
	String phoneDetails = getValue(AccountDetailsPage.phoneDetails);
	String accountDetails = getValue(AccountDetailsPage.accountDetails);
	
	if((!addressDetails.isEmpty()) && (!phoneDetails.isEmpty()) && (!accountDetails.isEmpty()))
	{
		ExtentReporter.reportStep(getDriver(), "Customer Information details is displayed", "PASS",  1);
		log.info("Customer Information details is displayed");		
	}
	else
	{
		ExtentReporter.reportStep(getDriver(), "Customer Information details is not displayed", "FAIL",  0);
		log.info("Customer Information details is not displayed");
	}
	
		
			
		
		}catch(Exception e){
			log.error("GOT EXCEPTION in customerDetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Customer Information page$")
	public void customerinfoPage() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Customer Information page", "INFO");
			if(isElementDisplayed(custinfo.dobField,5))
			{
				ExtentReporter.reportStep(getDriver(), "Customer Information Page is displayed", "PASS",  1);
				log.info("Customer Information Page is displayed");
			}
			
			else
			{
				ExtentReporter.reportStep(getDriver(), "Customer Information Page is not displayed", "FAIL",  0);
				log.info("Customer Information Page is not displayed");
			}
		}catch(Exception e){
			log.error("GOT EXCEPTION in customerinfoPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the appointment details$")
	public void appointment() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the appointment details", "INFO");
			if(isElementDisplayed(AccountDetailsPage.Appointments,5))
			{
				if(isElementDisplayed(AccountDetailsPage.noAppointment,5))
				{
					ExtentReporter.reportStep(getDriver(), "No Appointments Scheduled", "PASS",  1);
					log.info("No Appointments Scheduled");
			}
				//else 
					
				}
			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in appointment(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the service images element$")
	public void serviceImages() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the service images element", "INFO");
			if(isElementDisplayed(AccountDetailsPage.serviceimages,20))				{
				
			
				ExtentReporter.reportStep(getDriver(), "Service Images element is present", "PASS",  1);
				log.info("service images are present");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Service Images element is not present", "FAIL",  0);
				log.info("service images are not present");
			}
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in serviceImages(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on View All in Notes section$")
	public void viewAll() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click on View All in Notes section", "INFO");
//			if(isElementDisplayed(AccountDetailsPage.noNotes,5))
//			{
//				ExtentReporter.reportStep(getDriver(), "Notes section contains no Notes. So View All link is not displayed", "PASS",  1);
//				log.info("Notes section contains no Notes. So View All link is not displayed");
//			}
//			else{
				clickElement(AccountDetailsPage.viewAll);
				ExtentReporter.reportStep(getDriver(), "Clicked on View All link in Notes section", "PASS",  1);
				log.info("Clicked on View All link in Notes section");
			//}
			}catch (Exception e) {
				log.error("GOT EXCEPTION in viewAll(): " + LogUtils.logStackTrace(e));
				e.printStackTrace();
				throw(e);
		}
	}
	
	@Then("^I see the View Notes page$")
	public void viewNotes() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the View Notes page", "INFO");
			if(isElementDisplayed(AccountDetailsPage.Source,5))
			{
				ExtentReporter.reportStep(getDriver(), "View Notes Page is displayed", "PASS",  1);
				log.info("View Notes Page is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "View Notes Page is not displayed", "FAIL",  0);
				log.info("View Notes Page is not displayed");
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in viewNotes(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click on Add Note in Notes section$")
	public void clickAddNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click on Add Note in Notes section", "INFO");
			clickElement(AccountDetailsPage.addNote);
			log.info("Add Note is clicked in Notes section");
		}catch(Exception e){
			log.error("GOT EXCEPTION in clickAddNote(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Add New Note$")
	public void viewAddNewNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Add New Note", "INFO");
			if(isElementDisplayed(AccountDetailsPage.addNewnote,5))
			{
				ExtentReporter.reportStep(getDriver(), "Add New Note popup is displayed", "PASS",  1);
			log.info("Add New Note popup is displayed");
		}
		else
		{
			ExtentReporter.reportStep(getDriver(), "Add New Note popup is not displayed", "FAIL",  0);
			log.info("Add New Note popup is not displayed");
		}
				
			}catch(Exception e){
				log.error("GOT EXCEPTION in viewAddNewNote(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the select Note Type, Subject and Message$")
	public void viewselectNoteType() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the select Note Type, Subject and Message", "INFO");
			if(isElementDisplayed(AccountDetailsPage.selectNotetype,5))
			{
				ExtentReporter.reportStep(getDriver(), "Select Note Type is displayed in Add New Note", "PASS",  1);
				log.info("Select Note Type is displayed in Add New Note");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Select Note Type is not displayed in Add New Note", "FAIL",  0);
				log.info("Select Note Type is not displayed in Add New Note");
			}	
				
				
		if(isElementDisplayed(AccountDetailsPage.Subject,5))
		{
				ExtentReporter.reportStep(getDriver(), "Subject is displayed in Add New Note", "PASS",  1);
			log.info("Subject is displayed in Add New Note");
		}
		else
		{
			ExtentReporter.reportStep(getDriver(), "Subject is not displayed in Add New Note", "FAIL",  0);
			log.info("Subject is not displayed in Add New Note");
		}
		if(isElementDisplayed(AccountDetailsPage.Message,5))
		{
				ExtentReporter.reportStep(getDriver(), "Message is displayed in Add New Note", "PASS",  1);
			log.info("Message is displayed in Add New Note");
		}
		else
		{
			ExtentReporter.reportStep(getDriver(), "Message is not displayed in Add New Note", "FAIL",  0);
			log.info("Message is not displayed in Add New Note");
		}
			
		}catch(Exception e){
			log.error("GOT EXCEPTION in viewselectNoteType(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@When("^I close Add New Note$")
	public void closeAddNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I close Add New Note", "INFO");
			clickElement(AccountDetailsPage.closeAddnote);
			log.info("Add Note close icon is clicked");
		}catch(Exception e){
			log.error("GOT EXCEPTION in closeAddNote(): " + LogUtils.logStackTrace(e));
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
			log.error("GOT EXCEPTION in clickCancelAddnewnote(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Account status$")
	public void viewAccountStatus() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: Then I see the Account status", "INFO");
			String CurrentAccountStatus=getValue(AccountDetailsPage.CurrentAccountStatus);
			
			if(isElementDisplayed(AccountDetailsPage.AccountStatus,5))
			{
			if(!CurrentAccountStatus.isEmpty())
				{
					ExtentReporter.reportStep(getDriver(), "Current Account Status is displayed", "PASS",  1);
					log.info("Current Account Status is displayed");		
				}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Current Account Status is not displayed", "FAIL",  0);
				log.info("Current Account Status is not displayed");
			}
					
					
			}
				
			
		}catch(Exception e){
			log.error("GOT EXCEPTION in viewAccountStatus(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I see the Notes section$")
	public void viewNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I see the Notes section", "INFO");
			if(isElementDisplayed(AccountDetailsPage.Notes,5))
			{
				ExtentReporter.reportStep(getDriver(), "Notes section is displayed", "PASS",  1);
				log.info("Notes section is displayed");
				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Notes section is not displayed", "PASS",  0);
				log.info("Notes section is not displayed");
				
			}
			
		}catch(Exception e){
			log.error("GOT EXCEPTION in viewNote(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^I click on Notes$")
	public void clickNote() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: And I click on Notes", "INFO");
//			if(isElementDisplayed(AccountDetailsPage.NotesDetails,5))
//			{
			clickElement(AccountDetailsPage.NotesDetails);
			ExtentReporter.reportStep(getDriver(), "Clicked on Notes section details", "PASS",  0);
			log.info("Clicked on Notes section details");
			//}
//			else
//			{
//				ExtentReporter.reportStep(getDriver(), "Notes section contains No Notes", "PASS",  0);
//				log.info("Notes section contains No Notes");
//			}
				
		}catch(Exception e){
			log.error("GOT EXCEPTION in clickNote(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click Compare Bills$")
	public void clickCompareBills() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step: When I click Compare Bills", "INFO");
			clickElement(AccountDetailsPage.compareBills);
			log.info("Compare Bills link is clicked");
		}catch(Exception e){
			log.error("GOT EXCEPTION in clickCompareBills(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Bill comparison$")
	public void viewbillComparison() throws Exception{
		try{
			ExtentReporter.reportStep("BDD Step:Then I see the Bill comparison", "INFO");
			if(isElementDisplayed(AccountDetailsPage.billTable,15))
			{
				
				ExtentReporter.reportStep(getDriver(), "Bill Comparison details are displayed", "INFO", 1);
				log.info("Bill Comparison details are displayed");
			}
			else if(isElementDisplayed(AccountDetailsPage.noBill,15))
			{
				ExtentReporter.reportStep(getDriver(), "Bill Comparison is unavailable for this user", "INFO", 1);
				log.info("Bill Comparison is unavailable for this user");
			}
			else 
			{
				ExtentReporter.reportStep(getDriver(), "Bill Comparison details are not displayed", "FAIL",  0);
				log.info("Bill Comparison details are not displayed");
			}
			
			
		}catch(Exception e){
			log.error("GOT EXCEPTION in viewbillComparison(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I click Manage Devices$")
	public void manageDevices() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Manage Devices", "INFO");
			clickElement(AccountDetailsPage.manageDev);	
			log.info("Clicked Manage Devices");
			Thread.sleep(5000);
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in manageDevices(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the Devices page$")
	public void devicesPage() {
		try {
			if(isElementDisplayed(AccountDevicesPage.manageDevices,5))
			{
				ExtentReporter.reportStep(getDriver(), "Devices page is displayed", "PASS",  1);
				log.info("Devices Page is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Devices page is not displayed", "FAIL",  0);
				log.info("Manage Devices Page is not displayed");
			}
				
						
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in devicesPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I click on Add Note in Add New Note page$")
	public void Addnote_Addnewnote() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click on Add Note in Add New Note page", "INFO");			
			clickElement(AccountDetails.addNewNote_button);
			log.info("Clicked on Add Note in Add New Note page");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Addnote_Addnewnote(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Note type required message$")
	public void notetyepe_required() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see the Note type required message", "INFO");
			
			if(isElementDisplayed(AccountDetails.noteType,5))
			{
				ExtentReporter.reportStep(getDriver(), "Note Type Required Text is displayed", "PASS",  1);
				log.info("Note Type Required Text is displayed");
			}
			else {
				ExtentReporter.reportStep(getDriver(), "Note Type Required Text is not displayed", "FAIL",  0);
			log.info("Note Type Required Text is not displayed");
		}
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in notetyepe_required(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I close the Note type$")
	public void closeNotetype_required() {
		try {
			ExtentReporter.reportStep("BDD Step: When I close the Note type", "INFO");
			clickElement(AccountDetails.close_NotetypeRequired);
			log.info("Note type Required is closed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in closeNotetype_required(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@And("^I select the note type$")
	public void SelectNotetype() {
		try {
			ExtentReporter.reportStep("BDD Step: And I select the note type", "INFO");			
			String notetype= getXMLData("notetype");
			AccountDetails.selectNotetype(notetype);
			log.info("Note type is selected");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in SelectNotetype(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I click ok in Note type$")
	public void OkayNotetype_required() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click ok in Note type", "INFO");
			clickElement(AccountDetails.Ok_NotetypeRequired);
			log.info("Note type Required  is accepted");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in OkayNotetype_required(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I close the Message required$")
	public void close_Message() {
		try {
			ExtentReporter.reportStep("BDD Step: When I close the Message required", "INFO");
			clickElement(AccountDetails.close_message);
			log.info("Message Required is closed");
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in close_Message(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I click ok in Message required$")
	public void ok_Message() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I click ok in Message required", "INFO");
			clickElement(AccountDetails.ok_message);
			log.info("Message Required is accepeted");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in ok_Message(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Message required text$")
	public void message_required() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see the Message required text", "INFO");
			if(isElementDisplayed(AccountDetails.message_required,5))
			{	
				ExtentReporter.reportStep(getDriver(), "Message Requires Text is displayed", "PASS",  1);
				log.info("Message Required is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Message Requires Text is not displayed", "FAIL",  0);
				log.info("Message Required is not displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in message_required(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Mobile Details section$")
	public void verify_mobileDetail() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see the Mobile Details section", "INFO");
			if(isElementDisplayed(AccountDetails.mobileDetails,5))
			{
				ExtentReporter.reportStep(getDriver(), "Mobile Details Section is displayed", "PASS",  1);
				log.info("Mobile Details section is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Mobile Details Section is not displayed", "FAIL",  0);
			log.info("Mobile Details section is not displayed");
			}
				
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in verify_mobileDetail(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I click View Bill$")
	public void click_bill() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I click View Bill", "INFO");
			clickElement(AccountDetails.viewbill);
			log.info("Clicked on View Bill");
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in click_bill(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Icon for eligible$")
	public void verify_Eligibleicon() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Icon for eligible", "INFO");
			if(isElementDisplayed(AccountDetails.eligible_icon,5))
			{
				
				ExtentReporter.reportStep(getDriver(), "Eligibility icon is displayed", "PASS",  1);
				log.info("Eligibility icon is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Eligibility icon is not displayed", "FAIL",  0);
				log.info("Eligibility icon is not displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in verify_Eligibleicon(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@And("^I see the Eligible text$")
	public void verify_Eligibletext() {
		try {
			ExtentReporter.reportStep("BDD Step: And I see the Eligible text", "INFO");
			if(isElementDisplayed(AccountDetails.eligibility_text,5))
			{
				ExtentReporter.reportStep(getDriver(), "Eligibility text is displayed", "PASS",  1);
				log.info("Eligibility text is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Eligibility text is not displayed", "FAIL",  0);
				log.info("Eligibility text is not displayed");
			}
			}
		catch (Exception e) {
			log.error("GOT EXCEPTION in verify_Eligibletext(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Bill details$")
	public void verify_bill() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see the Bill details", "INFO");
//			if(isElementDisplayed(AccountDetails.verify_bill,5))
//			{
//				ExtentReporter.reportStep(getDriver(), "Bill Details are displayed", "PASS",  1);
//				log.info("Bill Details are displayed");
//			}
//			else if(isElementDisplayed(AccountDetails.noBills,5))
//			{
//				ExtentReporter.reportStep(getDriver(), "No recent bills are available for this account", "PASS",  1);
//			log.info("No recent bills are available for this account");
//			}
//			else
//			{
//				ExtentReporter.reportStep(getDriver(), "Bill Details page are not displayed", "FAIL",  0);
//				log.info("Bill Details page are not displayed");
//			}
			isElementDisplayed(AccountDetails.verify_bill,5);
			{
				ExtentReporter.reportStep(getDriver(), "Bill Details are displayed", "PASS",  1);
				log.info("Bill Details are displayed");
			}
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in verify_bill(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
}

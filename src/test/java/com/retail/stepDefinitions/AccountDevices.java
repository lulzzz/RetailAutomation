package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.*;

import cucumber.api.java.en.*;



public class AccountDevices extends AccountDevicesPage{

	private static Logger log = Logger.getLogger(AccountDevices.class);
	
	
	CustomerInfo custMoreInfoObj= new CustomerInfo();
	AccountLookUp acctLookUpObj= new AccountLookUp();
	AccountDetails acctDetailsObj = new AccountDetails();
	
	@Given("^I am in Devices page$")
	public void devicesPge() throws Exception
	{
			acctLookUpObj.lookupinput();
			acctLookUpObj.acctDetailsPageLaunch();
			acctDetailsObj.manageDevices();
			acctDetailsObj.devicesPage();		
			
	}
	
	@Then("^I see the Scan device message displayed$")
	public void scanMsg() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Scan device message displayed", "INFO");
			verifyText("Scan Device");
			log.info("Scan Device message is displayed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in scanMsg(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I click Scan Device$")
	public void scanDev() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Scan Device", "INFO");
			clickElement(AccountDevicesPage.scanDevice);
			log.info("Scan Device message is displayed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in scanDev(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I click Add Device Manually$")
	public void addDev() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Add Device Manually", "INFO");
			clickElement(AccountDevicesPage.addDevice);
			log.info("Clicked Add Device");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in addDev(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the Add Device page$")
	public void devicesPage() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Add Device page", "INFO");
			verifyText("Add Device");
			log.info("Add Device Page is displayed");
			Thread.sleep(5000);
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in addDev(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I click Back$")
	public void backButton() {
		try  {
			ExtentReporter.reportStep("BDD Step: I click Back", "INFO");
			clickElement(AccountDevicesPage.backButton);
			log.info("Clicked Back in Account Devices Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in backButton(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
		
	@Then("^I see the Account Details page$")
	public void accountDetails() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Account details page", "INFO");
			verifyText("Account Status");
			verifyText("Manage Devices");
			//verifyText("View Bill(PDF)");
			verifyText("Compare Bills");
			log.info("Account Details page is displayed");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in accountDetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
			
	
	@When("^I close Add Device page$")
	public void closeaddDev() {
		try {
			ExtentReporter.reportStep("BDD Step: I close Add Device page", "INFO");
			clickElement(AccountDevicesPage.closeaddDev);
			log.info("Closing Add Device Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in closeaddDev(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the warning message$")
	public void warningMessage() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the warning message", "INFO");
			verifyText("Warning");
			verifyText("Are you sure you want to cancel this transaction?");
			log.info("Warning Message is displayed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in warningMessage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I cancel Add Device page$")
	public void canceladdDev() {
		try {
			ExtentReporter.reportStep("BDD Step: I cancel Add Device page", "INFO");
			clickElement(AccountDevicesPage.canceladdDev);
			log.info("Clicking Cancel in Add Device Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in canceladdDev(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
		
	@When("^I click Yes in warning page$")
	public void warningYes() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Yes in warning page", "INFO");
			clickElement(AccountDevicesPage.warningYes);
			log.info("Clicking Yes button in Warning Message Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in warningYes(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I click No in warning page$")
	public void warningNo() {
		try {
			ExtentReporter.reportStep("BDD Step: I click No in warning page", "INFO");
			clickElement(AccountDevicesPage.warningNo);
			log.info("Clicking No button in Warning Message Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in warningNo(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I close the warning page$")
	public void closeWarning() {
		try {
			ExtentReporter.reportStep("BDD Step: I close the warning page", "INFO");
			clickElement(AccountDevicesPage.closeWarning);
			log.info("Clicking Close button in Warning Message Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in closeWarning(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I enter invalid number$")
	public void invalidNumber() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter invalid number", "INFO");
			typeValue(AccountDevicesPage.deviceNumber,getXMLData("Device_Number"));
			log.info("Entered Invalid Number in Add Device Details");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in invalidNumber(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@And("^I click Next$")
	public void nextAddDev() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Next", "INFO");
			clickElement(AccountDevicesPage.nextaddDev);
			log.info("Clicked Next button in Add Device Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in nextAddDev(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the error message$")
	public void errorMessage() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the error message", "INFO");
			clickElement(AccountDevicesPage.nextaddDev);
			log.info("Device not found message is displayed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in errorMessage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I click ok in error page$")
	public void errorOk() {
		try {
			ExtentReporter.reportStep("BDD Step: I click ok in error page", "INFO");
			clickElement(AccountDevicesPage.errorOk);
			log.info("Clicking Ok in Error Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in errorOk(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I close the error page$")
	public void errorClose() {
		try {
			ExtentReporter.reportStep("BDD Step: I close the error page", "INFO");
			clickElement(AccountDevicesPage.errorClose);
			log.info("Clicking Close in Error Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in errorClose(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I enter valid number$")
	public void validNumber() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter valid number", "INFO");
			typeValue(AccountDevicesPage.deviceNumber,getXMLData("Device_Number_Valid"));
			log.info("Entered Valid Number in Add Device Details");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in validNumber(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the device details$")
	public void deviceDetails() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the device details", "INFO");
			verifyText("Check the model and serial number");
			verifyText("Model");
			verifyText("Type");
			verifyText("Serial #");
			verifyText("Manufacturer");
			log.info("Device Details page is displayed");
			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in deviceDetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I close the device details$")
	public void deviceDetailsClose() {
	try {
		ExtentReporter.reportStep("BDD Step: I close the device details", "INFO");
		clickElement(AccountDevicesPage.deviceDetailsClose);
		log.info("Clicking Close button in Device Details Page");
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in deviceDetailsClose(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}
	
	@When("^I click cancel in device details$")
	public void deviceDetailsCancel() {
		try {
			ExtentReporter.reportStep("BDD Step: I click cancel in device details", "INFO");
			clickElement(AccountDevicesPage.deviceDetailsCancel);
			log.info("Clicking Cancel button in Device Details Page");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in deviceDetailsCancel(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
}
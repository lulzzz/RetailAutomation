package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.Color;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.framework.wrapper.WebOperations;
import com.retail.pageObjects.*;
import com.retail.stepDefinitions.*;

import cucumber.api.java.en.*;


public class DeviceSearch extends DeviceSearchPage{

	private static Logger log = Logger.getLogger(DeviceSearch.class);
	AccountLookUp accountlookup = new AccountLookUp();
	AccountDetails acctDetailsObj= new AccountDetails();
	CustomerInfo custMoreInfoObj= new CustomerInfo();
	DeviceConfig deviceconf = new DeviceConfig();
	DeviceBrand deviceBrand = new DeviceBrand();
	DeviceCustomize deviceCustomizeObj = new DeviceCustomize();
	CustomerPreSignaturePage custPage= new CustomerPreSignaturePage();
	ShoppingCart shopcart = new ShoppingCart();
	BrowseDevice browsedevice= new BrowseDevice();
	BrowseAccessory browseAccessory= new BrowseAccessory();
	BrowseAccessoryPage browserAccessoryPage= new BrowseAccessoryPage();
	public static int device_count=1;
	
	@Given("^I am in Device Search Page$")
	public void deviceSearch() {
		try {
			accountlookup.enterValidAcctNumber();
			accountlookup.clickOnLookUp();
			accountlookup.acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
			if(isElementDisplayed(CustomerInfoPage.dobField,10))
			{
			custMoreInfoObj.enterValidDOB();	
			custMoreInfoObj.enterValidSSN();
			custMoreInfoObj.selectValidLines();
			}
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
			if(isElementDisplayed(ShoppingCartPage.cartImage,5))
			{ 
		ExtentReporter.reportStep(getDriver(), "Device Search Page is displayed", "PASS",  1);
			}
	else
	{
		ExtentReporter.reportStep(getDriver(), "Device Search Page is displayed", "FAIL",  0);
	} 
			
		
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in deviceSearch(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
	}
}	
	@Given("^I lookup for a customer and I shop a device$")
	public void shopDevice() throws Exception {
		try {
			accountlookup.enterValidAcctNumber();
			accountlookup.clickOnLookUp();
			accountlookup.acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
			if(isElementDisplayed(CustomerInfoPage.dobField,10))
			{
			custMoreInfoObj.enterValidDOB();	
			custMoreInfoObj.enterValidSSN();
			custMoreInfoObj.selectValidLines();
			}
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
			validIMEI();
			searchbutton();
			devicedetails();
			validSIMnumber();
			nextbutton();
			deviceConfig();
	}
		catch (Exception e) {
			log.error("GOT EXCEPTION in shopDevice():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Device Search Page$")
	public void devSearch() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Device Search Page", "INFO");
//			String verifyShipping=getValue(DeviceSearchPage.verifyShipping);
//			verifyText(verifyShipping);
			if(isElementDisplayed(ShoppingCartPage.cartImage,5))
			{ 
		ExtentReporter.reportStep(getDriver(), "Device Search Page is displayed", "PASS",  1);
			}
	else
	{
		ExtentReporter.reportStep(getDriver(), "Device Search Page is not displayed", "FAIL",  0);
	}

			log.info("Device Search Page is displayed");
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in devSearch(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I enter invalid IMEI with less than 15 digits$")
	public void invalidIMEI_lessdigits() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter invalid IMEI with less than 15 digits", "INFO");
			clickElement(DeviceSearchPage.IMEInum);
			log.info("Clicked on IMEI");	
			typeValue(DeviceSearchPage.IMEInum,getXMLData("IMEInumber"));
			log.info("Entered IMEI number");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in invalidIMEI_lessdigits(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I enter IMEI with more than 15 digits$")
	public void invalidIMEI_moredigits() {
		try {
			ExtentReporter.reportStep("BDD Step: I enter IMEI with more than 15 digits", "INFO");
			clickElement(DeviceSearchPage.IMEInum);
			log.info("Clicked on IMEI");	
			typeValue(DeviceSearchPage.IMEInum,getXMLData("IMEInumber"));
			log.info("Entered IMEI number");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in invalidIMEI_moredigits(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	
	@When("^I click on BYOD$")
	public void BYOD() {
		try {
			ExtentReporter.reportStep("BDD Step: I click on BYOD", "INFO");
			clickElement(DeviceSearchPage.BYOD);
			log.info("Clicked on BYOD");	
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in BYOD(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I uncheck BYOD$")
	public void uncheck_BYOD() {
		try {
			ExtentReporter.reportStep("BDD Step: I uncheck BYOD", "INFO");
			clickElement(DeviceSearchPage.BYOD);
			log.info("Unchecked BYOD");	
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in uncheck_BYOD(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
		
	@Then("^I see the settings details$")
	public void settingsDisplay() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the settings details", "INFO");
			String settingsText1=getValue(DeviceSearchPage.settingsText1);
			verifyText(settingsText1);
			log.info("Dial pad setting is displayed");
			String settingsText2=getValue(DeviceSearchPage.settingsText2);
			verifyText(settingsText2);
			log.info("IMEI number settings is displayed");		
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in settingsDisplay(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	
	@Then("^It should not accept$")
	public void notAccept() {
		try {
			ExtentReporter.reportStep("BDD Step: It should not accept", "INFO");
			//String IMEInumber = (typeValue(DeviceSearchPage.IMEInum));
			
						
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in notAccept(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I must see the Shipping address displayed$")
	public void address_Display() {
		try {
			String verifyShipping=getValue(DeviceSearchPage.verifyShipping);
			verifyText(verifyShipping);
			String name=getValue(DeviceSearchPage.name);			
			String address1=getValue(DeviceSearchPage.address1);			
			String address2=getValue(DeviceSearchPage.address2);			
			//String city=getValue(DeviceSearchPage.city);			
			if((!name.isEmpty()) && (!address1.isEmpty()) && (!address2.isEmpty()))
			{
				ExtentReporter.reportStep(getDriver(), "Shipping Address is displayed", "PASS",  1);
				log.info("Shipping Address is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Shipping Address is not displayed", "FAIL",  0);
				log.info("Shipping Address is not displayed");
			}		
		}
		
		catch (Exception e) {
			log.error("GOT EXCEPTION in address_Display(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the Shipping Address details$")
	public void shipAddress() {
		address_Display();
	}
	
	
	@Then("^Search button should not be enabled$")
	public String searchDisabled() {
		String back_color1 = null;
		String color1 = null;
		try {
			//String IMEIrow= getCssvalue(DeviceSearchPage.IMEIrow);
			//getCssValue(DeviceSearchPage.IMEIrow);
//			back_color1 = getDriver().findElement(DeviceSearchPage.IMEIrow).getCssValue("background-color").toString();
//			System.out.println(back_color1);
//			String hex = Color.fromString(back_color1).asHex();
//			System.out.println(hex);
//			color1 = getDriver().findElement(DeviceSearchPage.IMEIrow).getCssValue("color");
//			System.out.println(color1);
//			String hex1 = Color.fromString(color1).asHex();
//			System.out.println(hex1);
			ExtentReporter.reportStep("BDD Step: Search button should not be enabled", "INFO");
			
			String value = getDriver().findElement(DeviceSearchPage.searchbutton).getAttribute("disabled");
			System.out.println(value);
			if(value.equals("true"))
			{
				ExtentReporter.reportStep(getDriver(), "Search button is disabled", "PASS",  1);
				log.info("Search button is disabled");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Search button is enabled", "FAIL",  0);
				log.info("Search button is enabled");
			}
			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in searchDisabled(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
		return back_color1;
	}
	
	@Then("^Next Button should be enabled$")
	public void nextEnable() {
		String back_color1;
		try {
	ExtentReporter.reportStep("BDD Step: Next Button should be enabled", "INFO");	
	back_color1 = getDriver().findElement(DeviceSearchPage.nextbutton).getCssValue("background-color").toString();
	System.out.println(back_color1);
	String hex = Color.fromString(back_color1).asHex();
	System.out.println(hex);
//	if(back_color1.equals(rgba(2, 114, 182, 1)))
//	{
//		ExtentReporter.reportStep("Next button is enabled", "INFO");
//		log.info("Next button is enabled");
//	}
//	//else
//	{
//		ExtentReporter.reportStep("Next button is disabled", "INFO");
//		log.info("Next button is disabled");
//	}
//	
//	String value = getDriver().findElement(DeviceSearchPage.nextbutton).getAttribute("disabled");
//	System.out.println(value);
//	if(value.equals("null"))
//	{
//		ExtentReporter.reportStep(getDriver(), "Search button is enabled", "PASS",  1);
//		log.info("Search button is enabled");
//	}
//	else
//	{
//		ExtentReporter.reportStep(getDriver(), "Search button is disabled", "FAIL",  0);
//		log.info("Search button is disabled");
//	}
}
catch (Exception e) {
	log.error("GOT EXCEPTION in nextEnable(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
}
//return back_color1;
}
	
	@When("^I click on cancel button$")
	public void cancel() {
		try {
			ExtentReporter.reportStep("BDD Step: I click on cancel button", "INFO");			
			clickElement(DeviceSearchPage.cancel);
			log.info("Clicked on Cancel button");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in cancel(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	
	@When("^I click on close button$")
	public void close() {
		try {
			ExtentReporter.reportStep("BDD Step: I click on close button", "INFO");			
			clickElement(DeviceSearchPage.close);
			log.info("Clicked on Close button");			
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in close(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	

	
	



@And("^I see the Phone name,color and IMEI$")
	public void phoneDetails() {
	try {
		String phoneName=getValue(DeviceSearchPage.phoneName);			
		String phoneColor=getValue(DeviceSearchPage.phoneColor);			
		String phoneIMEI=getValue(DeviceSearchPage.phoneIMEI);			
		if((!phoneName.isEmpty()) && (!phoneColor.isEmpty()) && (!phoneIMEI.isEmpty()))
		{
			ExtentReporter.reportStep(getDriver(), "Phone Name, Color and IMEI are displayed", "PASS",  1);
			log.info("Phone Name, Color and IMEI are displayed");
		}
		else
		{
			ExtentReporter.reportStep(getDriver(), "Phone Name, Color and IMEI are not displayed", "FAIL",  0);
			log.info("Phone Name, Color and IMEI are not displayed");
		}
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in phoneDetails(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@When("^I click on Edit button$")
	public void editButton() {
	try {
		ExtentReporter.reportStep("BDD Step: I click on Edit button", "INFO");
		clickElement(DeviceSearchPage.editButton);
		log.info("Clicked on Edit button");
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in editButton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@And("^I check address details are displayed$")
public void addressDetails() {
	try {
		ExtentReporter.reportStep("BDD Step: I check address details are displayed", "INFO");
		String firstName=getValue(DeviceSearchPage.firstName);
		String lastName=getValue(DeviceSearchPage.lastName);			
		String address=getValue(DeviceSearchPage.address);			
		String cityName=getValue(DeviceSearchPage.cityName);	
		String state=getValue(DeviceSearchPage.state);	
		String zip=getValue(DeviceSearchPage.zip);			
		if((!firstName.isEmpty()) && (!lastName.isEmpty()) && (!address.isEmpty()) && (!cityName.isEmpty()) && (!zip.isEmpty()) && (!state.isEmpty()))
		{
			ExtentReporter.reportStep(getDriver(), "Shipping Address is displayed", "PASS",  1);
			log.info("Shipping Address is displayed");
		}
		else
		{
			ExtentReporter.reportStep(getDriver(), "Shipping Address is not displayed", "FAIL",  0);
			log.info("Shipping Address is not displayed");
		}
	}
		catch (Exception e) {
			log.error("GOT EXCEPTION in addressDetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	

@And("^I save the address by enabling the service address$")
	public void saveAddress() {
	try {
		ExtentReporter.reportStep("BDD Step: I save the address", "INFO");
		clickElement(DeviceSearchPage.serviceAddress);
		log.info("Enabled Service Address button");		
		clickElement(DeviceSearchPage.save);
		log.info("Clicked on Save button");
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in saveAddress(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
	}



		



@When("^I enter invalid SIM number$")
public void invalidSIM() {
	try {
		ExtentReporter.reportStep("BDD Step: I enter invalid SIM number", "INFO");
		if(isElementDisplayed(DeviceSearchPage.editsim, 5))
		{
				clickElement(DeviceSearchPage.editsim);
				log.info("Clicked on Edit SIM");
//				Thread.sleep(2000);
//				System.out.println(getXMLData("SIMnumber"));
				clickElement(DeviceSearchPage.SIMnum);
				log.info("Clicked on SIM number");	
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"));				
				log.info("Entered SIM number");	

	}
		else
		{			
			clickElement(DeviceSearchPage.SIMnum);
			log.info("Clicked on SIM number");	
			System.out.println(getXMLData("SIMnumber"));
			String flag=getXMLData("flag");
			if(flag.equals("H"))
			{
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"+device_count));
				log.info("Entered SIM number");	
				
			}
			if(flag.equals("S")){
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"));
				log.info("Entered SIM number");	
			}
			
		}
		clickElement(DeviceSearchPage.phoneDet);
		log.info("Clicked on Phone Details section");
		String errorMessage=getValue(DeviceSearchPage.errorMessage);
		verifyText(errorMessage);
		log.info("Error message is displayed as SIM number contains 20 digits");
		
					
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in validSIMnumber(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@Then("^Next button should not be enabled$")
public void nextDisable() {
	try {
		 ExtentReporter.reportStep("BDD Step: Next button should not be enabled", "INFO");
         String value = getDriver().findElement(DeviceSearchPage.nextbutton).getAttribute("disabled");
         System.out.println(value);
         if(value.equals("true"))
         {
        	 ExtentReporter.reportStep(getDriver(), "Next button is disabled", "PASS",  1);
        	 log.info("Next button is disabled");
         }
         else
         {
        	 ExtentReporter.reportStep(getDriver(), "Next button is enabled", "FAIL",  0);
        	 log.info("Next button is enabled");
         }
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in nextDisable(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}

}

@Then("^I see the Device Config Page$")
public void deviceConfig() {
	try {
		ExtentReporter.reportStep("BDD Step: I see the Device Config Page", "INFO");
		String pay_plan=getValue(DeviceConfigPage.pay_plan);
		verifyText(pay_plan);
		String deviceProtect=getValue(DeviceConfigPage.deviceProtect);
		verifyText(deviceProtect);
		String dataOption=getValue(DeviceConfigPage.dataOption);
		verifyText(dataOption);
		log.info("Device Config Page is displayed");		
	}
	
	catch (Exception e) {
		log.error("GOT EXCEPTION in deviceConfig(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
}
}

	@When("^I enter valid IMEI with 15 digits$")	
	public void validIMEI()  {
		try {
			String flag=getXMLData("flag");
			if(flag.equals("H"))
			{
					String IMEI=getXMLData("IMEInumber"+device_count);
					clickElement(DeviceSearchPage.IMEInum);
					log.info("Clicked on IMEI");	
					typeValue(DeviceSearchPage.IMEInum,IMEI);
					log.info("Entered IMEI number");
			}
			if(flag.equals("S"))
			{
				String IMEI=getXMLData("IMEInumber");
				clickElement(DeviceSearchPage.IMEInum);
				log.info("Clicked on IMEI");	
				typeValue(DeviceSearchPage.IMEInum,IMEI);
				log.info("Entered IMEI number");				
			}
		}catch (Exception e) {
			log.error("GOT EXCEPTION in validIMEI(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}		

@Then("^I click on Search button$") 
	public void searchbutton() throws Exception {
	try {
		clickElement(DeviceSearchPage.searchbutton);
		log.info("Clicked on search button");	
//		Thread.sleep(5000);	
		
	}catch (Exception e) {
		log.error("GOT EXCEPTION in searchbutton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}	

@Then("^I should see a Popup with Device details$")
	public void devicedetails() throws Exception {
	try {
		//WebOperations.verifyText("Sim Number");
		log.info("Device Search Page contains SIM NUMBER text");			
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in devicedetails(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@When("^I enter valid SIM number with 20 digits$")
public void validSIMnumber() throws Exception {
	try {	
		
		if(isElementDisplayed(DeviceSearchPage.editsim, 5))
		{
				clickElement(DeviceSearchPage.editsim);
				log.info("Clicked on Edit SIM");
//				Thread.sleep(2000);
//				System.out.println(getXMLData("SIMnumber"));
				clickElement(DeviceSearchPage.SIMnum);
				log.info("Clicked on SIM number");	
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"));				
				log.info("Entered SIM number");	

	}
		else
		{			
			clickElement(DeviceSearchPage.SIMnum);
			log.info("Clicked on SIM number");	
			System.out.println(getXMLData("SIMnumber"));
			String flag=getXMLData("flag");
			if(flag.equals("H"))
			{
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"+device_count));
				log.info("Entered SIM number");	
				
			}
			if(flag.equals("S")){
				typeValue(DeviceSearchPage.SIMnum,getXMLData("SIMnumber"));
				log.info("Entered SIM number");	
			}
			
		}		
					
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in validSIMnumber(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@Then("^I click on Next button$")
public void nextbutton() throws Exception {
	try {
		clickElement(DeviceSearchPage.nextbutton);
		log.info("Clicked on next button");	
//		Thread.sleep(5000);				
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in nextbutton(): " + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@And("^agent scans the device$")
		public void scanDevice() throws Exception
	{
		try{
		validIMEI();
		searchbutton();
		devicedetails();
		validSIMnumber();
		nextbutton();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
		
	}
@Given("^I am in Shopping cart Page through Scan flow$")
public void shopCart_scan() throws Exception {
	try {
		accountlookup.enterValidAcctNumber();
		accountlookup.clickOnLookUp();
		accountlookup.acctDetailsPageLaunch();
		acctDetailsObj.launchMobile();
		if(isElementDisplayed(CustomerInfoPage.dobField,10))
		{
		custMoreInfoObj.enterValidDOB();	
		//custMoreInfoObj.enterValidSSN();
		custMoreInfoObj.selectValidLines();
		}
		if(isElementDisplayed(custPage.run_creditCheck,5))
		{
	clickElement(custPage.run_creditCheck);
	if(isElementDisplayed(custPage.approved_check,5))
	{
		clickElement(custPage.close);
	}
		}
		scanDevice();
		//deviceConfig();
		deviceconf.paymentplan();
		deviceconf.protectionplan();
		deviceconf.dataplan();
		deviceconf.nextdeviceconfig();	
		deviceCustomizeObj.choosenumber();
		deviceCustomizeObj.name();
		deviceCustomizeObj.addtocart();
		shopcart.shopPage();
}
	catch (Exception e) {
		log.error("GOT EXCEPTION in shopCart_scan():" + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}
@Given("^I am in Device Config Page through Scan flow$")
public void deviceConfig_scan() throws Exception {
	try {
		accountlookup.enterValidAcctNumber();
		accountlookup.clickOnLookUp();
		accountlookup.acctDetailsPageLaunch();
		acctDetailsObj.launchMobile();
		if(isElementDisplayed(CustomerInfoPage.dobField,10))
		{
		custMoreInfoObj.enterValidDOB();	
		//custMoreInfoObj.enterValidSSN();
		custMoreInfoObj.selectValidLines();
		}
		if(isElementDisplayed(custPage.run_creditCheck,5))
		{
	clickElement(custPage.run_creditCheck);
	if(isElementDisplayed(custPage.approved_check,5))
	{
		clickElement(custPage.close);
	}
		}
		scanDevice();
		
	}
	catch (Exception e) {
		log.error("GOT EXCEPTION in deviceConfig_scan():" + LogUtils.logStackTrace(e));
		e.printStackTrace();
		throw(e);
	}
}

@When("^I click on Verify Button$") 
public void clickVerify() throws Exception {
try {
	clickElement(DeviceSearchPage.verifybutton);
	log.info("Clicked on verify button");	
	
}catch (Exception e) {
	log.error("GOT EXCEPTION in verifybutton(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
	throw(e);
}
}

@Then("^I should get redirected to Device_Brands page$")
public void redirectToDevicBrand() throws Exception {
try {
	isElementDisplayed(DeviceBrandPage.PhoneByBrand,10);
	log.info("Verify Device Button");	
	
}catch (Exception e) {
	log.error("GOT EXCEPTION in verifybutton(): " + LogUtils.logStackTrace(e));
	e.printStackTrace();
	throw(e);
}
}
	
@Given("^agent navigates to 'verify' link to shop for a device$")
public void verifylink() throws Exception{
	try{
		accountlookup.enterValidAcctNumber();
	accountlookup.clickOnLookUp();
	accountlookup.acctDetailsPageLaunch();
	acctDetailsObj.launchMobile();
	if(isElementDisplayed(CustomerInfoPage.dobField,10))
	{
	custMoreInfoObj.enterValidDOB();	
	custMoreInfoObj.enterValidSSN();
	custMoreInfoObj.selectValidLines();
	}
	if(isElementDisplayed(CustomerPreSignaturePage.run_creditCheck,5)){
		clickElement(CustomerPreSignaturePage.run_creditCheck);
		
	}
	clickVerify();
	redirectToDevicBrand();
	
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}

@Given("^agent navigates to 'verify' link to shop for just accessory$")
public void verifylinkforaccessory1() throws Exception{
	try{
	accountlookup.enterValidAcctNumber();
	accountlookup.clickOnLookUp();
	accountlookup.acctDetailsPageLaunch();
	acctDetailsObj.launchMobile();	
	if(isElementDisplayed(CustomerInfoPage.dobField,10))
	{
	custMoreInfoObj.enterValidDOB();	
	custMoreInfoObj.enterValidSSN();
	custMoreInfoObj.selectValidLines();
	}
	clickVerify();
	redirectToDevicBrand();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}

@Given("^agent searches for customers account number to shop accessory$")
public void agentLooksForAcct() throws Exception{
	try{	
	accountlookup.enterValidAcctNumber();
	accountlookup.clickOnLookUp();
	accountlookup.acctDetailsPageLaunch();
	acctDetailsObj.launchMobile();	
	if(isElementDisplayed(CustomerInfoPage.dobField,10))
	{
	custMoreInfoObj.enterValidDOB();	
	custMoreInfoObj.enterValidSSN();
	custMoreInfoObj.selectValidLines();
	}	
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
}

	@When("^agent clicks on 'verify' link$")
	public void clickShipFlow() throws Exception{
		try{		
			clickVerify();
			redirectToDevicBrand();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}

	@Then("^agent sees the message to add a device first$")
	public void addDeviceFirst() throws Exception{
		try{		
			WebOperations.verifyText("In order to ship an accessory, first add a device to the cart.");
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
	@And("^agent adds hybrid devices into cart through scan$")
	public void add_hybridDevice_Scan() throws Exception
	{
	int a=0;
	while(a<2)
	{
	System.out.println(a);
	validIMEI();
	searchbutton();
	devicedetails();
	validSIMnumber();
	nextbutton();
	deviceconf.paymentplan();
	deviceconf.protectionplan();
	deviceconf.dataplan();
	deviceconf.nextdeviceconfig();	
	deviceCustomizeObj.choosenumber();
	deviceCustomizeObj.name();
	deviceCustomizeObj.addtocart();
	shopcart.verifyDeviceCharges();
	device_count=device_count+1;
	if(a==0){
	shopcart.add_anotherLine();
	//if(isElementDisplayed(CustomerPreSignaturePage.runCreditCheck,5)){
	//clickElement(CustomerPreSignaturePage.runCreditCheck);
	//clickElement(CustomerPreSignaturePage.backToProfile);
	//System.exit(0);
	//}
	}
	a=a+1;
	}
	device_count=1;
	}
	@And("^agent adds hybrid devices into cart through verify$")
	public void add_hybridDevice_Verify() throws Exception
	{
		int devices=0;
		 clickVerify();
		 redirectToDevicBrand();
			 while(devices<2)
			 {
		     deviceBrand.selectDeviceBrand();
		     deviceBrand.redirectedToBrowseDevice();
		     browsedevice.selectDevice_Verify();
		     browsedevice.selectStorage_Verify();
		     browsedevice.selectColor_Verify();
		     browsedevice.verifyTotalAmount();
		     browsedevice.clickSelect();
		     deviceconf.paymentplan();
		     deviceconf.protectionplan();
		     deviceconf.dataplan();
		 	 deviceconf.nextdeviceconfig();	
		     deviceCustomizeObj.choosenumber();
		 	 deviceCustomizeObj.name();
		 	 deviceCustomizeObj.addtocart();
		     shopcart.verifyDeviceCharges();
		     device_count=device_count+1;
		     if(devices==0){
			shopcart.add_anotherLine();
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
		     }
		     devices=devices+1;
			 }
			 device_count=1;
		}
	
	@When("^agent adds multiple devices into cart to reach to defined device limit$")
	public void add_MutltipleDevice() throws Exception
	{
	int a=0;
	 while(a<5)
	 {
	validIMEI();
	searchbutton();
	devicedetails();
	validSIMnumber();
	nextbutton();
	deviceconf.paymentplan();
	deviceconf.protectionplan();
	deviceconf.dataplan();
	 deviceconf.nextdeviceconfig();	
	 deviceCustomizeObj.choosenumber();
	 deviceCustomizeObj.name();
	 deviceCustomizeObj.addtocart();
	shopcart.verifyDeviceCharges();
	device_count=device_count+1;
	 System.out.println(a);
	 if(a<=3){
	shopcart.add_anotherLine();
	if(isElementDisplayed(custPage.run_creditCheck,5))
	{
clickElement(custPage.run_creditCheck);
if(isElementDisplayed(custPage.approved_check,5))
{
	clickElement(custPage.close);
}
	}
	 }
	a=a+1;
	 }
	 device_count=1;
	}
	
	@When("^agent adds multiple devices into cart to reach to defined device limit through verify$")
	public void add_MutltipleDevice_verify() throws Exception
	{
		int devices=0;
		 clickVerify();
		 redirectToDevicBrand();
			 while(devices<5)
			 {
		     deviceBrand.selectDeviceBrand();
		     deviceBrand.redirectedToBrowseDevice();
		     browsedevice.selectDevice_Verify();
		     browsedevice.selectStorage_Verify();
		     browsedevice.selectColor_Verify();
		     browsedevice.verifyTotalAmount();
		     browsedevice.clickSelect();
		     deviceconf.paymentplan();
		     deviceconf.protectionplan();
		     deviceconf.dataplan();
			 deviceconf.nextdeviceconfig();	
			 deviceCustomizeObj.choosenumber();
			 deviceCustomizeObj.name();
			 deviceCustomizeObj.addtocart();
		     shopcart.verifyDeviceCharges();
		     device_count=device_count+1;
		     if(devices<=4){
			shopcart.add_anotherLine();
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
		     }
		     devices=devices+1;
			 }
			   device_count=1;
		}
	@And("^agent adds hybrid devices and accessory into cart through verify$")
	public void add_hybridDevice_accessory_Verify() throws Exception
	{
	 int devices=0;
	 clickVerify();
	 redirectToDevicBrand();
		 while(devices<2)
		 {
	     deviceBrand.selectDeviceBrand();
	     deviceBrand.redirectedToBrowseDevice();
	     browsedevice.selectDevice_Verify();
	     browsedevice.selectStorage_Verify();
	     browsedevice.selectColor_Verify();
	     browsedevice.verifyTotalAmount();
	     browsedevice.clickSelect();
	     deviceconf.paymentplan();
	     deviceconf.protectionplan();
	     deviceconf.dataplan();
	     deviceconf.nextdeviceconfig();	
		 deviceCustomizeObj.choosenumber();
		 deviceCustomizeObj.name();
		 deviceCustomizeObj.addtocart();
	     shopcart.verifyDeviceCharges();
	     device_count=device_count+1;
	     if(devices==0){
		shopcart.add_anotherLine();
		if(isElementDisplayed(custPage.run_creditCheck,5))
		{
	clickElement(custPage.run_creditCheck);
	if(isElementDisplayed(custPage.approved_check,5))
	{
		clickElement(custPage.close);
	}
		}
	     }
	     devices=devices+1;
		 }
		 device_count=1;
		 shopcart.add_Accessory();
		 deviceBrand.redirectedToBrowseAccessories();
		 browseAccessory.selectAccessory();
		 browseAccessory.colorAccessory();
		 browsedevice.verifyTotalAmount();
		 browsedevice.clickSelect();
		 
	}
	@And("^agent adds hybrid devices and multiple accessories into cart through verify$")
	public void add_hybridDevice_Multi_accessory_Verify() throws Exception
	{
	 int devices=0;
	 int accesory=0;
	 clickVerify();
	 redirectToDevicBrand();
		 while(devices<2)
		 {
	     deviceBrand.selectDeviceBrand();
	     deviceBrand.redirectedToBrowseDevice();
	     browsedevice.selectDevice_Verify();
	     browsedevice.selectStorage_Verify();
	     browsedevice.selectColor_Verify();
	     browsedevice.verifyTotalAmount();
	     browsedevice.clickSelect();
	     deviceconf.paymentplan();
	     deviceconf.protectionplan();
	     deviceconf.dataplan();
	     deviceconf.nextdeviceconfig();	
		 deviceCustomizeObj.choosenumber();
		 deviceCustomizeObj.name();
		 deviceCustomizeObj.addtocart();
	     shopcart.verifyDeviceCharges();
	     device_count=device_count+1;
	     if(devices==0){
		shopcart.add_anotherLine();
		if(isElementDisplayed(custPage.run_creditCheck,5))
		{
	clickElement(custPage.run_creditCheck);
	if(isElementDisplayed(custPage.approved_check,5))
	{
		clickElement(custPage.close);
	}
		}
	     }
	     devices=devices+1;
		 }
		 device_count=1;
		 while(accesory<3)
		 {
		 shopcart.add_Accessory();
		 deviceBrand.redirectedToBrowseAccessories();
		 browseAccessory.selectAccessory();
		 browseAccessory.colorAccessory();
		 browsedevice.verifyTotalAmount();
		 browsedevice.clickSelect();
		 accesory=accesory+1;
	     device_count=device_count+1;
		 }
		
		 device_count=1;
	}
	@When("^agent adds multiple devices into cart and run creditcheck$")
	public void add_MutltipleDevice_credit_verify() throws Exception
	{
		int devices=0;
		 clickVerify();
		 redirectToDevicBrand();
			 while(devices<3)
			 {
		     deviceBrand.selectDeviceBrand();
		     deviceBrand.redirectedToBrowseDevice();
		     browsedevice.selectDevice_Verify();
		     browsedevice.selectStorage_Verify();
		     browsedevice.selectColor_Verify();
		     browsedevice.verifyTotalAmount();
		     browsedevice.clickSelect();
		     deviceconf.paymentplan();
		     deviceconf.protectionplan();
		     deviceconf.dataplan();
			 deviceconf.nextdeviceconfig();	
			 deviceCustomizeObj.choosenumber();
			 deviceCustomizeObj.name();
			 deviceCustomizeObj.addtocart();
		     shopcart.verifyDeviceCharges();
		     device_count=device_count+1;
		     if(devices<=2){
			shopcart.add_anotherLine();
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
		     }
		     devices=devices+1;
			 }
			   device_count=1;
		}
	@When("^agent adds multiple devices into cart with scan and run creditcheck$")
	public void add_MutltipleDevice_scan() throws Exception
	{
	int a=0;
	 while(a<2)
	 {
	validIMEI();
	searchbutton();
	devicedetails();
	validSIMnumber();
	nextbutton();
	deviceconf.paymentplan();
	deviceconf.protectionplan();
	deviceconf.dataplan();
	 deviceconf.nextdeviceconfig();	
	 deviceCustomizeObj.choosenumber();
	 deviceCustomizeObj.name();
	 deviceCustomizeObj.addtocart();
	shopcart.verifyDeviceCharges();
	device_count=device_count+1;
	 System.out.println(a);
	 if(a<=1){
	shopcart.add_anotherLine();
	if(isElementDisplayed(custPage.run_creditCheck,5))
	{
clickElement(custPage.run_creditCheck);
if(isElementDisplayed(custPage.approved_check,5))
{
	clickElement(custPage.close);
}
	}
	 }
	a=a+1;
	 }
	 device_count=1;
	}
	
	@Given("^agent navigates to 'verify' link to shop for accessory$")
	public void verifylinkforaccessory() throws Exception{
		try{
		accountlookup.enterValidAcctNumber();
		accountlookup.clickOnLookUp();
		accountlookup.acctDetailsPageLaunch();
		acctDetailsObj.launchMobile();	
		if(isElementDisplayed(CustomerInfoPage.dobField,10))
		{
		custMoreInfoObj.enterValidDOB();
		}
		
		custMoreInfoObj.enterValidSSN();
		if(isElementDisplayed(CustomerInfoPage.deviceSection,10))
		{
		custMoreInfoObj.selectValidLines();
		}
		//custMoreInfoObj.clickSubmit();
		clickVerify();
		if(isElementDisplayed(DeviceBrandPage.PhoneByBrand,10))
		{
			if(isElementDisplayed(DeviceBrandPage.ViewCatalog,10))
			{
				deviceBrand.viewCatalog();
			}
		}
		//redirectToDevicBrand();
		
		//
		else
			//else(isElementDisplayed(BrowseAccessoryPage.accessoryButton,10))
		{
		browseAccessory.accessoryButton();
		}
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}

	@When("^agent chooses multiple accessories$")
	public void multipleAccessories() throws Exception {
		deviceBrand.redirectedToBrowseAccessories();
		browseAccessory.addMultipleAccessory();
	}
	@And("^agent scans the device with invalid number$")
	public void invalidIMEI() throws Exception
	{
	try{
		
	invalidIMEInum();
	searchbutton();
	}catch(Exception e){
		e.printStackTrace();
		throw(e);
	}
	}
	@When("^I enter invalid IMEI with 15 digits$")	
	public void invalidIMEInum() throws Exception {
		try {
			Thread.sleep(5000);
			clickElement(DeviceSearchPage.IMEInum);
			log.info("Clicked on IMEI");	
			System.out.println(getXMLData("IMEInumber"));
			typeValue(DeviceSearchPage.IMEInum,getXMLData("IMEInumber"));
			log.info("Entered IMEI number");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in invalidIMEI(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^agent saw the error message$")
	public void errorMessage() throws Exception {
		try {
			verifyText("Requested Resource Not Found");
			verifyText("Device does not exist");
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in invalidIMEI(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^agent adds multiple devices into cart to reach to defined device limit through Scan$")
	public void mutltipleDeviceScan() throws Exception
	{
	int a=0;
	 while(a<4)
	 {
	validIMEI();
	searchbutton();
	devicedetails();
	validSIMnumber();
	nextbutton();
	deviceconf.paymentplan();
	deviceconf.protectionplan();
	deviceconf.dataplan();
	 deviceconf.nextdeviceconfig();	
	 deviceCustomizeObj.choosenumber();
	 deviceCustomizeObj.name();
	 deviceCustomizeObj.addtocart();
	shopcart.verifyDeviceCharges();
	device_count=device_count+1;
	 System.out.println(a);
	 if(a<=3){
	shopcart.add_anotherLine();
	if(isElementDisplayed(custPage.run_creditCheck,5))
	{
clickElement(custPage.run_creditCheck);
if(isElementDisplayed(custPage.approved_check,5))
{
	clickElement(custPage.close);
}
	}
	 }
	a=a+1;
	 }
	 device_count=1;
	}
	@Given("^I lookup for a customer$")
	public void shop_Device() throws Exception
	{
		try{
			ExtentReporter.reportStep("BDD Step: Given I lookup for a customer and I shop a device", "INFO");
			accountlookup.enterValidAcctNumber();
			accountlookup.clickOnLookUp();
			accountlookup.acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
			if(isElementDisplayed(CustomerInfoPage.dobField,10))
			{
				custMoreInfoObj.enterValidDOB();	
				//custMoreInfoObj.enterValidSSN();
				custMoreInfoObj.selectValidLines();
			}
			if(isElementDisplayed(CustomerPreSignaturePage.run_creditCheck,5)){
				clickElement(CustomerPreSignaturePage.run_creditCheck);
				
			}
			clickVerify();
			redirectToDevicBrand();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
	}
	
	}
	@When("^I select a device with its customization through scan flow$")
	public void select_device_customize_scan() throws Exception
	{
		try{
			ExtentReporter.reportStep("BDD Step: When I select a device with its customization through scan flow", "INFO");
			scanDevice();
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
	}

	}
	@Given("^I am in Shopping cart Page through Verify flow$")
	public void shopCart_verify() throws Exception {
		try {
			accountlookup.enterValidAcctNumber();
			accountlookup.clickOnLookUp();
			accountlookup.acctDetailsPageLaunch();
			acctDetailsObj.launchMobile();
			if(isElementDisplayed(CustomerInfoPage.dobField,10))
			{
			custMoreInfoObj.enterValidDOB();	
			//custMoreInfoObj.enterValidSSN();
			custMoreInfoObj.selectValidLines();
			}
			if(isElementDisplayed(custPage.run_creditCheck,5))
			{
		clickElement(custPage.run_creditCheck);
		if(isElementDisplayed(custPage.approved_check,5))
		{
			clickElement(custPage.close);
		}
			}
			clickVerify();
			redirectToDevicBrand();
			deviceBrand.selectDeviceBrand();
			deviceBrand.redirectedToBrowseDevice();
			browsedevice.selectDevice_Verify();
			browsedevice.selectStorage_Verify();
			browsedevice.selectColor_Verify();
			browsedevice.verifyTotalAmount();
			browsedevice.clickSelect();
			deviceconf.paymentplan();
			deviceconf.protectionplan();
			deviceconf.dataplan();
			deviceconf.nextdeviceconfig();	
			deviceCustomizeObj.choosenumber();
			deviceCustomizeObj.name();
			deviceCustomizeObj.addtocart();
			shopcart.shopPage();
	}
		catch (Exception e) {
			log.error("GOT EXCEPTION in shopCart_verify():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
}

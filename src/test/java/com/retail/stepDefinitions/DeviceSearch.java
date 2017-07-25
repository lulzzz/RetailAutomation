package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

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
}

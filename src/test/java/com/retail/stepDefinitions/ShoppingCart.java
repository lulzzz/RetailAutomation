package com.retail.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.utils.ExtentReporter;
import com.framework.utils.LogUtils;
import com.retail.pageObjects.AccountLookUpPage;
import com.retail.pageObjects.BrowseAccessoryPage;
import com.retail.pageObjects.CustomerInfoPage;
import com.retail.pageObjects.CustomerPreSignaturePage;
import com.retail.pageObjects.DeviceConfigPage;
import com.retail.pageObjects.DeviceSearchPage;
import com.retail.pageObjects.ShoppingCartPage;

import cucumber.api.java.en.*;


public class ShoppingCart extends ShoppingCartPage{

	private static Logger log = Logger.getLogger(ShoppingCart.class);
	AccountLookUp accountlookup = new AccountLookUp();
	AccountDetails acctDetailsObj= new AccountDetails();
	CustomerInfo custMoreInfoObj= new CustomerInfo();
	//DeviceSearch deviceSearch = new DeviceSearch();
	DeviceBrand deviceBrand = new DeviceBrand();
	DeviceCustomize deviceCustomizeObj = new DeviceCustomize();
	CustomerPreSignaturePage custPage= new CustomerPreSignaturePage();
	BrowseDevice browsedevice= new BrowseDevice();
	//BrowseAccessoryPage browserAccessoryPage= new BrowseAccessoryPage();
	

	
//	@And("^I am in Shopping cart Page$")
//	public void shopping_Cart() {
//		try {
//			ExtentReporter.reportStep("BDD Step: I am in Shopping cart Page", "INFO");
//			//clickElement(ShoppingCartPage.cartImage);
//			String cartSummary = getValue(ShoppingCartPage.cartSummary);
//			verifyText(cartSummary);
//			log.info("Shopping cart page is displayed");
//		}
//		catch(Exception e) {
//			log.error("GOT EXCEPTION in shopping_Cart():" + LogUtils.logStackTrace(e));
//			e.printStackTrace();
//			throw(e);
//		}
//	}
	
	@When("^I click Print button$")
	public void printButton() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Print button", "INFO");
			clickElement(ShoppingCartPage.print);
			log.info("Clicked on print button");
		}
		catch(Exception e) {
			log.error("GOT EXCEPTION in printButton():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I see the print details page$")
	public void printDetails() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the print details page", "INFO");
			
			if(isElementDisplayed(ShoppingCartPage.pages,5))
			{
				ExtentReporter.reportStep(getDriver(), "Print Details Page is displayed", "PASS",  1);
				log.info("Print Details Page is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Print Details Page is not displayed", "FAIL",  0);
				log.info("Print Details Page is not displayed");
			}
		}
		catch(Exception e) {
			log.error("GOT EXCEPTION in printButton():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	
		

	@When("^I click Cart Icon to see Shopping Cart Page$")
	public void cartIcon() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Cart Icon", "INFO");
			clickElement(ShoppingCartPage.cartImage);
			log.info("I click Cart Icon");
			String incompleteLines = getValue(ShoppingCartPage.incompleteLines);
			verifyText(incompleteLines);
			log.info("Shopping cart page is displayed");
		}
		catch(Exception e) {
			log.error("GOT EXCEPTION in cartIcon():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@Then("^I see the Shopping Cart Page$")
	public void shopPage() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Shopping Cart Page", "INFO");
//			String cartSummary = getValue(ShoppingCartPage.cartSummary);
//			verifyText(cartSummary);
			if(isElementDisplayed(ShoppingCartPage.custOrder_Cart,5))
			{
				ExtentReporter.reportStep(getDriver(), "Shopping Cart Page is displayed", "PASS",  1);
				log.info("Shopping Cart Page is displayed");
				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Shopping Cart Page is not displayed", "FAIL",  0);
				log.info("Shopping Cart Page is not displayed");
				
			}
						
		}
		catch(Exception e) {
			log.error("GOT EXCEPTION in shopPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@Then("^I see the Customer Order Review in Shopping Cart Page$")
	public void custOrder_Cart() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the Shopping Cart Page", "INFO");
//			String cartSummary = getValue(ShoppingCartPage.cartSummary);
//			verifyText(cartSummary);
			if(isElementDisplayed(ShoppingCartPage.custOrder_Cart,5))
			{
				ExtentReporter.reportStep(getDriver(), "Customer Order Review in Shopping Cart Page is displayed", "PASS",  1);
				log.info("Customer Order Review in Shopping Cart Page is displayed");
				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Customer Order Review in Shopping Cart Page is not displayed", "FAIL",  0);
				log.info("Customer Order Review in Shopping Cart Page is not displayed");
				
			}
						
		}
		catch(Exception e) {
			log.error("GOT EXCEPTION in custOrder_Cart():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@When("^I click Done button$")
	public void doneButton() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Done button", "INFO");
			clickElement(ShoppingCartPage.done);
			log.info("Clicked on Done Button");
			
		}catch (Exception e) {
			
			log.error("GOT EXCEPTION in doneButton():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
			
			
			
			
		
	
	@When("^I select Delete Line$")
	public void deleteLine() {
		try {
			ExtentReporter.reportStep("BDD Step: I select Delete Line", "INFO");
			clickElement(ShoppingCartPage.deleteLine);
			log.info("Clicked on Delete Line");
			
		}catch (Exception e) {
			
			log.error("GOT EXCEPTION in deleteLine():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I select Add a Line$")
	public void add_Line() {
		try {
			ExtentReporter.reportStep("BDD Step: I select Add a Line", "INFO");
			clickElement(ShoppingCartPage.add_Line);
			log.info("Clicked on Add a Line Button");
			
		}catch (Exception e) {
			
			log.error("GOT EXCEPTION in add_Line():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
			
			
	@When("^I click Back Arrow$")
	public void backArrow() {
		try {
			ExtentReporter.reportStep("BDD Step: I click Back Arrow", "INFO");
			clickElement(ShoppingCartPage.backArrow);
			log.info("Clicked on Back Arrow");
		}
		catch (Exception e) {
			
			log.error("GOT EXCEPTION in backArrow():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see the cart text$")
	public void cartText() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the cart text", "INFO");
			String cartText=getValue(ShoppingCartPage.cartText);
			verifyText(cartText);			
		}
		catch (Exception e) {
			
			log.error("GOT EXCEPTION in cartText():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I select cancel button$")
	public void cancel() {
		try {
		ExtentReporter.reportStep("BDD Step: I select cancel button", "INFO");
				clickElement(ShoppingCartPage.cancel);
				log.info("Clicked on Cancel Button");
				
			}catch (Exception e) {
				
				log.error("GOT EXCEPTION in cancel():" + LogUtils.logStackTrace(e));
				e.printStackTrace();
			}
		}
	@Then("^I see a pop message asking for a reason$")
	public void reasonCancel() {
		try {
			ExtentReporter.reportStep("BDD Step: I see a pop message asking for a reason", "INFO");
			String cancelSale=getValue(ShoppingCartPage.cancelSale);	
			verifyText(cancelSale);
			log.info("Cancel Reason Page is displayed");
			String reason= getXMLData("reason");
			ShoppingCartPage.selectReason(reason);
			log.info("Cancellation reason was selected");			
		}
		catch (Exception e) {
			
			log.error("GOT EXCEPTION in reasonCancel():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@When("^I select Continue Customization$")
	public void continueCustom() {
		try {
			ExtentReporter.reportStep("BDD Step: I select Continue Customization", "INFO");
			clickElement(ShoppingCartPage.continueCustom);
			log.info("Clicked on Continue Customization");
			
		}catch (Exception e) {
			
			log.error("GOT EXCEPTION in continueCustom():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	//CheckOut for a customer
	@When("^I select Continue to Checkout Button$")	
	public  void continueToCheckout() throws Exception  {
		try {
			ExtentReporter.reportStep("BDD Step: When I select Continue to Checkout Button", "INFO");
			clickElement(ShoppingCartPage.continueToCheckout);			
			log.info("Clicked on Continue to Checkout");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in continueToCheckout(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
	@Then("^I see the CustomerPreSignature Page$")
	public void custPresign() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see the CustomerPreSignature Page", "INFO");
			if(isElementDisplayed(CustomerPreSignaturePage.billingAddressText,5))
			{
				ExtentReporter.reportStep(getDriver(), "CustomerPresignature Page is displayed", "PASS",  1);
				log.info("CustomerPresignature Page is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "CustomerPresignature Page is not displayed", "FAIL",  1);
				log.info("CustomerPresignature Page is not displayed");				
			}
			
						
					
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in custPresign(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
	@When("^I click Edit cart at top of the cart summary$")
	public void editCartTop() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Edit cart at top of the cart summary", "INFO");
			clickElement(ShoppingCartPage.topEditCart);			
			log.info("Clicked on Edit Cart at top of Cart Summary");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in editCartTop(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
			
	@Then("^I see Edit order Page$")
	public void editOrderPage() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see Edit order Page", "INFO");
			if(isElementDisplayed(ShoppingCartPage.editOrderText,5))
			{
				ExtentReporter.reportStep(getDriver(), "Edit Order Page is displayed", "PASS",  1);
				log.info("Edit Order Page is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Edit Order Page is not displayed", "FAIL",  0);
				log.info("Edit Order Page is not displayed");
			}
		}
			catch (Exception e) {
				log.error("GOT EXCEPTION in editOrderPage(): " + LogUtils.logStackTrace(e));
				e.printStackTrace();
				throw(e);
			}				
			
	}
	
	
	
	
	@When("^I click Payment Details button$")
	public void payment_button() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Payment Details button", "INFO");
			clickElement(ShoppingCartPage.paymentDetails);			
			log.info("Clicked on Payment Details button");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in payment_button(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}  
	}
	@When("^I click Line Details button$")
	public void line_button() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Line Details button", "INFO");
			clickElement(ShoppingCartPage.lineDetails);			
			log.info("Clicked on Line Details button");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in line_button(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}  
	}
	
	
	@Then("^I see the line details in Device Customize Page$")
	public void lineDetails() {
		try {
			ExtentReporter.reportStep("BDD Step: Then I see the line details in Device Customize Page", "INFO");
			String deviceName= getXMLData("DeviceName");
			System.out.println(deviceName);
			String UIdeviceName = getValue(DeviceCustomize.deviceName);
			System.out.println(UIdeviceName);
			boolean deviceNameDetails = UIdeviceName.contains(deviceName);
			System.out.println(deviceNameDetails);
			if(deviceNameDetails == true)			
			{
				ExtentReporter.reportStep(getDriver(), "Device Name is displayed", "PASS",  1);
				log.info("Device Name is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Device Name is not displayed", "FAIL",  0);
				log.info("Device Name is not displayed");				
			}
			String deviceColor= getXMLData("DeviceColor_Storage");
			System.out.println(deviceColor);
			String UIdeviceColor = getValue(DeviceCustomize.deviceColor);
			System.out.println(UIdeviceColor);
			boolean comparedeviceColor = UIdeviceColor.equals(deviceColor);
			System.out.println(comparedeviceColor);
			if(comparedeviceColor == true)			
			{
				ExtentReporter.reportStep(getDriver(), "Device Color and Storage is displayed", "PASS",  1);
				log.info("Device Color and Storage is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Device Color and Storage is not displayed", "FAIL",  0);
				log.info("Device Color and Storage is not displayed");				
			}
			String IMEInumber= getXMLData("IMEInumber");
			System.out.println(IMEInumber);
			String UI_IMEInumber = getValue(DeviceCustomize.deviceIMEI);
			System.out.println(UI_IMEInumber);
			boolean compareIMEInumber = UI_IMEInumber.contains(IMEInumber);
			System.out.println(compareIMEInumber);
			if(compareIMEInumber == true)			
			{
				ExtentReporter.reportStep(getDriver(), "IMEI number is displayed", "PASS",  1);
				log.info("IMEI number is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "IMEI number is not displayed", "FAIL",  0);
				log.info("IMEI number is not displayed");				
			}
			
			String PaymentPlan= getXMLData("PaymentPlan");
			System.out.println(PaymentPlan);
			String UI_PaymentPlan = getValue(DeviceCustomize.paymentplan);
			System.out.println(UI_PaymentPlan);
			boolean comparePaymentPlan = UI_PaymentPlan.equals(PaymentPlan);
			System.out.println(comparePaymentPlan);
			if(comparePaymentPlan == true)			
			{
				ExtentReporter.reportStep(getDriver(), "Payment Plan is displayed", "PASS",  1);
				log.info("Payment Plan is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Payment Plan is not displayed", "FAIL",  0);
				log.info("Payment Plan is not displayed");				
			}
			
			String DataOption= getXMLData("DataOption");
			System.out.println(DataOption);
			String UI_DataOption = getValue(DeviceCustomize.dataOption);
			System.out.println(UI_DataOption);
			boolean compareDataOption = UI_DataOption.equals(DataOption);
			System.out.println(compareDataOption);
			if(compareDataOption == true)			
			{
				ExtentReporter.reportStep(getDriver(), "Data Option is displayed", "PASS",  1);
				log.info("Data Option is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Data Option is not displayed", "FAIL",  0);
				log.info("Data Option is not displayed");				
			}
			
			String DeviceProtection= getXMLData("DeviceProtection");
			System.out.println(DeviceProtection);
			String UI_DeviceProtection = getValue(DeviceCustomize.deviceProtect);
			System.out.println(UI_DeviceProtection);
			boolean compareDeviceProtection = UI_DeviceProtection.equals(DeviceProtection);
			System.out.println(compareDeviceProtection);
			if(compareDeviceProtection == true)			
			{
				ExtentReporter.reportStep(getDriver(), "Device Protection is displayed", "PASS",  1);
				log.info("Device Protection is displayed");				
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Device Protection is not displayed", "FAIL",  0);
				log.info("Device Protection is not displayed");				
			}
		}
			
		
		catch (Exception e) {
			log.error("GOT EXCEPTION in lineDetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
			
			
			
			
			
	@Then("^I see the payment details in Device Config Page$")
	public void paymentDetails() {
		try {
			ExtentReporter.reportStep("BDD Step: I see the payment details in Device Config Page", "INFO");
			if((isElementDisplayed(DeviceConfigPage.estimatedMonthly,5)) && (isElementDisplayed(DeviceConfigPage.oneTimeCharge,5)))
				{
				ExtentReporter.reportStep(getDriver(), "Estimated Monthly and OneTime Charge text is displayed", "PASS",  1);				
				log.info("Estimated Monthly and OneTime Charge text is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Estimated Monthly and OneTime Charge text is not displayed", "FAIL",  0);				
				log.info("Estimated Monthly and OneTime Charge text is not displayed");
			}
			String estimatedCost = getValue(DeviceConfigPage.estimated_cost);
			String oneTimeCost = getValue(DeviceConfigPage.oneTimeCost);
			if((!estimatedCost.isEmpty()) && (!oneTimeCost.isEmpty()))
			{
				ExtentReporter.reportStep(getDriver(), "Estimated Monthly Cost and OneTime Charge Cost is displayed", "PASS",  1);				
				log.info("Estimated Monthly Cost and OneTime Charge Cost is displayed");
			}
			else
			{
				ExtentReporter.reportStep(getDriver(), "Estimated Monthly Cost and OneTime Charge Cost is not displayed", "FAIL",  0);				
				log.info("Estimated Monthly Cost and OneTime Charge Cost is not displayed");
			}
			
				
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in paymentDetails(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
			
		
	@When("^I click Edit cart at bottom of the cart summary$")
	public void editCartBottom() {
		try {
			ExtentReporter.reportStep("BDD Step: When I click Edit cart at bottom of the cart summary", "INFO");
			clickElement(ShoppingCartPage.bottomEditCart);			
			log.info("Clicked on Edit Cart at bottom of Cart Summary");		
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in editCartBottom(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
			
	
	
			
	
	@Then("^I verify the device charges$")
	public  void verifyDeviceCharges() throws Exception {
		try {				
			Thread.sleep(5000);			
			String charges_ShoppingCart=getValue(ShoppingCartPage.estimatedMonthlycost_shoppingcart);
	        verifyText(charges_ShoppingCart);
	        String charges_oneTimeCharge=getValue(ShoppingCartPage.oneTimeCharge_shoppingcart);
	        verifyText(charges_oneTimeCharge);
			log.info("verify Estimated monthly cost");			
			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}	
	
	@Then("^agent does successful checkout$")
	public void successfulcheckout() throws Exception {
		try {			
			continueToCheckout();			
		}catch (Exception e) {
			log.error("GOT EXCEPTION in successfulcheckout(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	@When("^I select Add another line$")
	public  void add_anotherLine()  {
		try {
	       ExtentReporter.reportStep("BDD Step: When I select Add another line", "INFO");
			clickElement(ShoppingCartPage.add_AnotherLine);
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "PASS", 1);
			
		}catch (Exception e) {
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "Fail", 1);
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@Then("^I see page is navigated to device brand page$")
	public void deviceBrand() {
		try {
			ExtentReporter.reportStep("BDD Step: I see page is navigated to device brand page", "INFO");
			String PhoneByBrand=getValue(DeviceBrand.PhoneByBrand);
	        verifyText(PhoneByBrand);
	        String ViewCatalog=getValue(DeviceBrand.ViewCatalog);
	        verifyText(ViewCatalog);
	        log.info("Device Brand Page is displayed");
	     }
		
		catch (Exception e) {
			log.error("GOT EXCEPTION in deviceBrand():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	
	@When("^I select Add Accessory$")
	public  void add_Accessory()  {
		try {
	       ExtentReporter.reportStep("BDD Step: When I select Add Accessory", "INFO");
			clickElement(ShoppingCartPage.add_Accessory);
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "PASS", 1);
			
		}catch (Exception e) {
			ExtentReporter.reportStep(getDriver(), "Shopping_Page", "Fail", 1);
			log.error("GOT EXCEPTION in Shopping_cartPage():" + LogUtils.logStackTrace(e));
			e.printStackTrace();
		}
	}
	@Then("^I see the Browse Accessories Page$")
	public void browseAccessories() throws Exception {
		try {
			verifyText("Accessories");
			log.info("Navigated to Accessories Page");		
		}
		catch (Exception e) {
			log.error("GOT EXCEPTION in Shopping_cartPage(): " + LogUtils.logStackTrace(e));
			e.printStackTrace();
			throw(e);
		}
	}
	
}

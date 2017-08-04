package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class AccountDevicesPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
		scanDevice = By.xpath("//button[text()='Scan Device']"),
		addDevice = By.xpath("//button[text()='Add Device Manually']"),
		closeaddDev = By.xpath("//md-dialog[@class='remove-device _md md-transition-in']//*[text()=' clear ']"),
		canceladdDev = By.xpath("//md-dialog[@class='remove-device _md md-transition-in']//*[text()='Cancel']"),
		warningYes = By.xpath("//md-dialog[@aria-label='Warning']//*[text()='Yes']"),
		warningNo = By.xpath("//md-dialog[@aria-label='Warning']//*[text()='No']"),
		closeWarning = By.xpath("//md-dialog[@aria-label='Warning']//*[text()=' clear ']"),
		deviceNumber = By.xpath("//INPUT[@id='input_17']"),
		nextaddDev = By.xpath("//md-dialog[@class='remove-device _md md-transition-in']//button[text()='Next']"),
		errorOk = By.xpath("//*[@aria-label='Error']//button[text()='OK']"),
		errorClose = By.xpath("//*[@aria-label='Error']//*[text()=' clear ']"),
				backButton = By.xpath("//span[text()='Back']"),
			manageDevices = By.xpath("//h3[text()='Manage Devices']"),
		deviceDetailsClose = By.xpath("//*[@aria-label='Add Device']//*[text()=' clear ']"),
		deviceDetailsCancel = By.xpath("//*[@aria-label='Add Device']//*[text()='Cancel']");
}

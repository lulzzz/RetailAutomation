package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class DeviceCustomizePage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	
	keep_number = By.xpath("/html/body/my-app/main/my-device-options/div/div[2]/div[1]/div/my-device-customize-pane/div/my-radio-btn/form/div/div[1]/label"),
	get_new_num = By.xpath("/html/body/my-app/main/my-device-options/div/div[2]/div[1]/div/my-device-customize-pane/div/my-radio-btn/form/div/div[2]/label"),
	current_phone_number = By.xpath("/html/body/my-app/main/my-device-options/div/div[2]/div[1]/div/my-device-customize-pane/div/form/div/div[1]/my-input/label/input"),
	current_carrier = By.xpath("//*[@id='dropdown']"),
	name = By.xpath("/html/body/my-app/main/my-device-options/div/div[2]/div[1]/div/my-device-customize-pane/div/div[2]/div/my-input/label/input"),
	add_to_cart = By.xpath("/html/body/my-app/main/my-device-options/div/div[2]/div[3]/div/my-btn[2]/button");
	
	
}

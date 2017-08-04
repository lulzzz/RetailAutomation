package com.retail.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.security.UserAndPassword;

import com.framework.wrapper.WebOperations;

import cucumber.api.java.en.Given;

public class GlobalSteps extends WebOperations{
	private static Logger log = Logger.getLogger(DeviceSearch.class);
	
	@Given("^I launch the Retail application as an agent$")
	public void i_launch_the_retail_url() throws Exception{	
		try{
		WebOperations.launchApp(getUrl(getEnvironment())); 
		WebOperations.verifyText("Look Up Customer");
		
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}	
	
	public void capture_session() throws Exception{	
		try{
			wait(40);
			String session = "session=";
			String url=getDriver().getCurrentUrl();
			System.out.println(url);
			int session_index=url.indexOf(session);
			int variable_index = session_index + session.length();
			int mat_index = url.indexOf("&msat");
			log.info("Session ID is "+url.substring(variable_index, mat_index));
		
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
}

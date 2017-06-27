package com.retail.stepDefinitions;

import com.framework.wrapper.WebOperations;

import cucumber.api.java.en.Given;

public class GlobalSteps extends WebOperations{
	
	@Given("^I launch the Retail application as an agent$")
	public void i_launch_the_retail_url(){		
		WebOperations.launchApp(getUrl(getEnvironment()));
		WebOperations.verifyText("Look Up Customer");
	}
}

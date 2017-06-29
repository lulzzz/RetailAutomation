Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Clicking Select button for a device redirects to Device_Config page
	Given I am in Device Catalog page
	Then Click on any Device in catalog
	And Select Color 
	And Select Storage
	Then Click on Select
	And it redirects to Device_Config page

    
    
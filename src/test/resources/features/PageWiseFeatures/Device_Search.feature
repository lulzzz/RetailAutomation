@deviceSearch
Feature: Device_Search

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent
@RTD-1417
Scenario: Clicking BYOD displays settings details
	Given I am in Device Search Page
	When I click on BYOD
	Then I see the settings details

@RTD-1418	
Scenario: Unchecking BYOD not display settings details
	Given I am in Device Search Page
	When I click on BYOD
	Then I see the settings details
	When I uncheck BYOD
	Then I see the Shipping Address details
@RTD-1410
Scenario: Search button not enabled when IMEI not entered 
	Given I am in Device Search Page
	When I enter invalid IMEI with less than 15 digits 
	Then Search button should not be enabled

@RTD-1411
Scenario: Search button visible only after the limited digits entered
	Given I am in Device Search Page
    When I enter valid IMEI with 15 digits
	And I click on Search button	
	Then I should see a Popup with Device details
	
@RTD-1413
Scenario: Verify if shipping address is visible
	Given I am in Device Search Page
	Then I must see the Shipping address displayed

@RTD-1414
Scenario: Clicking Verify Button
	Given I am in Device Search Page
	When I click on Verify Button
	Then I should get redirected to Device_Brands page
@RTD-1415
Scenario: Verify Device details displayed - Phone name,color,imei
	Given I am in Device Search Page
	When I enter valid IMEI with 15 digits
	And I click on Search button
	Then I should see a Popup with Device details
	And I see the Phone name,color and IMEI
@RTD-1416	
Scenario: Entering invalid SIM number 
	Given I am in Device Search Page   
	When I enter IMEI with more than 15 digits
	And I click on Search button
	Then I should see a Popup with Device details
	When I enter invalid SIM number
	Then Next button should not be enabled
@RTD-1417
Scenario: Clicking BYOD displays settings details
	Given I am in Device Search Page
	When I click on BYOD
	Then I see the settings details

@RTD-1418	
Scenario: Unchecking BYOD not display settings details
	Given I am in Device Search Page
	When I click on BYOD
	Then I see the settings details
	When I uncheck BYOD
	Then I see the Shipping Address details
	
@RTD-1421
Scenario: Clicking on Cancel button	
	Given I am in Device Search Page   
	When I enter valid IMEI with 15 digits 
	And I click on Search button
	Then I should see a Popup with Device details
	When I click on cancel button
	Then I see the Device Search Page
	
@RTD-1422
Scenario: Clicking on Close Button
	Given I am in Device Search Page   
	When I enter valid IMEI with 15 digits 
	And I click on Search button
	Then I should see a Popup with Device details
	When I click on close button
	Then I see the Device Search Page
	
@RTD-1420
Scenario: Clicking on Next button
	Given I am in Device Search Page   
	When I enter valid IMEI with 15 digits 
	And I click on Search button
	Then I should see a Popup with Device details
	When I enter valid SIM number with 20 digits
	And I click on Next button 
	Then I see the Device Config Page

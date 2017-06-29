Feature: Device_Search

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Search button visible only after the limited digits entered
	Given I have logged in as an authenticated user   
	And I am in Device Search Page
    When I enter valid IMEI with 15 digits
	Then I click on Search button 
	
Scenario: Entering Valid SIM number
	Given I have logged in as an authenticated user   
	And I am in Device Search Page
	When I enter valid IMEI with 15 digits
	And I click on Search button
	Then I should see a Popup with Device details
	When I enter valid SIM number with 20 digits
	Then I click on Next button
	
Scenario: Clicking Verify Button
    Given I have logged in as an authenticated user   
    And I am in Device Search Page
    When I click on Verify Button
    Then I should get redirected to Device_Brands page
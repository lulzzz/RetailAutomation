Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent


Scenario: Verify if a device is selected, it redirects to Browse_Devices page
	Given I have logged in as an authenticated user    
    And I am in Device_Brands page
    When I select a device
    Then I am redirected to Browse_Devices page
    And I see details of the device displayed
    
    
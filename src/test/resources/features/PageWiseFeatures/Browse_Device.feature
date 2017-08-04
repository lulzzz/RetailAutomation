Feature: Browse_Device

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Choose a particular device in catalog
	Given I am in Device Catalog page
    Then Click on any Device in catalog
    And Select Color 
    And Select Storage
    Then Click on Select
	
Scenario: Verify if total amount is displayed for the selected device
	Given I am in Device Catalog page
    Then Click on any Device in catalog
    And Select Color 
    And Select Storage
    Then Verify total amount
    
Scenario: Clicking Select button for a device redirects to Device_Config page
   Given I am in Device Catalog page
   Then Click on any Device in catalog
   And Select Color 
   And Select Storage
   Then Click on Select
   And it redirects to Device_Config page

Scenario: Verify if Accessory is selected, it redirects to Browse_Accessories page
   Given I am in Device Catalog page
   And Click on Accessory in catalog page
   Then it redirects to Browse_Accessories page
	

    
    
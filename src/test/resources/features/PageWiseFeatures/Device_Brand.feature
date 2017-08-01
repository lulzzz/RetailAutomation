Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@RTD-1437
Scenario: Verify if a device is selected, it redirects to Browse_Devices page
	Given I lookup for a customer     
    And I am in Device_Brands page
    When I select a device brand
    Then I am redirected to Browse_Devices page
    
 Scenario: Verify Search bar with search Icon
	Given I lookup for a customer     
    And I am in Device_Brands page
    Then I see a Search bar
    And I see a search icon to the right
       
   Scenario: Verify Phones by brand and Accessories by category is visible
 	Given I lookup for a customer    
    And I am in Device_Brands page
   Then I see tabs- Phones by Brand and Accessory 
    
    
    
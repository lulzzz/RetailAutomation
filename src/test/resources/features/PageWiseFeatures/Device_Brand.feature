Feature: Device_Brand

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@RTD-1437
Scenario: Verify if a device is selected, it redirects to Browse_Devices page
	Given I lookup for a customer     
    And I am in Device_Brands page
    When I select a device brand
    Then I am redirected to Browse_Devices page
        
   Scenario: Verify Phones by brand and Accessories by category is visible
 	Given I lookup for a customer    
    And I am in Device_Brands page
   Then I see tabs- Phones by Brand and Accessory 
   
   @123-----
   @08/031
 Scenario: Validate View catalog link for Phones by brand
   	Given I lookup for a customer    
    And I am in Device_Brands page
   Then I see tabs- Phones by Brand and Accessory 
   When I click on View catalog link for Phones by Brand
   Then I am redirected to Browse_Devices page
   
   @08/03
    Scenario: Validate View catalog link for Accessories by Category
   	Given I lookup for a customer    
    And I am in Device_Brands page
    Then I see tabs- Phones by Brand and Accessory 
When I click on View catalog link for Accessories by Category
Then I am redirected to Browse_Accessories page
    
    @08/03
 Scenario: Verify if Accessory is not visible  until a device is added to cart
   	Given I lookup for a customer    
    And I am in Device_Brands page
    When I do not select any device
    Then I do not see any accessory 
    And I am not able to select any accessory
    
    @08/0311
 Scenario: Verify if Accessory is visible when a device is added to cart  
    Given I lookup for a customer    
    And I am in Device_Brands page
    When I select a device
    And add device to cart
    Then I see the Accessory is displayed

@08/0311
Scenario: Verify if a accessory is selected,it redirects to Browse_Accessories
Given I lookup for a customer    
And I am in Device_Brands page
When I select an Accessory brand
Then I am redirected to Browse_Accessories page

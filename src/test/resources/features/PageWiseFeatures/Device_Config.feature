@deviceConfig
Feature: Device_Config

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@RTD-1407
Scenario: Choose Payment plan
	Given I lookup for a customer 
	When I select a device with its customization
 	Then I see the configuration details of the selected device
	When I choose a payment plan, Full or Monthly
	And I must see the cost for the plan displayed
	Then I see the selected option highlighted

@RTD-1408
Scenario: Choose Device protection Plan
	Given I lookup for a customer 
	When I select a device with its customization
 	Then I see the configuration details of the selected device
	When I choose to have device protection or not
	Then I see the selected option highlighted

@RTD-1409	
Scenario: Choose Data option
	Given I lookup for a customer 
	When I select a device with its customization
 	Then I see the configuration details of the selected device
	When I choose the data plan, By the Gig or Unlimited
	Then I see the selected option highlighted

@RTD-1424
Scenario: Clicking on Next button
    Given I lookup for a customer  
    When I select a device with its customization
    Then I select plans for payment,device protection and data
 	Then I see the configuration details of the selected device
	When I click on Next button in DeviceConfig
	Then I should be redirected to next page-Device_Customize
@RTD-1427	
Scenario: Clicking on Cancel button
	Given I lookup for a customer  
    When I select a device with its customization
    Then I select plans for payment,device protection and data
 	Then I see the configuration details of the selected device
    When I click on Cancel button
    Then I see a popup,asking the reason for cancellation

@RTD-1429
Scenario: Clicking Learn more in protection plan	
Given I lookup for a customer  
When I select a device with its customization
Then I see the configuration details of the selected device
When I click on Learn more link
Then I see a popup for XFINITY Mobile Protection Plan appears

@RTD-1428
Scenario: Verify in Learn More Popup-Remove Protection plan appears when I choose XMPP
	Given I lookup for a customer  
    When I select a device with its customization
    Then I select plans for payment,device protection and data
 	Then I see the configuration details of the selected device
    And I click on Learn more link
    Then popup should have Remove Protection plan button
  
@RTD-1430  
Scenario: Verify in Learn More Popup-Add Protection plan appears when I don't choose XMPP
	Given I lookup for a customer  
    When I select a device with its customization
    Then I see the configuration details of the selected device
    And I click on Learn more link
    Then popup should have Add Protection plan button

@RTD-1431
Scenario: Click and verify the links- FAQ,Terms and conditions
     Given I lookup for a customer  
     When I select a device with its customization
     Then I see the configuration details of the selected device
     And I click on Learn more link
     When I click the link FAQ and Terms and condition
     Then I should be redirected to their pages
  @RTD-1432   
Scenario: Validating Don't cancel button in the popup
     Given I lookup for a customer  
     When I select a device with its customization
     Then I see the configuration details of the selected device
     When I click on  Cancel button
     Then I see a popup,asking the reason for cancellation
     And I see a dropdown listing different reasons for cancellation
   
   @RTD-1433 
Scenario: Validating Back to Profile button in the popup
    Given I lookup for a customer  
    When I select a device with its customization
    Then I see the configuration details of the selected device
    When I click on  Cancel button
    Then I see a popup,asking the reason for cancellation
    When I Click on Back to Profile button
    Then I redirected to account lookup 

@RTD-1434
Scenario: Clicking on Change Device link
    Given I lookup for a customer  
    When I select a device with its customization
    Then I see the configuration details of the selected device
    When I click on Change Device link
    Then it's redirects to the previous page - Device Search       
   
   @RTD-1435 
 Scenario: Verify if different options are available
    Given I lookup for a customer  
    When I select a device with its customization
    Then I see the configuration details of the selected device
    Then I see different options listed- Payment plan,protection plan,data option
 @RTD-1436
 Scenario: Clicking Close icon in Learn more popup 
  	Given I lookup for a customer  
    When I select a device with its customization
    Then I see the configuration details of the selected device
    And I click on Learn more link
    Then I click on Close icon 
    Then the popup should close   
  
  
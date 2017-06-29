Feature: Device_Config

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent


Scenario: Choose Payment plan
	Given I lookup for a customer and I shop a device   
	When I search for a particular device
 	Then I see the configuration details of the selected device
	When I choose a payment plan, Full or Monthly
	And I must see the cost for the plan displayed
	Then I see the selected option highlighted


Scenario: Choose Device protection Plan
	Given I lookup for a customer and I shop a device   
	When I search for a particular device
 	Then I see the configuration details of the selected device
	When I choose to have device protection or not
	Then I see the selected option highlighted
	
Scenario: Choose Data option
	When I search for a particular device
 	Then I see the configuration details of the selected device
	When I choose the data plan, By the Gig or Unlimited
	Then I see the selected option highlighted

Scenario: Clicking on Next button
	Given I lookup for a customer and I shop a device   
	When I search for a particular device
 	Then I see the configuration details of the selected device
	When I click on Next button in DeviceConfig
	Then I should be redirected to next page-Device_Customize
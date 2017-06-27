Feature: Device_Customize

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Choose a number - Get a new number
	Given I lookup for a customer and I shop a device  
	And I am in Device_Customize page
	And I see options to Choose a number
	When I Choose the option, Get a new number
	Then I see the option highlighted
	
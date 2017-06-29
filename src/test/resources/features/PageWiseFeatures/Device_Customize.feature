Feature: Device_Customize

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Choose a number - Get a new number or Keep Number
	Given I lookup for a customer and I shop a device  
	And I am in Device_Customize page
	And I see options to Choose a number
	When I Choose the option, Get a new number or Keep Number
	Then I see the option highlighted

Scenario: Validation of Who is the Phone for	
	Given I lookup for a custoemr and I shop a device   
	And I am in Device_Customize page
	When I see the Who is the Phone for text 
	Then I enter the name of the user
	
	
Scenario: Verify on Add to Cart Button
	Given I lookup for a custoemr and I shop a device   
	And I am in Device_Customize page
	When I click on add to cart after filling all the details 
	Then I see it is updated with the cart count
Feature: Device_Search

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent


Scenario: Validation of Billing address autopopulated
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I see  same as service address is checked
	Then I see billing address is autopopulated
	
Scenario: Click on Save Button - Billing Address
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I save billing address
	Then I see billing address is saved
	
Scenario: Validation of Disable functionality for payment & Contact Information section
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I don't save billing address
	Then I see payment & Contact Information is disabled
	
Scenario: Validation of estimated monthly charges
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	Then I see estimated monthly charges

Scenario: Validation of estimated monthly charges_view detail
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I select view detail in  estimated monthly charges 
	Then I see tax and charges detail in view detail
	
Scenario: Validation of unchecking the same service address
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I uncheck the same service address
	Then I see the billing address is editable

Scenario: Validation of contact information valid email address and phonenumber
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I give valid email address and phone number
	Then I see the contact information is saved

Scenario: Validation of contact information invalid email address and phonenumber
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I give invalid email address and phone number
	Then I see the error message

Scenario: Validation of check in information is correct
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature 
	When I select the check in infromation is correct
	Then I see the check box is checked

Scenario: Validation of edit  Billing address with invalid values
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I enter invalid vlaues in billing address
	Then I see error message

Scenario: Validation of save button in Customer_Pre signature 
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	Then I see save button in Customer_Pre signature

Scenario: Validation of collect signature button in  Customer_Pre signature 
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	Then I see collect signature button in Customer_Pre signature

Scenario: Validation of credit card valid information 
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I enter valid information for credit card details
	Then I see the credti details are saved

Scenario: Validation of credit card invalid information 
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I enter invalid information for credit card details
	Then I see the error message

Scenario: Validation of place order 
	Given I look up for a customer and I shop a device
	And I am in Customer Presignature
	When I check check in information
	Then I see the place order button getting enabled
	When I select place order button
	Then I see the order is placed successfully


	
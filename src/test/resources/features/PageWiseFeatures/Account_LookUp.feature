@account_lookup
Feature: Account LookUp

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@runnewjuly1322 @ac
Scenario: Enter valid Account Number and click on Look Up
	When I enter valid account number
	And I click on Look Up
	Then I see the customer ID validation to launch the customer details

@runnewjuly1322
Scenario: Enter valid Email and click on Look Up
	When I enter valid Email
	And I click on Look Up
	Then I see the customer ID validation to launch the customer details
	
@runnewjuly24
Scenario: Enter invalid Email and click on Look Up
	When I enter invalid Email
	And I click on Look Up
	Then I see error message 
	

@runnewjuly1322
Scenario: Verify the Scan Bill button
	When I click on Scan Bill button
	Then I see the Scan Barcode Now Text
	
@runnewjuly24	
Scenario: Click on Look Up without entering any details
	When I click on Look Up
	Then I see error message 
	
@runnewjuly1733
Scenario: Click on Scan Bill button and close it 
	When I click on Scan Bill button
	Then I see the Scan Barcode Now Text
	And I close the Scan Bill
	Then I see the Look Up Page
	
@runnewjuly1311
Scenario: Click on Scan Bill button and cancel it 
	When I click on Scan Bill button
	Then I see the Scan Barcode Now Text
	And I cancel the Scan Bill
	Then I see the Look Up Page

@runnewjuly1333	
Scenario: Validate the Driver's License in Customer validation popup
	Given I lookup for a Customer 
	When I click on Driver's License in Customer validation popup
	Then I see the account details page
	
@runnewjuly1333	
Scenario: Validate the State ID in Customer validation popup
	Given I lookup for a Customer 
	When I click on State ID in Customer validation popup
	Then I see the account details page

@runnewjuly1333
Scenario: Validate the US Passport in Customer validation popup
	Given I lookup for a Customer 
	When I click on US Passport in Customer validation popup
	Then I see the account details page
	
@runnewjuly1333 @df @testingnow
Scenario: Validate ID does not match link in Customer validation popup
	Given I lookup for a Customer 
	When I click on ID does not match above address or no ID available
	Then I see the SSN validation page 

@runnewju22ly14 @df @testingnow
Scenario: Validate customerId with valid SSN in SSN validation POPUP
	Given I lookup for a Customer 
	When I click on ID does not match above address or no ID available 
	Then I see the SSN validation page
	And I validate using valid SSN

@runnewju22ly14
Scenario: Validate customerId with incorrect SSN in	SSN validation POPUP	
	Given I lookup for a Customer 
	When I click on ID does not match above address or no ID available 
	Then I see the SSN validation page
	And I validate using incorrect SSN

@runnewjul33y14
Scenario: Verification of close button for SSN validation POPUP
	Given I lookup for a Customer 
	When I click on ID does not match above address or no ID available 
	Then I see the SSN validation page
	When I click on close button in SSN page
	Then I see the page returned to Validate customer ID

@runnewjuly1444
Scenario: Verification of cancel button for SSN validation POPUP
	Given I lookup for a Customer 
	When I click on ID does not match above address or no ID available 
	Then I see the SSN validation page
	When I click on cancel button in SSN page
	Then I see the page returned to Validate customer ID

@runnewjuly1422
Scenario: Validate close button for Customer ID verification Page
	Given I lookup for a Customer 
	When I close the cutomer ID verification Page
	Then I see the page returned to look up page

@runnewjuly2411
Scenario: Enter invalid Name and click on Look Up
	When I enter invalid name
	And I click on Look Up button
	Then I see error message
	
@runnewjuly2411
Scenario: Enter invalid Phone Number and click on Look Up
	When I enter invalid phone number
	And I click on Look Up button
	Then I see no records message  
	
	
@runnewjuly2411
Scenario: Enter invalid Account Number and click on Look Up
	When I enter invalid account number
	And I click on Look Up button
	Then I see no records message 
	
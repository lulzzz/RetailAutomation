Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent


Scenario: Verify the Launch Mobile
	Given I am in Device details page
	When I click Launch Mobile
	Then I see the Customer Information page
Feature: Account LookUp

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Valid Account Number and click on Look Up
	When I enter valid account number
	And click on Look Up
	Then I see the customer ID validation to launch the customer details
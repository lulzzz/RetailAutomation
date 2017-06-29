Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent


Scenario: Validate with valid date in Customer info Page
	Given I am in Customer info Page
	When I give valid date or month and click submit
	Then I see it is navigated to device search page
	
Scenario: Validate with  valid ssn in Customer info Page
	Given Iam in Customer info Page
	When I give valid SSN and click submit
	Then I see them accepting 
	
Scenario: Validate with valid lines in Customer info Page
	Given I am in Customer info Page
	When I select valid lines and click submit
	Then I see it is navigated to device search page
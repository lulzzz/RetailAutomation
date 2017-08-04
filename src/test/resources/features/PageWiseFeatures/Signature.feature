Feature: Signature

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Verify if the Continue button is enabled after checking  I agree to use electronic records and signatures 
	Given Am In Please Review & Act on These Documents Page
	When I check the check box for I agree to use electronic records and signatures 
	Then I see the Continue button is enabled

Scenario: Validate Continue after clicking Decline to Sign in Other Actions
	Given Am In Please Review & Act on These Documents Page
	When I click on the Other Actions And select Decline to Sign
	Then I see Caution Pop-Up 
	When I click continue
	Then the Decline to sign Pop-Up opens
	
Scenario: Validate Sign Button
	Given Am In Please Review & Act on These Documents Page
	When the Check Box for I agree to use electronic records and signatures is  checked 
	Then I see Continue button is enabled
	When I select continue and click sign
	Then I see Adopt your signature Pop-Up
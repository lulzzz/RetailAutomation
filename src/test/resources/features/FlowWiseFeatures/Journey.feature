Feature: Journey

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@chamu
Scenario: Placing a single ACME device in store order through Scan option
		Given agent looks for an eligible customer details
		And agent scans the device
		When agent chooses data plan with number selection to do successful checkout  
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
#		When agent submits the order 
#		Then agent sees the order confirmation

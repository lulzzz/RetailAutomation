Feature: Sanity

As an agent, I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@RTD-1282 @sanity_dryrun
Scenario: Placing a single ACME device in store order through Scan option
		Given agent looks for an eligible customer details
		And agent scans the device
		When agent chooses data plan with number selection to do successful checkout  
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@RTD-1315 @sanity_dryrun
Scenario: Placing single device and single accessory through verify link option
		Given agent navigates to 'verify' link to shop for a device
     	When agent chooses a specific device
     	Then agent selects the device color and capacity
     	When agent chooses data plan with number selection 
     	And agent add accessories and select the accessory color
     	Then agent does successful checkout
	   	Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@RTD-1307 
Scenario: Placing hybrid devices in store order through Scan option
    Given agent looks for an eligible customer details
	And agent adds hybrid devices into cart through scan
 	When agent attempts to checkout 
 	Then agent sees the billing address details along with payment & contact info
    And agent provides digital signature and accepts to T&C
    When agent submits the order 
    #Then agent sees the order confirmation
    
@RTD-1318 
Scenario: Placing 5 devices in store order for first-time user through verify
	Given agent looks for an eligible customer with no active lines 
	When agent adds multiple devices into cart to reach to defined device limit through verify
	And agent attempts to do a successful checkout 
	Then agent sees the billing address details along with payment & contact info
	And agent provides digital signature and accepts to T&C
	When agent submits the order 
	#	Then agent sees the order confirmation   
	
@RTD-1314 @sanity_dryrun
Scenario: Placing just accessory without existing device ship flow option
		Given agent searches for customers account number to shop accessory
		When agent clicks on 'verify' link 
		Then agent sees the message to add a device first	 
     	
Feature: Journey

As an agent, I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@sanity	@ACMEScan
Scenario: Placing a single ACME device in store order through Scan option
		Given agent looks for an eligible customer details
		And agent scans the device
		When agent chooses data plan with number selection to do successful checkout  
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@sanity	@AndroidScan
Scenario: Placing a single Android device in store order through Scan option
		Given agent looks for an eligible customer details
		And agent scans the device
		When agent chooses data plan with number selection to do successful checkout  
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@sanity1	@AndroidShipOrder
Scenario: Placing an ANDROID single device in store order through Verify Link option
		Given agent navigates to 'verify' link to shop for a device
     	When agent chooses a specific device
     	Then agent selects the device color and capacity
		When agent chooses data plan with number selection to do successful checkout  
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@sanity1	@ACMEShiporder
Scenario: Placing an ACME single device in store order through Verify Link option
		Given agent navigates to 'verify' link to shop for a device
     	When agent chooses a specific device
     	Then agent selects the device color and capacity
		When agent chooses data plan with number selection to do successful checkout  
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@AccessoryForExistingDevice
Scenario: Placing just accessory through Verify Link option
		Given agent navigates to 'verify' link to shop for just accessory
		When agent chooses a specific accessory category
		And agent selects particular accessory and color
		Then agent does successful checkout
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation

@sanity @AccessoryWithoutExistingDevice @RTD-1314
Scenario: Placing just accessory without existing device ship flow option
		Given agent searches for customers account number to shop accessory
		When agent clicks on 'verify' link 
		Then agent sees the message to add a device first
		
@HybridScan
Scenario: Placing hybrid devices in store order-Scan
    Given agent looks for an eligible customer details
	And agent adds hybrid devices into cart through scan
 	When agent attempts to checkout 
 	Then agent sees the billing address details along with payment & contact info
    And agent provides digital signature and accepts to T&C
    When agent submits the order 
    #Then agent sees the order confirmation
    
@HybridVerify 
Scenario: Placing hybrid devices in store order-Verify
 Given agent looks for an eligible customer details
 And agent adds hybrid devices into cart through verify
 When agent attempts to checkout 
 Then agent sees the billing address details along with payment & contact info
 And agent provides digital signature and accepts to T&C
 When agent submits the order 
##Then agent sees the order confirmation

@5linesScan
Scenario: Placing 5 devices in store order for first-time user through scan
 Given agent looks for an eligible customer with no active lines 
 When agent adds multiple devices into cart to reach to defined device limit
 And agent attempts to do a successful checkout 
 Then agent sees the billing address details along with payment & contact info
 And agent provides digital signature and accepts to T&C
 When agent submits the order 
#Then agent sees the order confirmation

@5linesVerify @RTD-1318
Scenario: Placing 5 devices in store order for first-time user through verify
 Given agent looks for an eligible customer with no active lines 
 When agent adds multiple devices into cart to reach to defined device limit through verify
  And agent attempts to do a successful checkout 
  Then agent sees the billing address details along with payment & contact info
	And agent provides digital signature and accepts to T&C
    When agent submits the order 
#	Then agent sees the order confirmation

@HybridAccessoryVerify
Scenario: Placing hybrid devices and single accessory through verify
   Given agent looks for an eligible customer details
   And agent adds hybrid devices and accessory into cart through verify
   When agent attempts to checkout 
   Then agent sees the billing address details along with payment & contact info
   And agent provides digital signature and accepts to T&C
   When agent submits the order 
##Then agent sees the order confirmation

@HybridMultiAccessoryVerify
Scenario: Placing hybrid devices and multiple accessories through verify
   Given agent looks for an eligible customer details
   And agent adds hybrid devices and multiple accessories into cart through verify
   When agent attempts to checkout 
   Then agent sees the billing address details along with payment & contact info
   And agent provides digital signature and accepts to T&C
   When agent submits the order 
##Then agent sees the order confirmation

@runnewjuly1222 @RTD-1315
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

@runnewjuly12
Scenario:  Placing single device and multiple accessories through verify link option
		Given agent navigates to 'verify' link to shop for a device
     	When agent chooses a specific device
     	Then agent selects the device color and capacity
     	When agent chooses data plan with number selection 
     	And agent add multiple accessories and select the accessory color
    	Then agent does successful checkout
	   	Then agent sees the billing address details along with payment & contact info
#		And agent provides digital signature and accepts to T&C
#		When agent submits the order 
#		Then agent sees the order confirmation

@runcreditcheckscan
Scenario: Placing multiple devices through ship flow link for a customer with Run Credit Check popup displays approved
Given agent looks for an eligible customer with no active lines 
 When agent adds multiple devices into cart and run creditcheck
  And agent attempts to do a successful checkout 
  Then agent sees the billing address details along with payment & contact info
	And agent provides digital signature and accepts to T&C
    When agent submits the order 
    #Then agent sees the order confirmation 
    
 @runcreditcheckscan2   
 Scenario: Placing multiple devices by giving valid IMEI for a customer with Run Credit Check popup displays approved
 Given agent looks for an eligible customer with no active lines 
 When agent adds multiple devices into cart with scan and run creditcheck
 And agent attempts to do a successful checkout 
 Then agent sees the billing address details along with payment & contact info
 And agent provides digital signature and accepts to T&C
  When agent submits the order 
   #Then agent sees the order confirmation 
    
    @runnewjuly2122
Scenario: Placing multiple accessories through verify link (PreCondition: already a device should be ordered)
		Given agent navigates to 'verify' link to shop for accessory
		When agent chooses multiple accessories
		Then agent does successful checkout
		Then agent sees the billing address details along with payment & contact info
		And agent provides digital signature and accepts to T&C
		When agent submits the order 
#		Then agent sees the order confirmation
@runnewjuly2133 @RTD-1382
Scenario: Placing a Single device by giving invalid IMEI number results in error message
		Given agent looks for an eligible customer details
		And agent scans the device with invalid number
		Then agent saw the error message
		
@runnewjuly21
Scenario: Placing maximum device limit by giving valid IMEI number, if the member has already a single active line
Given agent looks for an eligible customer with single active line
 When agent adds multiple devices into cart to reach to defined device limit through Scan
 And agent attempts to do a successful checkout 
 Then agent sees the billing address details along with payment & contact info
 And agent provides digital signature and accepts to T&C
 When agent submits the order 
#Then agent sees the order confirmation
     	
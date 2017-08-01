Feature: Account_Devices

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@ad
Scenario: Verify the Scan Device message displayed under Manage Devices
	Given I am in Devices page
	Then I see the Scan device message displayed

@ad
Scenario: Verify after clicking the Scan Device button displays the Scan Barcode text
	Given I am in Devices page
	When I click Scan Device
	Then I see the Scan Barcode Now Text
	
@ad
Scenario: Verify Scan Device and close it
	Given I am in Devices page
	When I click Scan Device
	Then I see the Scan Barcode Now Text
	And I close the Scan Bill
	Then I see the Devices page
	
@ad
Scenario: Verify Scan Device and cancel it
	Given I am in Devices page
	When I click Scan Device
	Then I see the Scan Barcode Now Text
	And I cancel the Scan Bill
	Then I see the Devices page

@ad
Scenario: Verify Add Device Manually navigates to next page
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page

@ad	
Scenario: Validate Add Device Manually and close it
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I close Add Device page
	Then I see the warning message
@ad
Scenario: Validate Add Device Manually and cancel it
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I cancel Add Device page
	Then I see the warning message
@ad
Scenario: Validate Yes in the Warning page of Add Device Manually after clicking close/cancel
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I cancel Add Device page
	Then I see the warning message
	When I click Yes in warning page
	Then I see the Devices page

@ad
Scenario: Validate No in the Warning page of Add Device Manually after clicking close/cancel
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I cancel Add Device page
	Then I see the warning message
	When I click No in warning page
	Then I see the Devices page
@ad	
Scenario: Validate Close in the Warning page of Add Device Manually after clicking close/cancel
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I cancel Add Device page
	Then I see the warning message
	When I close the warning page
	Then I see the Add Device page
@ad
Scenario: Validate the error message for invalid number in Add Device Manually
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I enter invalid number
	And I click Next
	Then I see the error message

@ad
Scenario: Verify ok in error page of Add Device Manually
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I enter invalid number
	And I click Next
	Then I see the error message
	When I click ok in error page
	Then I see the Add Device page

@ad
Scenario: Verify close in error page of Add Device Manually
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I enter invalid number
	Then I see the error message
	And I click Next
	When I close the error page
	Then I see the Add Device page
@ad
Scenario: Validate the device details are displayed for valid serial number in Add Device Manually
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I enter valid serial number
	And I click Next
	Then I see the device details

@ad
Scenario: Verify close in the device details page for valid serial number/MAC address
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I enter valid number
	And I click Next
	Then I see the device details
	When I close the device details
	Then I see the Devices page
@ad
Scenario: Verify cancel in the device details page for valid serial number/MAC address
	Given I am in Devices page
	When I click Add Device Manually
	Then I see the Add Device page
	When I enter valid number
	And I click Next
	Then I see the device details
	When I click cancel in device details
	Then I see the Devices page
	
	@runnewjuly21	
Scenario: Validate Back in Manage Devices page
	Given I am in Devices page
	When I click Back
	Then I see the Account Details page
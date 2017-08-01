Feature: Device_Search

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent


Scenario: Verification of Device Images 
	Given I lookup for a customer and I shop a device
    And I am in Shopping cart Page
    Then I verify the device images

Scenario: Verification of Charges
   Given I lookup for a customer and I shop a device
   And I am in Shopping cart Page
   Then I verify the device charges

Scenario: Validation of Edit Cart (Top)_Line Details
    Given I lookup for a customer and I shop a device
    And I am in Shopping cart Page 
    When I click on Edit cart   top of the cart summary
    Then I see Edit order Page 
    When I select line details 
    Then I see page is navigated to device customize page

Scenario: Validation of Edit Cart (Top)_Payment Details
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I click on Edit cart   top of the cart summary
Then I see Edit order Page 
When I select Payment Details
Then I see page is navigated to device config page

Scenario: Validation of Edit Cart (Bottom)_Delete Line
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I click on Edit cart  top of the cart summary
Then I see Edit order Page
When I select delete line
Then I see line is deleted

@RTD-1423
Scenario: Validation of Continue Customization
	Given I lookup for a customer and I shop a device
	And I am in Shopping cart Page
	When I select Continue Customization
	Then I see the Device Config Page  
	
Scenario: Validation of Edit Cart (Bottom)_Line Details
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I click on Edit cart   top of the cart summary
Then I see Edit order Page 
When I select line details 
Then I see page is navigated to device customize page

Scenario: Validation of Edit Cart (Bottom)_Payment Details
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I click on Edit cart   top of the cart summary
Then I see Edit order Page 
When I select Payment Details
Then I see page is navigated to device config page

@RTD-1426
Scenario: Validation of Add Another Line
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page
When I select Add another line
Then I see the Device Search Page

Scenario: Validation of Print
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I select print
Then I see page is navigated to print page

Scenario: Validation of Back Arrow
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I select back arrow in header
Then I see page is navigated to  device customize page

Scenario: Validation of Cancel Button
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I select cancel button
Then I see a pop message asking for a reason 

Scenario: Validation of Continue to Checkout Button
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I select Continue to Checkout Button
Then I see page is navigated to  Customer_PreSignature

Scenario: Verify view/hide details in Shopping cart page
Given I lookup for a customer and I shop a device
And I am in Shopping cart Page 
When I select view details in Shopping cart Page
Then I see charge details displayed 
When I select hide details in Shopping cart Page
Then I see charge details are not displayed

@RTD-1425
Scenario: Validation of Delete Line 	
	Given I lookup for a customer and I shop a device
	And I am in Shopping cart Page
	When I  select Delete Line
	Then I see the cart text
	
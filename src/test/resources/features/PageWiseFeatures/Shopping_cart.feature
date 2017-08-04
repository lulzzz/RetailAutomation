Feature: Shopping_Cart

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@RTD-1426
Scenario: Validation of Add Another Line in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow 
	When I select Add another line
	Then I see the Device Search Page
	
@RTD-1521	
Scenario: Validation of Continue to Checkout button in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow 
	When I select Continue to Checkout Button
	Then I see the CustomerPreSignature Page
	
@RTD-1425
Scenario: Validation of Delete Line by clicking Edit Cart(Top) button in Cart Page through Scan flow 
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at top of the cart summary
	Then I see Edit order Page
	When I select Delete Line
	Then I see the cart text
	
@RTD-1522	
Scenario: Validation of Delete Line by clicking Edit Cart(Bottom) button in Cart Page through Scan flow 
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at bottom of the cart summary
	Then I see Edit order Page
	When I select Delete Line
	Then I see the cart text
	
@RTD-1523	
Scenario: Validation of Done button by clicking Edit Cart(Top) button in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at top of the cart summary
	Then I see Edit order Page
	When I click Done button
	Then I see the Customer Order Review in Shopping Cart Page
	
@RTD-1524
Scenario: Validation of Done button by clicking Edit Cart(Bottom) button in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at bottom of the cart summary
	Then I see Edit order Page
	When I click Done button
	Then I see the Customer Order Review in Shopping Cart Page
	
@RTD-1525	
Scenario: Validation of Payment Details button by clicking Edit Cart(Top) button in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at top of the cart summary
	Then I see Edit order Page
	When I click Payment Details button
	Then I see the payment details in Device Config Page 

@RTD-1526	
Scenario: Validation of Payment Details button by clicking Edit Cart(Bottom) button in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at bottom of the cart summary
	Then I see Edit order Page
	When I click Payment Details button
	Then I see the payment details in Device Config Page 
	
@RTD-1527	
Scenario: Validation of Line Details button by clicking Edit Cart(Top) button in Cart Page through Scan flow
	Given I am in Shopping cart Page through Scan flow
	When I click Edit cart at top of the cart summary
	Then I see Edit order Page
	When I click Line Details button
	Then I see the line details in Device Customize Page 
	
	
@RTD-1423
Scenario: Validation of Continue Customization by clicking Cart Icon in Device Config Page through Scan flow
	Given I am in Device Config Page through Scan flow
	When I click Cart Icon to see Shopping Cart Page
	#Then I see the Shopping Cart Page	
	When I select Continue Customization
	Then I see the Device Config Page
	


@RTD-1426
Scenario: Validation of Delete Line by clicking Cart Icon in Device Config Page through Scan flow
	Given I am in Device Config Page through Scan flow
	When I click Cart Icon to see Shopping Cart Page
	When I select Delete Line
	Then I see the cart text
	
@RTD-1528
Scenario: Validation of Add a Line button after deleting a line by clicking Cart Icon in Device Config Page through Scan flow
	Given I am in Device Config Page through Scan flow
	When I click Cart Icon to see Shopping Cart Page
	When I select Delete Line
	Then I see the cart text
	When I select Add a Line
	Then I see the Device Search Page
	
@RTD-1529	
Scenario: Validation of Back Arrow by clicking Cart Icon in Device Config Page through Scan flow
	Given I am in Device Config Page through Scan flow
	When I click Cart Icon to see Shopping Cart Page
	When I click Back Arrow
	Then I see the Device Config Page
	
@RTD-1530	
Scenario: Validation of Add Another Line in Cart Page through Verify flow
	Given I am in Shopping cart Page through Verify flow 
	When I select Add another line
	Then I see the Device Search Page
	
@RTD-1531
Scenario: Validation of Continue to Checkout button in Cart Page through Verify flow
	Given I am in Shopping cart Page through Verify flow 
	When I select Continue to Checkout Button
	Then I see the CustomerPreSignature Page
	
@RTD-1532
Scenario: Validation of Delete Line by clicking Edit Cart(Top) button in Cart Page through Verify flow 
	Given I am in Shopping cart Page through Verify flow
	When I click Edit cart at top of the cart summary
	Then I see Edit order Page
	When I select Delete Line
	Then I see the cart text
	
@RTD-1533	
Scenario: Validation of Delete Line by clicking Edit Cart(Bottom) button in Cart Page through Verify flow 
	Given I am in Shopping cart Page through Verify flow
	When I click Edit cart at bottom of the cart summary
	Then I see Edit order Page
	When I select Delete Line
	Then I see the cart text
	
@RTD-1534	
Scenario: Validation of Done button by clicking Edit Cart(Top) button in Cart Page through Verify flow
	Given I am in Shopping cart Page through Verify flow
	When I click Edit cart at top of the cart summary
	Then I see Edit order Page
	When I click Done button
	Then I see the Customer Order Review in Shopping Cart Page
	
@RTD-1535
Scenario: Validation of Done button by clicking Edit Cart(Bottom) button in Cart Page through Verify flow
	Given I am in Shopping cart Page through Verify flow
	When I click Edit cart at bottom of the cart summary
	Then I see Edit order Page
	When I click Done button
	Then I see the Customer Order Review in Shopping Cart Page
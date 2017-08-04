@account_details
Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@Validateinfo @adet @runnewaug02
Scenario: Validate the customer information in Account Details Page
    Given I am in Device details page
    Then I see the customer details
 
 @launchmobile   @adet @runnewaug02
Scenario: Verify the Launch Mobile
	Given I am in Device details page
	When I click Launch Mobile
	Then I see the Customer Information page
	
 @appointment	@adet @runnewaug02
Scenario: Validate the Appointments section
Given I am in Device details page
Then I see the appointment details

@serviceimages @adet @runnewaug02
Scenario: Validate the service images are displayed (TV, Wifi, Phone)
Given I am in Device details page
Then I  see the service images element

@viewall @adet @runnewaug02
Scenario: Verify the View All link in Notes Section with predefined Notes
Given I am in Device details page
When I click on View All in Notes section
Then I see the View Notes page

@addnote @runnewaug02
Scenario: Verify the Add Note link displays the Add New Note in Notes section 
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note

@newnote @runnewaug02
Scenario: Validate the Add New Note popup after clicking Add Note in Notes section
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the select Note Type, Subject and Message

@closeAddnewnote @runnewaug02
Scenario: Verify if Close button is clickable when Add Note is clicked in Notes section
#Scenario: Click on Close in the Add New Note page after clicking Add Note in Notes section
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note
When I close Add New Note
Then I see the Account details page

@closeAddnewnote @runnewaug02
Scenario: Verify if Cancel button is clickable when Add Note is clicked in Notes section
#Scenario: Click on Cancel in the Add New Note page after clicking Add Note in Notes section
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note
When I click cancel in Add New Note
Then I see the Account details page

@verifyAccountstatus @runnewaug02
Scenario: Verify the Account Status
Given I am in Device details page
Then I see the Account status

@verifynotes @runnewaug02
Scenario: Verify the Notes section
Given I am in Device details page
When I see the Notes section 
And I click on Notes
Then I see the View Notes page

@verifycomaprebills @runnewaug02
Scenario: Verify the Compare Bills
Given I am in Device details page
When I click Compare Bills
Then I see the Bill comparison


@runnewaug02
Scenario: Verify the Note type required text when Add Note is clicked from Add New Note pop up
#Scenario: Verify the Note type required text after clicking Add Note twice in Notes section
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note
When I click on Add Note in Add New Note page
Then I see the Note type required message


@runnewaug02
Scenario: Verify if Close button is clickable when Add Note is clicked from Add New Note pop up
#Scenario: Click on Close in the Note type required text after clicking Add Note twice in Notes section
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note
When I click on Add Note in Add New Note page
Then I see the Note type required message
When I close the Note type
Then I see the Add New Note


@runnewaug02
Scenario: Verify if Ok button is clickable when Add Note is clicked from Add New Note pop up
#Scenario: Click on Ok in the Note type required text after clicking Add Note twice in Notes section
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note
When I click on Add Note in Add New Note page
Then I see the Note type required message
When I click ok in Note type
Then I see the Add New Note

@runnewaug02
Scenario: Verify the Message required text when Add Note is clicked after selecting Note Type from Add New Note pop up
#Scenario: Verify the Message required text,add message (Click on Add Note after selecting note type and without message)
Given I am in Device details page
When I click on Add Note in Notes section
And I select the note type
When I click on Add Note in Add New Note page
Then I see the Message required text


@runnewaug02
Scenario: Verify if Close button is clickable when Add Note is clicked after selecting Note Type from Add New Note pop up
#Scenario: Click on Close in the Message required text
Given I am in Device details page
When I click on Add Note in Notes section
And I select the note type
When I click on Add Note in Add New Note page
Then I see the Message required text
When I close the Message required 
Then I see the Add New Note


@runnewaug02
Scenario: Verify if Ok button is clickable when Add Note is clicked after selecting Note Type from Add New Note pop up
#Scenario: Click on Ok in the Message required text
Given I am in Device details page
When I click on Add Note in Notes section
Then I see the Add New Note
And I select the note type
When I click on Add Note in Add New Note page
Then I see the Message required text
When I click ok in Message required 
Then I see the Add New Note

@runnewaug02
Scenario: Verify the Mobile Details section
Given I am in Device details page
Then I see the Mobile Details section

@verifynotetype @runnewaug02
Scenario: Verify the View Bill with Bills paid
Given I am in Device details page
When I click View Bill
Then I see the Bill details

@runnewaug02
Scenario: Validate the Eligible Icon and its text at the footer
Given I am in Device details page
Then I see the Icon for eligible
And I see the Eligible text

@runnewaug02
Scenario: Verify the Manage Devices	
	Given I am in Device details page
	When I click Manage Devices
	Then I see the Devices page
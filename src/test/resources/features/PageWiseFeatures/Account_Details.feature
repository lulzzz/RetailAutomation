Feature: Account_Details

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@Validateinfo
Scenario: Validate the customer information in Account Details Page
    Given I am in Device details page
    Then I see the customer details
 
 @launchmobile   
Scenario: Verify the Launch Mobile
	Given I am in Device details page
	When I click Launch Mobile
	Then I see the Customer Information page
	
 @appointment	
Scenario: Validate the Appointments section
Given I am in Device details page
Then I see the appointment details

@serviceimages
Scenario: Validate the service images are displayed (TV, Wifi, Phone)
Given I am in Device details page
Then I see the service images

@viewall
Scenario: Verify the View All link
Given I am in Device details page
When I click on View All
Then I see the View Notes page

@addnote
Scenario: Verify the Add Note link displays the New Note 
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note

@newnote
Scenario: Validate the New Note page (displays the Select Note Type, Subject, Message)
Given I am in Device details page
When I click on Add Note
Then I see the select Note Type, Subject and Message

@closeAddnewnote
Scenario: Click on Close in the Add New Note page
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note
When I close Add New Note
Then I see the Account details page

@closeAddnewnote
Scenario: Click on Cancel in the Add New Note page
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note
When I click cancel in Add New Note
Then I see the Account details page

@verifyAccountstatus
Scenario: Verify the Account Status
Given I am in Device details page
Then I see the Account status

@verifynotes
Scenario: Verify the Notes section
Given I am in Device details page
When I see the Notes section 
And I click on Notes
Then I see the View Notes page

@verifycomaprebills
Scenario: Verify the Compare Bills
Given I am in Device details page
When I click Compare Bills
Then I see the Bill comparison


Scenario: Verify the Note type required text - select a note type 
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note
When I click on Add Note in Add New Note page
Then I see the Note type required message


Scenario: Click on Close in the Note type required text
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note
When I click on Add Note in Add New Note page
Then I see the Note type required message
When I close the Note type
Then I see the Add New Note


Scenario: Click on Ok in the Note type required text
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note
When I click on Add Note in Add New Note page
Then I see the Note type required message
When I click ok in Note type
Then I see the Add New Note

Scenario: Verify the Message required text,add message (Click on Add Note after selecting note type and without message)
Given I am in Device details page
When I click on Add Note
And I select the note type
When I click on Add Note in Add New Note page
Then I see the Message required text


Scenario: Click on Close in the Message required text
Given I am in Device details page
When I click on Add Note
And I select the note type
When I click on Add Note in Add New Note page
Then I see the Message required text
When I close the Message required 
Then I see the Add New Note


Scenario: Click on Ok in the Message required text
Given I am in Device details page
When I click on Add Note
Then I see the Add New Note
And I select the note type
When I click on Add Note in Add New Note page
Then I see the Message required text
When I click ok in Message required 
Then I see the Add New Note

Scenario: Verify the Mobile Details section
Given I am in Device details page
Then I see the Mobile Details section

@verifynotetype
Scenario: Verify the View Bill
Given I am in Device details page
When I click View Bill
Then I see the Bill details


Scenario: Validate the Eligible Icon and its text at the footer
Given I am in Device details page
Then I see the Icon for eligible
And I see the Eligible text

Scenario: Verify the Launch Mobile
	Given I am in Device details page
	When I click Launch Mobile
	Then I see the Customer Information page

Scenario: Verify the Manage Devices	
	Given I am in Device details page
	When I click Manage Devices
	Then I see the Devices page
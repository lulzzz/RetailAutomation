@view_notes
Feature: View_Notes

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

Scenario: Validate the Back button in view_notes page
Given I am in View Notes page
When I click Back Button
Then I am navigated to Account details page

@run
Scenario: Validate all the fields are displayed in notes (Date/Time, Source, Name, Type, Subject, Message)
Given I am in View Notes page
Then I see all the fields are displayed in table

@run @vn
Scenario: Validate the sorting button is displayed in Date/Time of view_notes page
Given I am in View Notes page
Then I see the sorting button is displayed in Date/Time

#Scenario: Validate the sorting(ascending) based on Date/Time
#Given I am in View Notes page
#Then I sort in ascending order based on Date/Time
#Then I see the table is arranged in ascending order
#
#Scenario: Validate the sorting(descending) based on Date/Time
#Given I am in View Notes page
#Then I sort in descending order based on Date/Time
#Then I see the table is arranged in descending order

 
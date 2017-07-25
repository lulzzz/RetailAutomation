@viewNotes
Feature: View Notes

As an agent,I need to support customer for shopping XFINITY Mobile products and plans.

Background: 
Given I launch the Retail application as an agent

@run
Scenario: Validate the Back button 
Given I am in View Notes page
When I click Back Button
Then I am navigated to Account details page

@run2
Scenario: Validate all the fields are displayed in notes (Date/Time, Source, Name, Type, Subject, Message)
Given I am in View Notes page
Then I see all the fields are displayed in table

@run1
Scenario: Validate the sorting button is displayed in Date/Time
Given I am in View Notes page
Then I see the sorting button is displayed in Date/Time

Scenario: Validate the sorting(ascending) based on Date/Time
Given I am in View Notes page
Then I sort in ascending order based on Date/Time
Then I see the table is arranged in ascending order

Scenario: Validate the sorting(descending) based on Date/Time
Given I am in View Notes page
Then I sort in descending order based on Date/Time
Then I see the table is arranged in descending order

 
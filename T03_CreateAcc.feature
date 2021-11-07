Feature: Creation of a New Account

#scenario 1
Scenario Outline: Create a New Account

Given Enter the username as <username>
And Enter the password as <password>
When click on Login button
Then choose view all option by clicking on toggle menu
Given Enter text as 'Sales' in app launcher screen
Then click opportunities tab
When click on New Button
Given Enter the Account Name as <name>
And Enter the close date as <closedate>
And select the stage value from dropdown
Then click on save button
And Verify the account is created 

Examples:
|username|password|name|closedate|
|'fullstack@testleaf.com'|'SelBootcamp$123'|'Salesforce Automation as Goutham'|'11/06/2021'|
#|'fullstack@testleaf.com'|'SelBootcamp$123'|'TestLeaf'|'11/05/2021'|
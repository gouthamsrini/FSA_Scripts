Feature: Creation of a New Account

#Background: 
#Given Open the chrome browser
#And Load the application url 'https://login.salesforce.com'


@functional
Scenario Outline: Create a New Account
Given Enter the username as <username>
And Enter the password as <password>
When click on Login button
Then HomePage should be displayed
When click on Toggle Menu on left corner
And click on View All Option
Given Enter the search apps as <searchText> in AppLauncher screen
And click on Sales option which has description of Manage your sales
Then Quarterly Performance page should be displayed
When click on Opportunities option
Then Opportunities page is displayed
When click on New button
Given Enter the Opportunity Name as <name>
And Enter the Close Date as <closedate>
And Choose Stage from dropdown
When click on Save button
Then success message should be displayed 

Examples:
|username|password|searchText|name|closedate|
|'fullstack@testleaf.com'|'SelBootcamp$123'|'Sales'|'Salesforce Automation as Goutham'|'11/06/2021'|
|'fullstack@testleaf.com'|'SelBootcamp$123'|'Sales'|'TestLeaf'|'11/05/2021'|
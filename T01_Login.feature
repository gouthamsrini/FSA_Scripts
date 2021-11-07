Feature: Login functionality of Salesforce Application

#Background: 
#Given Open the chrome browser
#And Load the application url 'https://login.salesforce.com'

#scenario 1
@smoke
Scenario Outline: Login with valid credentials
Given Enter the username as <username>
And Enter the password as <password>
When click on Login button
Then HomePage should be displayed

Examples:
|username|password|
|'fullstack@testleaf.com'|'SelBootcamp$123'|

#scenario 2
Scenario: Login with invalid credentials
Given Enter the username as 'fullstack@testleaf.com'
And Enter the password as 'Selcamp$123'
When click on Login button
But Error message should be displayed
Feature: Creation of a New Case

#scenario 1
@regression
Scenario Outline: Create a New Account

Given Enter the username as <username>
And Enter the password as <password>
When click on Login button
Then choose view all option by clicking on toggle menu
Given Enter text as 'Sales' in app launcher screen
Then choose More option in saleshome page
And select cases option from dropdown list
When click on new cases button 
Then Enter the required contact name
And choose case origin
And choose status 
Given Enter the subject as <subjName>
And Enter the description as <description>
When click Save
Then verify case is created

Examples:
|username|password|subjname|description|
|'fullstack@testleaf.com'|'SelBootcamp$123'|Testing|CucumberTest|
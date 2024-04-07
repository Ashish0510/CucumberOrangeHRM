
Feature: Login
Scenario Outline:  To verify the valid login
Given user open the browser and enters the url "https://ash0510-trials712.orangehrmlive.com/auth/login"
When user enters the username as "<username>"
And enters the password as "<password>"
Then click on the login button 

Examples:
|username|password|
|Admin|6QTsF@Lgn9|


 

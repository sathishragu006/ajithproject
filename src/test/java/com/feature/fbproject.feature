Feature: Facebook launch

Scenario: Facebook HomePage

Given  launch Url 

When user Pass Username

And user Plugin Password

And user Click Login Buuton

And take Screenshort For LoginPage

And user Type Name

And user Type Surename

And user Type Mobilenumber

And user Select BirthdayDate

And user Select BirthdayMonth,BirthdayYear

And user Click Signin

Then take Screenshort For SignPage



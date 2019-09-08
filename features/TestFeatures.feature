Feature: Technical Test

@Scenario1
Scenario: TruNarrative is first result on Google
Given User is on Google home page
When TruNarrative is searched for
Then TruNarrative is the first result
And it points to TruNarrative home

@Scenario2
Scenario: TruNarrative Home has strap line
Given User is on TruNarrative home
When TruNarrative home page is displayed
Then Strap line is present

@Scenario3
Scenario: Leadership team consists of eight people
Given User has navigated to Team Page
When Team members are counted
Then There are eight team members in total

@Scenario4
Scenario: John Lord has role Founder and CEO
Given User has navigated to Team Page
When John Lords info is viewed
Then he has role Founder and CEO

@Scenario5
Scenario: David Eastaugh has role CTO
Given User has navigated to Team Page
When David Eastaughs info is viewed
Then he has role CTO

@Scenario6
Scenario: Nicola Janney has role Human Resources Manager
Given User has navigated to Team Page
When Nicola Janneys info is viewed
Then she has role Human Resources Manager
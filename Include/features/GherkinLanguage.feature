#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login
  I want to Login and see form appointment

  @tag1
  Scenario Outline: Login success and direct to page appointment
    Given I want to navigates to login page
    When I input credential <username> and <password>
    And click button login
    Then I navigated to form page appointment
    


    Examples: 
      | username |password |
      | John Doe |ThisIsNotAPassword |
      
      
   @tag2
  Scenario Outline: Login failed input credential invalid
    Given I want to navigates to login page
    When I input credential <username> and <password>
    And click button login
    Then I see failed credential


    Examples: 
      | username |password |
      | UserInvalid |ThisPasswordinvalid |

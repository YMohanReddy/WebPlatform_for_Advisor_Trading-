Feature: User Authentication
  As a user
  I want to log in and log out of my trading account
  So that I can manage my trades securely

  Scenario: Successful login
    Given I am on the login page
    When I enter valid "<username>" and "<password>"
    And I click on the login button
    Then I should be redirected to the dashboard
    And I should see a welcome message
    
    Examples:
    |username|password|
    |9347704295|9995|

  #Scenario: Unsuccessful login with incorrect credentials
    #Given I am on the login page
    #When I enter an invalid username or password
    #And I click on the login button
    #Then I should see an error message indicating invalid credentials
#
  #Scenario: User logs out successfully
    #Given I am logged in to my account
    #When I click on the logout button
    #Then I should be redirected to the login page
    #And I should see a logout confirmation message

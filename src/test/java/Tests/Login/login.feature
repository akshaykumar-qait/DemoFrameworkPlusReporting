Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User intializes all the class objects
    When User Navigate to LogIn Page
    And enters wrong usernamepassword
    Then user is landed to a invaid credentials url 
    When the user click on the back button
    And clicks on the edulogo button
    And enter the correct username and password
    Then the user is navigated to correct url
    When the user click on the logout button
    Then the user is navigated to the base url
 
Feature: Login Action

  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    When I input the provience <Provience>
    Then the tax value should be <Tax>
   
    When I input the provience <Provience>
    And enters username <UserName>
    And password <Password>
    And i click on the Login button
    Then Message displayed Login Successfully

    Examples: 
      | UserName    | Password    | LogIn          | Provience | Tax |
      | "username1" | "password2" | www.google.com | "Othelo"  | "45.6" |
      | "username2" | "password2" | www.google.com | "Othelo"  | "45.6" |

      
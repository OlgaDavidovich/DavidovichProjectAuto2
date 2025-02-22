Feature:  Testing of LoginPage

  Scenario: Positive Test Log In
    Given Set up driver
    When Open Login page
    And Set correct email
    And Set correct password
    And Click Sign In button
    Then User is in system
    And Driver quit

  Scenario: Negative Test Log In with wrong email
    Given Set up driver
    When Open Login page
    And Set incorrect email
    And Set correct password
    And Click Sign In button
    Then Check error message Sign In
    And Driver quit

  Scenario: Check Registration Link
    Given Set up driver
    When Open Login page
    And click registration ref
    Then check registration form name
    And Driver quit

  Scenario: Negative Test Registration With Wrong Email Test
    Given Set up driver
    When Open Registration page
    And Set correct first name
    And Set correct last name
    And Set correct date of birth
    And Click email registration
    And Set incorrect email by registration
    And Set correct password by registration
    And Set correct password confirmation by registration
    Then Check error message wrong email registration
    And Driver quit


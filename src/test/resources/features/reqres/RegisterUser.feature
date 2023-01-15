Feature: Testing Register User Reqres API
  @Tugas
  Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send request post register user
    Then Should return status code 200
    And Validate json schema register user

  @Tugas
  Scenario: Post register user with null email value
    Given Post register user with null email value
    When Send request post register user
    Then Should return status code 400

  @Tugas
  Scenario: Post register user with null password value
    Given Post register user with null password value
    When Send request post register user
    Then Should return status code 400

  @Tugas
  Scenario: Post register user with null all variable value
    Given Post register user with null all variable value
    When Send request post register user
    Then Should return status code 400

  @Tugas
  Scenario: Post register user with wrong variable
    Given Post register user with wrong variable
    When Send request post register user
    Then Should return status code 400
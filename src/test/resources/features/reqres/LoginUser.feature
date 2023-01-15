Feature: Testing Login User
  @Tugas
  Scenario: Post login user
    Given Post login user with valid json
    When send request post login user
    Then Should return status code 200
    And validate json schema login user

  @Tugas
  Scenario: Post login user with null email value
    Given Post login user with invalid json null email value
    When send request post login user
    Then Should return status code 400



  @Tugas
  Scenario: Post login user with null password value
    Given Post login user with invalid json null password value
    When send request post login user
    Then Should return status code 400


  @Tugas
  Scenario: Post login user with null value all variable
    Given Post login user with invalid json null all variable
    When send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with wrong variable
    Given Post login user with invalid variable
    When send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with wrong email
    Given Post login user with invalid email
    When send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with wrong password
    Given Post login user with invalid password
    When send request post login user
    Then Should return status code 400
Feature: Testing Create user Reqres API
  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Mukhlis Anshori" and job "QA Engineer"
    And Validate json schema create user


  @Tugas
  Scenario: Post create new user with valid json
    Given Post create user with valid json value
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Mukhlis Anshori" and job "QA"
    And Validate json schema create user

  @Tugas
  Scenario: Post create new user with invalid variables
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400

  @Tugas
  Scenario: Post create new user with null name value
    Given Post create user with null name value
    When Send request post create user
    Then Should return status code 400

  @Tugas
  Scenario: Post create new user with null job value
    Given Post create user with null name value
    When Send request post create user
    Then Should return status code 400

  


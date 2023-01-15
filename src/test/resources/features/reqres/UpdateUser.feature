  Feature: Testing Update user Reqres API

    @Latihan
    Scenario: Put update user with valid json
      Given Put update user with valid json with id 2
      When Send request put update user
      Then Should return status code 200
      And Response body name should be "Mukhlis Anshori" and job "QA"
      And Validate json schema update user

    @Tugas
    Scenario: Put update user with valid json
      Given Put update user with valid json with id 5
      When Send request put update user
      Then Should return status code 200
      And Response body name should be "Mukhlis Anshori" and job "QA"
      And Validate json schema update user

    @Tugas
    Scenario: Put update user with name null value
      Given Put update user with invalid json name null value with id 5
      When Send request put update user
      Then Should return status code 400

    @Tugas
    Scenario: Put Update user with job null value
      Given Put update user with invalid json job null value with id 5
      When Send request put update user
      Then Should return status code 400

    @Tugas
    Scenario: Put update user with invalid variable
      Given Put update user with invalid variable with id 5
      When Send request put update user
      Then Should return status code 400

    @Tugas
    Scenario: Put update user with unregistered id
      Given Put update user with invalid unregistered id with id 0
      When Send request put update user
      Then Should return status code 400



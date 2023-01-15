Feature: Testing Get Single User Reqres API ALTA QE 8
  @Tugas
  Scenario Outline: Get single user with valid parameter id reqresAPI
    Given Get single users id <id>
    When Send request get single user
    Then Should return status code 200
    And Validate json schema single user
    Examples:
      | id |
      | 2  |
      |4   |

  @Tugas
  Scenario: Get single user with unregistered parameter id reqresAPI
    Given Get single users id unregistered 12487093
    When Send request get single user
    Then Should return status code 404

  @Tugas
  Scenario Outline: Get single user with invalid id reqresAPI
    Given Get single users with invalid id "<id>"
    When Send request get single user
    Then Should return status code 404
    Examples:
      | id     |  |
      | 1bj19  |  |
      | 387jdo |  |





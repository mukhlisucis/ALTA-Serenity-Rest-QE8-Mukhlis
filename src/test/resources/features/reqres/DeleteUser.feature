Feature: Testing Delete user Reqres API
  @Latihan
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      |id  |
      |1   |
      |2   |

  @Tugas
  Scenario Outline: Delete users with user id unregistered
    Given Delete user with invalid id <id>
    When Send request delete user
    Then Should return status code 404
    Examples:
      | id   |
      | 1000 |
      | 1389 |

  @Tugas
  Scenario Outline: Delete users with invalid id user
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Should return status code 404
    Examples:
      | id  |
      | %3s |
      | o)1 |



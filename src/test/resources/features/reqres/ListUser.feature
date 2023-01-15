Feature: Testing Tugas Reqres API ALTA QE 8
  @Latihan
  Scenario Outline: Get list user with valid parameter page reqresAPI
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Validate json schema list user
    Examples:
      | page |
      |1     |
      |2     |

  @Tugas
  Scenario: Get list user with page 0
    Given Get list user with page 0
    When Send request get list user
    Then Should return status code 404

  @Tugas
  Scenario Outline: Get list user with invalid page
    Given Get list user with page "<page>"
    When Send request get list user
    Then Should return status code 404
    Examples:
      | page |
      | sd(  |
      |8jdmn |
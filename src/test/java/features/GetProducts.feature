Feature: Get all products from the API

  Scenario: Verify the get api for the products

    Given Hit the URL of get products api
    When The url is passed in the request
    Then I receive the response code as 200

  Scenario: Verify the rate of first product is correct

    Given Hit the URL of get products api
    When The url is passed in the request
    Then I verify that the rate of the first product is <FirstProductRate>
    Example:
      |FirstProductRate|
      |3.9|



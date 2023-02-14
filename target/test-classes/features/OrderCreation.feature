Feature: OrderCreation
  For Testing The Order creating in Ninja Van

  Scenario: Shipper create an order via API
    Given the shipper is registered in Ninja Van
    When shipper authenticate to ninja van System
    Then QA verifies that the HTTP authentication response code is '200'
    When shipper retrieved its access token
    And shipper send order create request and shipper provide the access token in the request header
    Then QA verifies that the HTTP order creation  response code is '200'
    And QA verifies that the HTTP response body is {“status”:”OK”}
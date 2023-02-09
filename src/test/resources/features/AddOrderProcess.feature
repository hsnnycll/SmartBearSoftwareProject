@smoke @add_order
Feature: Add Oder
  As user, we would like to be able to create new order

  Background:
    Given the user is on the login page
    And the user logged in with valid credentials, "Tester" as username and "test" as password
    And the user is on the web orders page

  Scenario: The user successfully create an order.
  This scenario tests that a user is able to successfully create an order by entering valid inputs.
    And the user navigates to order page
    When the user enters product information:
      | Product     | Quantity |
      | ScreenSaver | 10       |
    And the user click on calculate button
    Then the user should verify that total 180 is displayed
    When the user enters address information:
      | Customer Name | Street | City     | State  | Zip   |
      | TestUser      | Umut   | Istanbul | Turkey | 34000 |
    And the user enters payment information:
      | Card | Card Nr:  | Expire date (mm/yy) |
      | Visa | 123456789 | 04/25               |
    And the user click on process button
    Then the user navigates to View all orders page
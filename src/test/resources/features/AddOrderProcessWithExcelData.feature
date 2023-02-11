@excelReader
Feature: Add order with different users
  As user, we would like to be able to create new orders with different user information

  Background:
    Given the user is on the login page
    And the user logged in with valid credentials, "Tester" as username and "test" as password
    And the user is on the web orders page

  Scenario Outline: The user create an order for "<TestCase>"
    And the user navigates to order page
    And the user wants to tests the scenario "<TestCase>" by retrieving the test data from Excel Workbook : "SmartBearTestsData" Sheet : "AddOrder"
    When the user enters product information
    And the user click on calculate button
    Then the user should verify that total is displayed
    When the user enters address and payment information
    And the user click on process button
    And the user navigates to View all orders page
    Examples:
      | TestCase                             |
      | TC_001_Order_TR_Turkey_Client        |
      | TC_002_Order_UK_UnitedKingdom_Client |
      | TC_003_Order_FR_France_Client        |
      | TC_004_Order_US_UnitedState_Client   |
      | TC_005_Order_TR_Turkey_Client        |
      | TC_006_Order_AZ_Azerbaijan_Client    |




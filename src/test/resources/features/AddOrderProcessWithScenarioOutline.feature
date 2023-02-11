@smoke @add_order
Feature: Add Oder
  As user, we would like to be able to create new order

  Background:
    Given the user is on the login page
    And the user logged in with valid credentials, "Tester" as username and "test" as password
    And the user is on the web orders page

  Scenario Outline: The user successfully create an order for customer <CustomerName> from <City>
  This scenario tests that a user is able to successfully create an order by entering valid inputs.
    And the user navigates to order page
    When the user enters product information: Product "<Product>", Quantity "<Quantity>"
    And the user click on calculate button
    Then the user should verify that total <Total> is displayed
    When the user enters address information: Customer Name "<CustomerName>", Street "<Street>", City "<City>", State "<State>", Zip "<Zip>"
    And the user enters payment information: Card "<Card>", Card Number "<CardNumber>", Expire Date "<ExpireDate>"
    And the user click on process button
    And the user navigates to View all orders page
    Examples:
      | Product     | Quantity | Total | CustomerName       | Street  | City     | State     | Zip   | Card             | CardNumber | ExpireDate |
      | ScreenSaver | 2        | 40    | Sam Kran           | Croneey | Dallas   | Texas     | 469   | Visa             | 1234567891 | 01/29      |
      | FamilyAlbum | 10       | 680   | Julie Sullivan     | Three   | NYC      | NY        | 12578 | American Express | 1234567892 | 10/30      |
      | ScreenSaver | 20       | 360   | Christina Peroume  | Rouge   | Nievre   | Bourgogne | 2600  | MasterCard       | 1234567893 | 06/27      |
      | MyMoney     | 15       | 1380  | Yasmine Karkockova | Rasputy | Warsaw   | Pole      | 82133 | MasterCard       | 1234567894 | 12/28      |
      | FamilyAlbum | 2        | 160   | Umut Sahin         | Yenilik | Istanbul | Turkey    | 34000 | Visa             | 1234567895 | 08/31      |

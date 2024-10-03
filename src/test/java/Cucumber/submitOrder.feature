
@tag
Feature: Submit order from ecommerce Website

  @tag2
  Scenario Outline: Positive test of submitting Order with multiple data
    Given Logged in with username<name> and password <password>
    When I add product to cart
    And checkout and submit the order
    Then Get the confirmation message
    

    Examples: 
      | name  | password |
      | qaakramsheriff@gmail.com |Test@123 |
      | baakramsheriff@gmail.com |Test@123 |

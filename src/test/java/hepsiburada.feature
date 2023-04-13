Feature: Buy product in hepsiburada
  Scenario: Go to hepsiburada website and search product
    Given I navigate to hepsiburada page
    And I close popup
    And I type "s23" in search area
    When I click search button
    Then Verify s23 is displayed
    When I click s23
    Then I add product to the cart
    And Verify product is in the cart
    And I navigate purchase page
    And Verify shopping button

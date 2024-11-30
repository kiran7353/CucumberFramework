Feature: Search and place the order for Products

  @OffersPage
  Scenario Outline: Search Experience for the product search in both home and offers page
    Given user is on GreenCart landing page
    When user searched with shortname called <Name> and extracted actual name of product
    Then user searched for <Name> shortname in offers page
    And validate product name in offers page matches with landing Page
    Examples:
    | Name|
    | Tom |
    | Beet|
Feature: Products are searchable from the Search widget at the top center of the Shop Online landing page. 

  Scenario: A customer has landed on the Shop Online home page for LittleBird Australia.  Using the Search widget located at the top and center of the page, the customer searches for a known stocked product by exact name and it is included in the result.
    Given I start at the LittleBird Online Shopping home page
    When I search for "Uno R3 - Little Bird"
    Then I should find "LB-00300"

  Scenario: A customer has landed on the Shop Online home page for LittleBird Australia.  Using the Search widget located at the top and center of the page, the customer searches for a known stocked product by partial name and it is included in the result.
    Given I start at the LittleBird Online Shopping home page
    When I search for "Uno R3"
    Then I should find "LB-00300"

    
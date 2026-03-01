Feature: Amazon Search Functionality

  Scenario: Search for a product on Amazon
    Given user launches the browser
    And user navigates to "https://www.amazon.in"
    When user searches for "iPhone 17"
    Then search results should be displayed and prize displayed for iphone15pro
    Then user searches for "iPhone 17 air" prize printed
    
   
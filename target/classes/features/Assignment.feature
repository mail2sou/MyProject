Feature: Search top 250 movies in IMDB website
  Scenario: Search top 250 movies in IMDB website
    Given user navigates to imdb home page
    When user gets top 250 movies list
    Then user verifies and prints the same into a text file
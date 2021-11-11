#language:en
Feature: checking for the output of user information

  Scenario Outline: information output
    Given I am checking user information with the beginning of report "<start>" and the end of "<end>"
    Examples:
      | start | end |
      | 0     | -10 |
      | 0     | 1   |
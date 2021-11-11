#lenguage:en
Feature: entrance exit test from the room

  Scenario Outline: checking actions with the room
    Given I "<text>" room "<roomId>" with key "<keyId>"
    Examples:
      | text     | roomId | keyId |
      | EXIT     | 1      | 1     |
      | ENTRANCE | 1      | 1     |
      | ENTRANCE | 5      | 2     |
      | ENTRANCE | 10     | 2     |
Feature: 21-es játékban a lapok kiértékelése
  Scenario: Pont 21
    When Kezünkben lévő kártyák: "tíz","ász"
    Then A kezünkben lévő kártyák értéke 21

  Scenario: Kevesebb mint 21
    When Kezünkben lévő kártyák: "hét","nyolc"
    Then A kezünkben lévő kártyák értéke 15

  Scenario: Több mint 21
    When Kezünkben lévő kártyák: "hét","nyolc", "tíz"
    Then A kezünkben lévő kártyák értéke 25
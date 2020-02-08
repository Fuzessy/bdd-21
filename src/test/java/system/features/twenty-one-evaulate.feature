Feature: 21-es játékban a lapok kiértékelése
  Scenario: Pont 21
    When Kezünkben lévő kártyák: makk,tíz és tök,ász
    Then A kezünkben lévő kártyák értéke 21

  Scenario: Kevesebb mint 21
    When Kezünkben lévő kártyák: makk,hét és piros,nyolc
    Then A kezünkben lévő kártyák értéke 15

  Scenario: Több mint 21
    When Kezünkben lévő kártyák: makk,hét és makk,nyolc és makk,tíz
    Then A kezünkben lévő kártyák értéke 25
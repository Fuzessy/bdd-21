#Feature: 21-es játékmenet egy osztó és egy játékos
#  Scenario: Első kör
#    Given Van egy játékos és egy osztó, elkezdődik a játék
#    When A játékos kap egy lapot az osztótól
#      And Az osztó is ad magának egy lapot
#    Then A játékos rendelkezik egy lappal, melyeknek értéke biztosan kevesebb mint 21
#      And Az osztó rendelkezik egy lappal, melyeknek értéke biztosan kevesebb mint 21
#
#  Scenario: Két lépésból nyer a játékos
#    Given Van egy játékos és egy osztó, elkezdődik a játék
#    When A játékos kap egy "tíz"-t az osztótól
#      And Az osztó kap egy "király"-t
#      And A játékos kap egy "ász"-t az osztótól
#      And Az osztó kap egy lapot
#    Then A játékos nyert, mert neki 21 van
#
#  Scenario: A játékos veszít
#    Given Van egy játékos és egy osztó, elkezdődik a játék
#    When A játékos kap egy "tíz"-t az osztótól
#    And Az osztó kap egy "király"-tű
#    And A játékos kap egy "alsó"-t az osztótól
#    And Az osztó kap egy lapot
#    And A játékos folytatja a játékos
#    And Az osztó kap megnézi a kapott lapot, ami egy "hetes"
#
#    And A játékos kap egy "tíz"-t az osztótól
#    Then A játékos veszített, mert neki több mint 21 van

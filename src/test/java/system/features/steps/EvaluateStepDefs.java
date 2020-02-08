package system.features.steps;

import hu.frt.twentyone.evaluator.TwentyOneGameHandEvaluator;
import hu.frt.twentyone.evaluator.model.Card;
import hu.frt.twentyone.evaluator.model.CardColor;
import hu.frt.twentyone.evaluator.model.CardValue;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class EvaluateStepDefs {


    private List<Card> lapok;

    @Before
    public void init(){
        lapok = new ArrayList<>();
    }

    @When("Kezünkben lévő kártyák: {card} és {card}")
    public void kezünkbenLévőKártyák(Card lap1, Card lap2) {
        lapok.add(lap1);
        lapok.add(lap2);
    }

    @When("Kezünkben lévő kártyák: {card} és {card} és {card}")
    public void kezünkbenLévőKártyák(Card lap1, Card lap2, Card lap3) {
        lapok.add(lap1);
        lapok.add(lap2);
        lapok.add(lap3);
    }

    @Then("A kezünkben lévő kártyák értéke {int}")
    public void aKezünkbenLévőKártyákÉrtéke(Integer value) {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        int sum = evaluator.evaluate(lapok);
        assertTrue(value == sum);
    }

    @ParameterType("[a-z,ö,í]+,[a-z,ó,ő,á,é,ó,í]+")  // tök,tíz
    public Card card(String cardAsString){

        return new Card(
                getCardColor(cardAsString.split(",")[0]),
                getCardValue(cardAsString.split(",")[1]));
    }

    private CardValue getCardValue(String value) {
        switch (value){
            case "alsó": return CardValue.ALSO;
            case "felső": return CardValue.FELSO;
            case "király": return CardValue.KIRALY;
            case "hét": return CardValue.HET;
            case "nyolc": return CardValue.NYOLC;
            case "kilenc": return CardValue.KILENC;
            case "tíz": return CardValue.TIZ;
            case "ász": return CardValue.ASZ;
        }
        throw new ElVanRontvaException();
    }

    private CardColor getCardColor(String color) {
        switch (color){
            case "makk": return CardColor.MAKK;
            case "tök": return CardColor.TOK;
            case "piros": return CardColor.PIROS;
            case "zöld": return CardColor.ZOLD;
        }
        throw new ElVanRontvaException();
    }

}

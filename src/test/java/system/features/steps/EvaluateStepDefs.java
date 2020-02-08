package system.features.steps;

import hu.frt.twentyone.evaluator.TwentyOneGameHandEvaluator;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class EvaluateStepDefs {


    private List<String> lapok;

    @Before
    public void init(){
        lapok = new ArrayList<>();
    }

    @When("Kezünkben lévő kártyák: {string},{string}")
    public void kezünkbenLévőKártyák(String lap1, String lap2) {
        lapok.add(lap1);
        lapok.add(lap2);
    }

    @When("Kezünkben lévő kártyák: {string},{string}, {string}")
    public void kezünkbenLévőKártyák(String lap1, String lap2, String lap3) {
        lapok.add(lap1);
        lapok.add(lap2);
        lapok.add(lap3);
    }

    @Then("A kezünkben lévő kártyák értéke {int}")
    public void aKezünkbenLévőKártyákÉrtéke(Integer value) {
//        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
////        int sum = evaluator.evaluate(lapok);
////        assertTrue(value == sum);
        throw new PendingException();
    }

}

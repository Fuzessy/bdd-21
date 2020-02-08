package hu.frt.twentyone.evaluator;

import hu.frt.twentyone.evaluator.model.Card;
import hu.frt.twentyone.evaluator.model.CardColor;
import hu.frt.twentyone.evaluator.model.CardValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TwentyOneGameHandEvaluatorTest {

    @Test(expected = CardsListIsNullException.class)
    public void evaluate_nullTest() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        evaluator.evaluate(null);
    }

    @Test
    public void evaluate_emptyTest() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        assertEquals(0,evaluator.evaluate(Collections.emptyList()));
    }

    @Test
    public void evaluate_cardValueTest() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        assertEquals(2,evaluator.evaluate(createOneCardArray(CardValue.ALSO)));
        assertEquals(3,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.FELSO)))));
        assertEquals(4,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.KIRALY)))));
        assertEquals(7,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.HET)))));
        assertEquals(8,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.NYOLC)))));
        assertEquals(9,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.KILENC)))));
        assertEquals(10,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.TIZ)))));
        assertEquals(11,evaluator.evaluate(Collections.singletonList((new Card(CardColor.MAKK, CardValue.ASZ)))));
    }

    private List<Card> createOneCardArray(CardValue v) {
        return Collections.singletonList((new Card(CardColor.MAKK, v)));
    }

    @Test
    public void evaluate_notEmptyTest() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        List<Card> hand = Arrays.asList(
                new Card(CardColor.MAKK,CardValue.HET),
                new Card(CardColor.MAKK,CardValue.KIRALY));
        assertEquals(11,evaluator.evaluate(hand));
    }

    @Test
    public void evaluate_AszokTest() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        List<Card> hand = Arrays.asList(
                new Card(CardColor.MAKK,CardValue.ASZ),
                new Card(CardColor.MAKK,CardValue.ASZ));
        assertEquals(12,evaluator.evaluate(hand));
    }

    @Test
    public void evaluate_AszokTest2() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        List<Card> hand = Arrays.asList(
                new Card(CardColor.MAKK,CardValue.ASZ),
                new Card(CardColor.MAKK,CardValue.ALSO),
                new Card(CardColor.MAKK,CardValue.TIZ));
        assertEquals(13,evaluator.evaluate(hand));
    }

    @Test
    public void evaluate_AszokTest3() {
        TwentyOneGameHandEvaluator evaluator = new TwentyOneGameHandEvaluator();
        List<Card> hand = Arrays.asList(
                new Card(CardColor.MAKK,CardValue.ASZ),
                new Card(CardColor.MAKK,CardValue.ALSO),
                new Card(CardColor.MAKK,CardValue.ASZ),
                new Card(CardColor.MAKK,CardValue.ALSO),
                new Card(CardColor.MAKK,CardValue.ASZ),
                new Card(CardColor.MAKK,CardValue.ALSO),
                new Card(CardColor.MAKK,CardValue.ASZ));
        assertEquals(20,evaluator.evaluate(hand));
    }

}
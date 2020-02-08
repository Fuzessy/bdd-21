package hu.frt.twentyone.evaluator;

import hu.frt.twentyone.evaluator.model.Card;
import hu.frt.twentyone.evaluator.model.CardValue;

import java.util.Comparator;
import java.util.List;

public class TwentyOneGameHandEvaluator {
    public int evaluate(List<Card> cards) {
        validateHand(cards);
        return calculateCardsValue(cards);
    }

    private int calculateCardsValue(List<Card> cards) {
        sortCardsListByIntVlue(cards);
        int sum = 0;
        for(Card card: cards){
            sum = incrementSummaWithCardValue(sum, card);
        }
        return sum;
    }

    private void sortCardsListByIntVlue(List<Card> cards) {
        cards.sort(Comparator.comparingInt(card -> card.getValue().getIntValue()));
    }

    private int incrementSummaWithCardValue(int sum, Card card) {
        if(sum >= 11 && card.getValue() == CardValue.ASZ)
            sum += 1;
        else
            sum += card.getValue().getIntValue();
        return sum;
    }

    private void validateHand(List<Card> lapok) {
        if(lapok == null)
            throw new CardsListIsNullException();
    }
}

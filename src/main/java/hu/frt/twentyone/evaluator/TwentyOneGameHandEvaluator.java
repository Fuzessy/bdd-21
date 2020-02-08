package hu.frt.twentyone.evaluator;

import hu.frt.twentyone.evaluator.model.Card;
import hu.frt.twentyone.evaluator.model.CardValue;

import java.util.List;

public class TwentyOneGameHandEvaluator {
    public int evaluate(List<Card> lapok) {
        if(lapok == null)
            throw new CardsListIsNullException();

        int sum = 0;
        boolean hasAsz = false;
        for(Card card: lapok){
            if(sum >= 11 && card.getValue() == CardValue.ASZ) {
                sum += 1;
            }
            else if(hasAsz && card.getValue() == CardValue.ASZ){
                sum = sum - 10;
            } else if(hasAsz && card.getValue().getIntValue() + sum > 21 ){
                sum = sum - 10 + card.getValue().getIntValue();
            }else{
                sum += card.getValue().getIntValue();
            }
            if(card.getValue() == CardValue.ASZ){
                hasAsz = true;
            }
        }
        return sum;
    }
}

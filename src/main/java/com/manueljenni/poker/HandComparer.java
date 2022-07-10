package com.manueljenni.poker;

public class HandComparer {

    public Hand getWinningHand(Hand hand1, Hand hand2) {

        // Evaluate type of hands
        HandEvaluator handEvaluator = new HandEvaluator();

        hand1.setType(handEvaluator.getType(hand1));
        hand2.setType(handEvaluator.getType(hand2));

        // Get "value" of hand
        // (numeric value assigned to each type)
        var handValue1 = hand1.getType().getValue();
        var handValue2 = hand1.getType().getValue();

        // Compare values
        if (handValue1 > handValue2) {
            return hand1;
        } else if (handValue1 < handValue2) {
            return hand2;
        } else {
            // Handle same values
            return hand1;
        }
    }
}

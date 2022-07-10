package com.manueljenni.poker;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

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

        // Get hand types
        var handType1 = hand1.getType();
        var handType2 = hand2.getType();

        // Get card values
        var values1 = handEvaluator.getValues(hand1.getCards());
        var values2 = handEvaluator.getValues(hand2.getCards());

        // Scores of both hands
        // (used when same hand type)
        int score1;
        int score2;

        // Compare values
        if (handValue1 > handValue2) {
            return hand1;
        } else if (handValue1 < handValue2) {
            return hand2;
        } else {
            // Handle same values
            if (handType1 == Type.STRAIGHT_FLUSH) {
                // Highest card in each hand's win
                score1 = values1.stream().max(Comparator.naturalOrder()).orElse(0);
                score2 = values2.stream().max(Comparator.naturalOrder()).orElse(0);

                // Compare all values in hands,
                // starting from highest
                for (int i = 0; i < values1.size(); i++) {
                    if (values1.get(i) > values2.get(i)) {
                        return hand1;
                    }
                }
                return hand2;
            } else if (handType1 == Type.FOUR_A_KIND) {
                // Determine score of first hand
                var distinctValues1 = values1.stream()
                        .distinct().toList();

                if (Collections.frequency(distinctValues1, distinctValues1.get(0)) == 4) {
                    score1 = values1.stream().filter(score -> values1.contains(distinctValues1.get(0)))
                            .mapToInt(Integer::intValue).sum();
                } else {
                    score1 = values1.stream().filter(score -> values1.contains(distinctValues1.get(1)))
                            .mapToInt(Integer::intValue).sum();
                }

                // Determine score of second hand
                var distinctValues2 = values1.stream()
                        .distinct().toList();

                if (Collections.frequency(distinctValues1, distinctValues2.get(0)) == 4) {
                    score2 = values2.stream().filter(score -> values2.contains(distinctValues1.get(0)))
                            .mapToInt(Integer::intValue).sum();
                } else {
                    score2 = values2.stream().filter(score -> values2.contains(distinctValues1.get(1)))
                            .mapToInt(Integer::intValue).sum();
                }

                // Compare the two scores
                if (score1 > score2) return hand1;
                else return hand2;
            }
            return hand1;
        }
    }
}

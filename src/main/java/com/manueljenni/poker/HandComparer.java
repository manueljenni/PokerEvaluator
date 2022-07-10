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
        var handValue2 = hand2.getType().getValue();

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
            if (handType1 == Type.STRAIGHT_FLUSH || handType1 == Type.FLUSH) {

                // Compare all values in hands,
                // starting from highest
                for (int i = 0; i < values1.size(); i++) {
                    if (values1.get(i) > values2.get(i)) {
                        return hand1;
                    }
                }
                return hand2;

            } else if (handType1 == Type.FOUR_A_KIND) {

                // Find scores that occur four times
                // and get sum
                score1 = values1.stream()
                        .filter(x -> Collections.frequency(values1, x) == 4)
                        .mapToInt(Integer::intValue).sum();

                score2 = values2.stream()
                        .filter(x -> Collections.frequency(values2, x) == 4)
                        .mapToInt(Integer::intValue).sum();

                // Compare the two scores
                if (score1 > score2) return hand1;
                else return hand2;

            } else if (handType1 == Type.FULL_HOUSE || handType1 == Type.THREE_A_KIND) {

                // Find scores that occur three times
                // and get sum
                score1 = values1.stream()
                        .filter(x -> Collections.frequency(values1, x) == 3)
                        .mapToInt(Integer::intValue).sum();

                score2 = values2.stream()
                        .filter(x -> Collections.frequency(values2, x) == 3)
                        .mapToInt(Integer::intValue).sum();

                // Compare the two scores
                if (score1 > score2) return hand1;
                else return hand2;

            } else if (handType1 == Type.STRAIGHT) {

                // Compare the highest cards
                if (values1.get(4) > values2.get(4)) {
                    return hand1;
                } else if (values1.get(4) < values2.get(4)) {
                    return hand2;
                } else {
                    // If two highest cards are the same
                    // no winner can be chosen according to the
                    // given rules
                    throw new RuntimeException("Draw. :(");
                }

            } else if (handType1 == Type.TWO_PAIRS) {

                // Find scores that occur twice
                var higherPair1 = values1.stream()
                        .filter(x -> Collections.frequency(values1, x) == 2)
                        .mapToInt(Integer::intValue).max().orElse(0);

                var lowerPair1 = values1.stream()
                        .filter(x -> Collections.frequency(values1, x) == 2)
                        .mapToInt(Integer::intValue).min().orElse(0);

                var singleValue1 = values1.stream()
                        .filter(x -> Collections.frequency(values1, x) == 1)
                        .mapToInt(Integer::intValue).min().orElse(0);

                var higherPair2 = values2.stream()
                        .filter(x -> Collections.frequency(values2, x) == 2)
                        .mapToInt(Integer::intValue).min().orElse(0);

                var lowerPair2 = values1.stream()
                        .filter(x -> Collections.frequency(values2, x) == 2)
                        .mapToInt(Integer::intValue).min().orElse(0);

                var singleValue2 = values1.stream()
                        .filter(x -> Collections.frequency(values2, x) == 1)
                        .mapToInt(Integer::intValue).min().orElse(0);

                if (higherPair1 > higherPair2) {
                    return hand1;
                } else if (higherPair1 < higherPair2) {
                    return hand2;
                } else {
                    if (lowerPair1 > lowerPair2) {
                        return hand1;
                    } else if (lowerPair1 < lowerPair2) {
                        return hand2;
                    } else {
                        if (singleValue1 > singleValue2) {
                            return hand1;
                        } else if (singleValue1 < singleValue2) {
                            return hand2;
                        } else {
                            throw new RuntimeException("Draw. :(");
                        }
                    }
                }

            }
            return hand1;
        }
    }
}

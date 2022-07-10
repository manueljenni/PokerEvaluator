package com.manueljenni.poker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HandEvaluator {

    // This will determine what kind of
    // type a given hand is

    public Type getType(Hand hand) {

        List<Card> cards = hand.getCards();

        // Throw exception if hand is invalid
        // (must contain exactly five cards)
        if (cards.size() == 5) {

            // Hands are evaluated from highest
            // to lowest (most "powerful" to least)
            // because "lower" types might be contained
            // in "higher" ones (e.g. Flush ∈ Straight Flush)
            if (isStraightFlush(cards)) {
                return Type.STRAIGHT_FLUSH;
            } else if (isFourAKind(cards)) {
                return Type.FOUR_A_KIND;
            } else if (isFullHouse(cards)) {
                return Type.FULL_HOUSE;
            } else if (isFlush(cards)) {
                return Type.FLUSH;
            } else if (isStraight(cards)) {
                return Type.STRAIGHT;
            } else if (isThreeAKind(cards)) {
                return Type.THREE_A_KIND;
            } else if (isTwoPairs(cards)) {
                return Type.TWO_PAIRS;
            } else if (isPair(cards)) {
                return Type.PAIR;
            } else return Type.HIGH_CARD;

        } else {
            throw new RuntimeException(String.format(
                    "A valid hand must consist of exactly 5 cards. You provided %s cards.",
                    cards.size()
            ));
        }
    }

    // Cards are of same suit
    // and with consecutive values
    private Boolean isStraightFlush(List<Card> cards) {
        if (isStraight(cards) && isFlush(cards)) return true;
        else return false;
    }

    // Four cards of the same value
    private Boolean isFourAKind(List<Card> cards) {
        var values = getValues(cards);

        var distinctValues = values.stream()
                .distinct().toList();

        // If four of a kind, only two
        // different card types can be present
        if (distinctValues.size() == 2) {

            // Because of sorting, either first
            // or last card must be present four times
            var frequencyOfFirstItem = Collections.frequency(values, distinctValues.get(0));
            var frequencyOfLastItem = Collections.frequency(values, distinctValues.get(1));

            return frequencyOfFirstItem == 4 || frequencyOfLastItem == 4;
        } else return false;
    }

    // Three cards of the same value
    // and remaining cards being a pair
    private Boolean isFullHouse(List<Card> cards) {
        var values = getValues(cards);

        var distinctValues = values.stream()
                .distinct().toList();

        // If full house, two
        // different card types must be present
        if (distinctValues.size() == 2) {

            // Sublist of cards with same rank
            // (e.g. [5, 5, 5] or [A, A])

            var sublist1 = cards.stream()
                    .filter(card -> card.getRank().getValue()
                            == distinctValues.get(0)
                    ).toList();
            var sublist2 = cards.stream()
                    .filter(card -> card.getRank().getValue()
                            == distinctValues.get(1)
                    ).toList();

            // Check if combination is full house
            return (sublist1.size() == 2 && sublist2.size() == 3) || (sublist1.size() == 3 && sublist2.size() == 2);

        } else return false;
    }

    // Five cards of the same suit
    private Boolean isFlush(List<Card> cards) {
        if (isSameSuit(cards)) return true;
        else return false;
    }

    // Five cards with consecutive values
    private Boolean isStraight(List<Card> cards) {
        var values = getValues(cards);

        // Loop through all cards (except the last) and check
        // if they increase in steps of one
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) != (values.get(i + 1) - 1)) {
                return false;
            }
        }

        // Manually check the highest card
        // to avoid IndexOutOfBounds due to i + 1
        if (values.get(4) != (values.get(3) + 1)) {
            return false;
        }

        // If this part is reached, then all cards
        // increase in steps of one
        return true;
    }

    // Three cards of the same value
    private Boolean isThreeAKind(List<Card> cards) {
        var values = getValues(cards);

        var distinctValues = values.stream()
                .distinct().toList();

        // If three of a kind, max. 3
        // different card types can be present
        if (distinctValues.size() < 4) {

            // One of the "distinct" cards
            // must be present three times
            var frequency1 = Collections.frequency(values, distinctValues.get(0));
            var frequency2 = Collections.frequency(values, distinctValues.get(1));
            var frequency3 = Collections.frequency(values, distinctValues.get(2));

            return frequency1 == 3 || frequency2 == 3 || frequency3 == 3;
        } else return false;
    }

    // Two different pairs
    private Boolean isTwoPairs(List<Card> cards) {
        var values = getValues(cards);

        var distinctValues = values.stream()
                .distinct().toList();

        // If there are two pairs, there can
        // only be three different kinds of cards
        if (distinctValues.size() == 3) {

            // One of the "distinct" cards
            // must be present two times
            var frequency1 = Collections.frequency(values, distinctValues.get(0));
            var frequency2 = Collections.frequency(values, distinctValues.get(1));
            var frequency3 = Collections.frequency(values, distinctValues.get(2));

            return frequency1 == 2 || frequency2 == 2 || frequency3 == 2;
        } else return false;
    }

    // Two cards with same value
    private Boolean isPair(List<Card> cards) {
        var values = getValues(cards);

        var distinctValues = values.stream()
                .distinct().toList();

        // If there are two pairs, there will
        // be four different kinds of cards
        if (distinctValues.size() == 4) {

            // One of the "distinct" cards
            // must be present two times
            var frequency1 = Collections.frequency(values, distinctValues.get(0));
            var frequency2 = Collections.frequency(values, distinctValues.get(1));
            var frequency3 = Collections.frequency(values, distinctValues.get(2));
            var frequency4 = Collections.frequency(values, distinctValues.get(3));

            System.out.println(values);
            System.out.println(distinctValues);

            return frequency1 == 2 || frequency2 == 2 || frequency3 == 2 || frequency4 == 2;
        } else return false;
    }

    // Checks if all given cards are
    // of the same suit
    private Boolean isSameSuit(List<Card> cards) {
        List<String> suits = getSuits(cards);

        return suits.stream()
                .distinct()
                .count() <= 1;
    }

    // Checks if all given cards are
    // of the same value
    private Boolean isSameValue(List<Card> cards) {
        List<Integer> values = getValues(cards);

        return values.stream()
                .distinct()
                .count() <= 1;
    }

    // Returns all numeric values of the cards
    // (sorted from lowest to highest)
    public List<Integer> getValues(List<Card> cards) {
        return cards.stream()
                .map(card -> {
                    return card.getRank().getValue();
                })
                .sorted()
                .collect(Collectors.toList());
    }

    // Returns all ranks of the cards as a list of strings
    private List<String> getRanks(List<Card> cards) {
        return Collections.emptyList();
    }

    // Returns all suits of the cards as a list of strings
    // (sorted alphabetically)
    private List<String> getSuits(List<Card> cards) {
        return cards.stream()
                .map(card -> {
                    return card.getSuit().toString();
                })
                .sorted()
                .collect(Collectors.toList());
    }
}

package com.manueljenni.poker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Evaluator {

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
        return false;
    }

    // Three cards of the same value
    // and remaining cards being a pair
    private Boolean isFullHouse(List<Card> cards) {
        return false;
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
            if (values.get(i) != (values.get(i+1) -1)) {
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
        return false;
    }

    // Two different pairs
    private Boolean isTwoPairs(List<Card> cards) {
        return false;
    }

    // Two cards with same value
    private Boolean isPair(List<Card> cards) {
        return false;
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
        return false;
    }

    // Returns all numeric values of the cards
    // (sorted from lowest to highest)
    private List<Integer> getValues(List<Card> cards) {
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

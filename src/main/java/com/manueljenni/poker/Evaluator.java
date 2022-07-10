package com.manueljenni.poker;

import java.util.Collections;
import java.util.List;

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
        return false;
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
        return false;
    }

    // Five cards with consecutive values
    private Boolean isStraight(List<Card> cards) {
        return false;
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
        return false;
    }

    // Checks if all given cards are
    // of the same value
    private Boolean isSameValue(List<Card> cards) {
        return false;
    }

    // Returns all numeric values of the cards
    private List<Integer> getValues(List<Card> cards) {
        return Collections.emptyList();
    }

    // Returns all ranks of the cards as a list of strings
    private List<String> getRanks(List<Card> cards) {
        return Collections.emptyList();
    }

    // Returns all suits of the cards as a list of strings
    private List<String> getSuits(List<Card> cards) {
        return Collections.emptyList();
    }
}

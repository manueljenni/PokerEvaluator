package com.manueljenni.poker;

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
                    "A valid hand must consist of exactly 5 cards. You entered %size cards.",
                    cards.size()
            ));
        }
    }

    // Cards are of same suit
    // and with consecutive values
    public Boolean isStraightFlush(List<Card> cards) {

    }

    // Four cards of the same value
    public Boolean isFourAKind(List<Card> cards) {

    }

    // Three cards of the same value
    // and remaining cards being a pair
    public Boolean isFullHouse(List<Card> cards) {

    }

    // Five cards of the same suit
    public Boolean isFlush(List<Card> cards) {

    }

    // Five cards with consecutive values
    public Boolean isStraight(List<Card> cards) {

    }

    // Three cards of the same value
    public Boolean isThreeAKind(List<Card> cards) {

    }

    // Two different pairs
    public Boolean isTwoPairs(List<Card> cards) {

    }

    // Two cards with same value
    public Boolean isPair(List<Card> cards) {

    }

    // Checks if all given cards are
    // of the same suit
    public Boolean isSameSuit(List<Card> cards) {

    }
}

package com.manueljenni.poker;

import java.util.List;

public class App {
    public static void main(String[] args) {

        /*
            This is just an example of how cards, hands etc. work.
            All the tests demonstrating the solution
            can be found in src/test/java/com.manueljenni.poker/*
         */

        HandComparer handComparer = new HandComparer();

        Card card1 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_3)
                .suit(Suit.C)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_7)
                .suit(Suit.C)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_Q)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_4)
                .suit(Suit.S)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_3)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_4)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_5)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card6, card7, card8, card9, card10))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);
        String winningHandText;

        if (winningHand == hand1) {
            winningHandText = "Hand 1";
        } else winningHandText = "Hand 2";

        System.out.printf("Winning hand: %s%n", winningHandText);

    }
}

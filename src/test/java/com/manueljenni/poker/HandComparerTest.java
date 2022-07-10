package com.manueljenni.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparerTest {

    HandComparer handComparer = new HandComparer();

    @Test
    void getWinningHand__differentTypes() {
        Card card1 = Card.builder()
                .rank(Rank.RANK_4)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_6)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.C)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_T)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_T)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_Q)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);
        assertEquals(hand1, winningHand);
    }

    @Test
    void getWinningHand__FourAKind() {
        Card card1 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.C)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card6, card7, card8, card9, card10))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);
        assertEquals(hand2, winningHand);
    }

    @Test
    void getWinningHand__FullHouse() {
        Card card1 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.C)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_6)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_6)
                .suit(Suit.D)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_4)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_4)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card6, card7, card8, card9, card10))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);
        assertEquals(hand2, winningHand);
    }

    @Test
    void getWinningHand__Straight() {
        Card card1 = Card.builder()
                .rank(Rank.RANK_7)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.C)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_T)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.D)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_5)
                .suit(Suit.C)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_6)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_7)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card6, card7, card8, card9, card10))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);

        assertEquals(hand1, winningHand);
    }

    @Test
    void getWinningHand__Flush() {
        Card card1 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.D)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_5)
                .suit(Suit.D)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_3)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card6, card7, card8, card9, card10))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);

        assertEquals(hand1, winningHand);
    }

    @Test
    void getWinningHand__ThreeAKind() {
        Card card1 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_2)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.D)
                .build();

        Hand hand1 = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        Card card6 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card7 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card8 = Card.builder()
                .rank(Rank.RANK_3)
                .suit(Suit.D)
                .build();

        Card card9 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card10 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Hand hand2 = Hand.builder()
                .cards(List.of(card6, card7, card8, card9, card10))
                .build();

        var winningHand = handComparer.getWinningHand(hand1, hand2);

        assertEquals(hand2, winningHand);
    }
}

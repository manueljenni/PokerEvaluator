package com.manueljenni.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandEvaluatorTest {

    HandEvaluator handEvaluator = new HandEvaluator();

    @Test
    // Checks that only valid hands (5 cards) are processed
    void getType__checkError() {

        Card card = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.H)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card))
                .build();

        Exception exception = assertThrows(RuntimeException.class, () -> {
                    hand.setType(handEvaluator.getType(hand));
                }
        );

        assertEquals("A valid hand must consist of exactly 5 cards. You provided 1 cards.",
                exception.getMessage());
    }

    @Test
    void getType__isStraightFlush() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_T)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.D)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_Q)
                .suit(Suit.D)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.STRAIGHT_FLUSH, hand.getType());
    }

    @Test
    void getType__isFourAKind() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.S)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.FOUR_A_KIND, hand.getType());
    }

    @Test
    void getType__isFullHouse() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.S)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.D)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.FULL_HOUSE, hand.getType());
    }

    @Test
    void getType__isFlush() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_4)
                .suit(Suit.H)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_6)
                .suit(Suit.H)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.H)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_T)
                .suit(Suit.H)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_K)
                .suit(Suit.H)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.FLUSH, hand.getType());
    }

    @Test
    void getType__isStraight() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.H)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.D)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_T)
                .suit(Suit.H)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.H)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_Q)
                .suit(Suit.S)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.STRAIGHT, hand.getType());
    }

    @Test
    void getType__isThreeAKind() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_J)
                .suit(Suit.S)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.THREE_A_KIND, hand.getType());
    }

    @Test
    void getType__isTwoPairs() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.S)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_Q)
                .suit(Suit.D)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.TWO_PAIRS, hand.getType());
    }

    @Test
    void getType__isPair() {

        Card card1 = Card.builder()
                .rank(Rank.RANK_8)
                .suit(Suit.D)
                .build();

        Card card2 = Card.builder()
                .rank(Rank.RANK_9)
                .suit(Suit.S)
                .build();

        Card card3 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.D)
                .build();

        Card card4 = Card.builder()
                .rank(Rank.RANK_A)
                .suit(Suit.S)
                .build();

        Card card5 = Card.builder()
                .rank(Rank.RANK_Q)
                .suit(Suit.D)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(handEvaluator.getType(hand));

        assertEquals(Type.PAIR, hand.getType());
    }
}

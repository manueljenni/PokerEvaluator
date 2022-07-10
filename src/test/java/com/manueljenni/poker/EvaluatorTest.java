package com.manueljenni.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EvaluatorTest {

    Evaluator evaluator = new Evaluator();

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
                    hand.setType(evaluator.getType(hand));
                }
        );

        assertEquals("A valid hand must consist of exactly 5 cards. You provided 1 cards.",
                exception.getMessage());
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
                .rank(Rank.RANK_A)
                .suit(Suit.S)
                .build();

        Hand hand = Hand.builder()
                .cards(List.of(card1, card2, card3, card4, card5))
                .build();

        hand.setType(evaluator.getType(hand));

        assertEquals(Type.STRAIGHT, hand.getType());

    }
}

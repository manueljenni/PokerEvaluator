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
}

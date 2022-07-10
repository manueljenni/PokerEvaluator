package com.manueljenni.poker;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Hand {

    // Consists of a list of cards
    // (5 for a "complete" hand)
    private List<Card> cards;

    // And a type
    // (As defined by poker rules)
    private Type type;
}

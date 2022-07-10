package com.manueljenni.poker;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Card {

    // Suit of the card
    // (Clubs, Diamonds, Hearts, Spades)
    private Suit suit;

    // Rank of the card
    // (1-10, J,Q,K,A)
    private Rank rank;
}

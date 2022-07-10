package com.manueljenni.poker;

public enum Type {

    // Type of poker hand
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_A_KIND(8),
    STRAIGHT_FLUSH(9);

    // Numeric value (1-9) assigned to the type
    // used for comparisons
    private int value;

    Type(int value) {
        this.value = value;
    }
}

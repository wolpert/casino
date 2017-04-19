package com.codeheadsystems.casino.cards;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Card {

    @Getter private final Suit suit;
    @Getter private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}

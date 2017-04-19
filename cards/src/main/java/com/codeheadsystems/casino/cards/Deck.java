package com.codeheadsystems.casino.cards;

/**
 * Purpose: Represents a deck of cards
 * <p>
 * top card is at position zero.
 */
public class Deck extends CardHolder {

    public static Deck standardDeck() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.addCard(new Card(suit, rank));
            }
        }
        return deck;
    }


}

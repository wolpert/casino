package com.codeheadsystems.casino.cards;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;

import static junit.framework.TestCase.*;

public class DeckTest {

    @Test
    public void testStandardDeck() {
        Deck deck = Deck.standardDeck();
        assertEquals(52, deck.cardsInDeck());
        HashSet<Card> set = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            Optional<Card> card = deck.topCard();
            assertTrue(card.isPresent());
            assertFalse(set.contains(card.get()));
            set.add(card.get());
        }
        assertFalse(deck.topCard().isPresent());
    }

    @Test
    public void testNotShuffle() {
        Deck deck1 = Deck.standardDeck();
        Deck deck2 = Deck.standardDeck();
        for (int i = 0; i < 52; i++) {
            Card card1 = deck1.topCard().get();
            Card card2 = deck2.topCard().get();
            assertEquals(card1, card2);
        }
    }

    @Test
    public void testShuffle() {
        Deck deck1 = Deck.standardDeck();
        Deck deck2 = Deck.standardDeck();
        deck1.shuffle();
        deck2.shuffle(new Random());
        int numberTheSame = 0;
        for (int i = 0; i < 52; i++) {
            Card card1 = deck1.topCard().get();
            Card card2 = deck2.topCard().get();
            if (card1.equals(card2)) {
                numberTheSame++;
            }
        }
        assertTrue(numberTheSame < 25); // really should be true
    }

    @Test
    public void testBigDeck() {
        Deck deck1 = Deck.standardDeck();
        Deck deck2 = Deck.standardDeck();
        deck1.addCards(deck2);
        assertEquals(104, deck1.cardsInDeck());
        HashMap<Card, Integer> map = new HashMap<>();
        while (deck1.cardsInDeck() > 0) {
            Card card = deck1.topCard().get();
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }
        map.values().forEach(i -> assertEquals(2, i.intValue()));
    }
}

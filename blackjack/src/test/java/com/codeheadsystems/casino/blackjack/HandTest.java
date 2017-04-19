package com.codeheadsystems.casino.blackjack;

import com.codeheadsystems.casino.cards.Card;
import com.codeheadsystems.casino.cards.Rank;
import com.codeheadsystems.casino.cards.Suit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Purpose:
 */
public class HandTest {

    @Test
    public void testValue() {
        assertEquals(12, getHand(new Rank[]{Rank.EIGHT, Rank.FOUR}).value());
        assertEquals(22, getHand(new Rank[]{Rank.EIGHT, Rank.FOUR, Rank.KING}).value());
        assertEquals(13, getHand(new Rank[]{Rank.EIGHT, Rank.FOUR, Rank.ACE}).value());
        assertEquals(12, getHand(new Rank[]{Rank.EIGHT, Rank.THREE, Rank.ACE}).value());
        assertEquals(21, getHand(new Rank[]{Rank.EIGHT, Rank.TWO, Rank.ACE}).value());
        assertEquals(20, getHand(new Rank[]{Rank.EIGHT, Rank.ACE, Rank.ACE}).value());
        assertEquals(21, getHand(new Rank[]{Rank.EIGHT, Rank.ACE, Rank.ACE, Rank.ACE}).value());
    }

    @Test
    public void testRanks() {
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.ACE)) {
                assertEquals(11, getHand(new Rank[]{rank}).value());
            } else {
                assertEquals(rank.getValue(), getHand(new Rank[]{rank}).value());
            }
        }
    }

    private Hand getHand(Rank[] ranks) {
        Hand hand = new Hand();
        for (Rank rank : ranks) {
            Card card = new Card(Suit.CLUB, rank);
            hand.addCard(card);
        }
        return hand;
    }

}

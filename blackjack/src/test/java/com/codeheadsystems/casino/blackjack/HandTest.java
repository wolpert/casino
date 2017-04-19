package com.codeheadsystems.casino.blackjack;

import com.codeheadsystems.casino.cards.Card;
import com.codeheadsystems.casino.cards.Rank;
import com.codeheadsystems.casino.cards.Suit;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Purpose:
 */
public class HandTest {

    @Test
    public void testValue() {
        assertEquals(12, getHand(new Rank[]{Rank.EIGHT, Rank.FOUR}).handValue());
        assertEquals(22, getHand(new Rank[]{Rank.EIGHT, Rank.FOUR, Rank.KING}).handValue());
        assertEquals(13, getHand(new Rank[]{Rank.EIGHT, Rank.FOUR, Rank.ACE}).handValue());
        assertEquals(12, getHand(new Rank[]{Rank.EIGHT, Rank.THREE, Rank.ACE}).handValue());
        assertEquals(21, getHand(new Rank[]{Rank.EIGHT, Rank.TWO, Rank.ACE}).handValue());
        assertEquals(20, getHand(new Rank[]{Rank.EIGHT, Rank.ACE, Rank.ACE}).handValue());
        assertEquals(21, getHand(new Rank[]{Rank.EIGHT, Rank.ACE, Rank.ACE, Rank.ACE}).handValue());
    }

    @Test
    public void testRanks() {
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.ACE)) {
                assertEquals(11, getHand(new Rank[]{rank}).handValue());
            } else {
                assertEquals(rank.getValue(), getHand(new Rank[]{rank}).handValue());
            }
        }
    }

    @Test
    public void canSplit() {
        Wallet wallet = new Wallet(100);
        assertTrue(getHand(new Rank[]{Rank.ACE, Rank.ACE}).canSplit(wallet));
        assertTrue(getHand(new Rank[]{Rank.EIGHT, Rank.EIGHT}).canSplit(wallet));

        assertFalse(getHand(new Rank[]{Rank.ACE, Rank.TWO}).canSplit(wallet));
        assertFalse(getHand(new Rank[]{Rank.KING, Rank.JACK}).canSplit(wallet));

        // out of money
        wallet = new Wallet(10.0);
        assertFalse(getHand(new Rank[]{Rank.ACE, Rank.ACE}).canSplit(wallet));
        assertFalse(getHand(new Rank[]{Rank.EIGHT, Rank.EIGHT}).canSplit(wallet));
    }

    private Hand getHand(Rank[] ranks) {
        Hand hand = new Hand(50.0);
        for (Rank rank : ranks) {
            Card card = new Card(Suit.CLUB, rank);
            hand.addCard(card);
        }
        return hand;
    }
}

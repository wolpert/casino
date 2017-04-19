package com.codeheadsystems.casino.blackjack;

import com.codeheadsystems.casino.cards.CardHolder;
import com.codeheadsystems.casino.cards.Rank;

/**
 * Purpose:
 */
public class Hand extends CardHolder {

    public static final int MAX_VALUE = 21;

    public int value() {
        int value = getCards().stream().mapToInt(card -> card.getRank().getValue()).sum();
        long aces = getCards().stream().filter(card -> card.getRank().equals(Rank.ACE)).count();
        while (aces > 0 && (value + 10) <= MAX_VALUE) {
            aces--;
            value += 10;
        }
        return value;
    }
}

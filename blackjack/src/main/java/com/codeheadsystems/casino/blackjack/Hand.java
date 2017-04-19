package com.codeheadsystems.casino.blackjack;

import com.codeheadsystems.casino.cards.CardHolder;
import com.codeheadsystems.casino.cards.Rank;
import lombok.ToString;

/**
 * Purpose:
 */
@ToString
public class Hand extends CardHolder {

    public static final int MAX_VALUE = 21;

    private double bet;

    public Hand(final double bet) {
        this.bet = bet;
    }

    public int handValue() {
        int value = getCards().stream().mapToInt(card -> card.getRank().getValue()).sum();
        long aces = getCards().stream().filter(card -> card.getRank().equals(Rank.ACE)).count();
        while (aces > 0 && (value + 10) <= MAX_VALUE) {
            aces--;
            value += 10;
        }
        return value;
    }

    public boolean canSplit(Wallet wallet) {
        return (wallet.getCash() >= bet &&
                cardsInDeck() == 2 &&
                getCards().get(0).getRank().equals(getCards().get(1).getRank()));
    }
}

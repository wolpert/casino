package com.codeheadsystems.casino.blackjack;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Wallet {

    @Getter
    private double cash;

    public Wallet(double cash) {
        this.cash = cash;
    }

    public Hand newBet(double amount) throws OutOfCashException {
        if (cash >= amount) {
            Hand hand = new Hand(amount);
            cash -= amount;
            return hand;
        } else {
            throw new OutOfCashException();
        }
    }

}

package com.codeheadsystems.casino.blackjack;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.UUID;

@ToString
public class Player {

    @Getter final String id;
    @Getter final private Wallet wallet;
    private ArrayList<Hand> hands = new ArrayList<>();

    public Player(Wallet wallet) {
        this(UUID.randomUUID().toString(), wallet);
    }

    public Player(String id, Wallet wallet) {
        this.id = id;
        this.wallet = wallet;
    }

}

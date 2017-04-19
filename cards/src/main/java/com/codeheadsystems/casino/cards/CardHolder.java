package com.codeheadsystems.casino.cards;

import lombok.ToString;

import java.util.*;

@ToString
public abstract class CardHolder {

    private ArrayList<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public Optional<Card> topCard() {
        return (cards.size() > 0 ? Optional.ofNullable(cards.remove(0)) : Optional.empty());
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCards(CardHolder cardHolder) {
        cards.addAll(cardHolder.getCards());
    }

    public void addCards(Card[] cardArray){
        Collections.addAll(cards, cardArray);
    }

    public int cardsInDeck() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void shuffle(Random random) {
        Collections.shuffle(cards, random);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg777.card.game;
/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards{
    private int size;
    private Card[] cards;

    public GroupOfCards() {
        this.size = 52;
        this.cards = new Card[0];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Card[] getCards() {
        return cards;
    }

    public void shuffle() {
        ArrayList<Card> cardList = new ArrayList<>();
        Collections.addAll(cardList, cards);
        Collections.shuffle(cardList);
        cards = cardList.toArray(new Card[0]);
    }

    public void initializeDeck() {
        ArrayList<Card> cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardList.add(new Card(rank, suit) {});
            }
        }
        cards = cardList.toArray(new Card[0]);
    }

    public Card drawCard() {
        if (cards.length == 0) return null;
        Card top = cards[0];
        Card[] newCards = new Card[cards.length - 1];
        System.arraycopy(cards, 1, newCards, 0, newCards.length);
        cards = newCards;
        return top;
    }
}

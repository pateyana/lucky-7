/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg777.card.game;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
import java.util.ArrayList;

public class Player {
    private String name;
    private Card[] hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Card[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        ArrayList<Card> handList = new ArrayList<>();
        for (Card c : hand) {
            handList.add(c);
        }
        return handList;
    }

    public void addCard(Card card) {
        Card[] newHand = new Card[hand.length + 1];
        System.arraycopy(hand, 0, newHand, 0, hand.length);
        newHand[hand.length] = card;
        hand = newHand;
    }

    public void removeCard(Card card) {
        ArrayList<Card> list = new ArrayList<>();
        for (Card c : hand) {
            if (!c.equals(card)) {
                list.add(c);
            }
        }
        hand = list.toArray(new Card[0]);
    }

    public void showHand() {
        for (int i = 0; i < hand.length; i++) {
            System.out.println(i + ": " + hand[i]);
        }
    }

    public boolean playCard(Card card) {
        for (Card c : hand) {
            if (c.equals(card)) {
                removeCard(card);
                return true;
            }
        }
        return false;
    }
}
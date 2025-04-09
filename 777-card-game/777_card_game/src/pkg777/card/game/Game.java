/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg777.card.game;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players;
    private GroupOfCards deck;
    private Card[] discardPile;
    private int currentPlayerIndex;

    public Game(List<Player> players) {
        this.players = players.toArray(new Player[0]);
        this.deck = new GroupOfCards();
        this.discardPile = new Card[0];
        this.currentPlayerIndex = 0;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players.toArray(new Player[0]);
    }

    public Player[] getPlayers() {
        return players;
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    public Card getTopDiscard() {
        if (discardPile.length == 0) return null;
        return discardPile[discardPile.length - 1];
    }

    public String getName() {
        return "777 Card Game";
    }

    public void startGame() {
        deck.initializeDeck();
        deck.shuffle();
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(deck.drawCard());
            }
        }
        discardPile = new Card[]{deck.drawCard()};
    }

    public void playTurn(Player player, Card cardToPlay) {
        if (isPlayable(cardToPlay)) {
            player.playCard(cardToPlay);
            addToDiscardPile(cardToPlay);
            System.out.println(player.getName() + " played: " + cardToPlay);
        } else {
            System.out.println("Card not playable. Drawing from deck...");
            player.addCard(deck.drawCard());
        }
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public boolean isPlayable(Card card) {
        Card topCard = getTopDiscard();
        return card.getRank() == topCard.getRank() || card.getSuit() == topCard.getSuit();
    }

    private void addToDiscardPile(Card card) {
        Card[] newDiscardPile = new Card[discardPile.length + 1];
        System.arraycopy(discardPile, 0, newDiscardPile, 0, discardPile.length);
        newDiscardPile[discardPile.length] = card;
        discardPile = newDiscardPile;
    }

    public boolean checkForWinner() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                System.out.println(player.getName() + " wins the game!");
                return true;
            }
        }
        return false;
    }
}



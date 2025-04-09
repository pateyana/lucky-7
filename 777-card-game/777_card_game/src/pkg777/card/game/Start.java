/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg777.card.game;

/**
 *
 * @author Yana
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("Enter number of players: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter name of Player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        Game game = new Game(players);
        game.startGame();

        boolean gameOver = false;
        while (!gameOver) {
            Player current = game.getCurrentPlayer();
            System.out.println("\n" + current.getName() + "'s turn");
            System.out.println("Top of discard pile: " + game.getTopDiscard());
            current.showHand();

            System.out.print("Choose a card index to play or -1 to draw: ");
            int index = scanner.nextInt();

            if (index >= 0 && index < current.getHand().size()) {
                Card selected = current.getHand().get(index);
                game.playTurn(current, selected);
            } else {
                Card drawn = game.getDeck().drawCard();
                if (drawn != null) {
                    current.addCard(drawn);
                    System.out.println("You drew: " + drawn);
                } else {
                    System.out.println("Deck is empty!");
                }
            }

            gameOver = game.checkForWinner();
            game.nextTurn();
        }

        scanner.close();
    }
}

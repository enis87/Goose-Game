package goose.main;

import java.util.Scanner;

import goose.board.Board;
import goose.board.OriginalBoard;
import goose.game.Game;
import goose.player.Player;

public class Main {

	public static void main(String[] args) {

		String firstplayerName, otherPlayers;

		Scanner sc = new Scanner(System.in);

		/* Create the board we are going to play in */
		Board mainBoard = new OriginalBoard();

		/* Initiate a game with the board */
		Game aGame = new Game(mainBoard);
		aGame.getBoard().initBoard();

		/* Add first player to the Game */
		System.out.println("add player ");
		firstplayerName = sc.next();

		Player firstPlayer = new Player(firstplayerName);
		aGame.addPlayer(firstPlayer);

		/* Add other players */
		System.out.println("Type 'Y' or 'N' if you want to add another player?");
		String answer = sc.next();

		while (!answer.equalsIgnoreCase("n")) {

			switch (answer) {

				case "y":
				case "Y":
					System.out.println("add player ");
					otherPlayers = sc.next();
					if (otherPlayers.equalsIgnoreCase(firstplayerName)) {
						System.out.println(otherPlayers + ": already existing player.");
					}else {
						Player anotherPlayer = new Player(otherPlayers);
						aGame.addPlayer(anotherPlayer);
					}
					break;
					
				default:
					if (firstPlayer != null)
						System.out.println("There is only one player");
					if (!answer.equalsIgnoreCase("y") || !answer.equalsIgnoreCase("n")) {
						// Do nothing;
					}
					break;

			}

			System.out.println("Type 'Y' or 'N' if you want to add another player?");
			answer = sc.next();
		}
			
		sc.close();

		/* Play the game until there is a winner */
		aGame.playGame();

	}

}

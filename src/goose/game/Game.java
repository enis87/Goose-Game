package goose.game;

import java.util.*;

import goose.board.Board;
import goose.cell.Cell;
import goose.player.Player;

public class Game {

	private List<Player> thePlayers = new ArrayList<Player>();
	private Board board;
	private boolean gameFinished;

	/* Constructor for Game */
	public Game(Board iniBoard) {
		this.board = iniBoard;
		this.thePlayers = new ArrayList<Player>();
		this.gameFinished = false;
	}

	/**
	 * Check if the game is finished
	 * 
	 * @return true if the game is finished
	 */
	public boolean getGameFinished() {
		return this.gameFinished;
	}

	/**
	 * Changes the status of the game
	 * 
	 * @param b - is the status to set
	 */
	public void setGameFinished(boolean b) {
		this.gameFinished = b;
	}

	/* Get the current board */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Add a player in the game and assign him to the first cell
	 * 
	 * @param p - is the new player to add
	 */
	public void addPlayer(Player p) {

		this.thePlayers.add(p);
		this.getBoard().getCells()[0].setPlayer(p);
		String playerName = null;

		for (int i = 0; i < thePlayers.size(); i++) {
			playerName = thePlayers.get(i).toString();
			System.out.println("player: " + playerName);
		}

		
	}

	public void startGame() {

		int boardSize = this.getBoard().getNbOfCells() - 1;

		/* For each player we are going to throw the dice */
		oneRound: for (Player p : thePlayers) {

			/* We check if the player can leave the cell */
			if (p.getCell().canBeLeft()) {

				/* Rolled dices */
				int dice1 = p.diceThrow();
				int dice2 = p.diceThrow();

				/* Results of the dices */
				int result = dice1 + dice2; 

				/* Compute the new index of the player */
				int currentIndex = p.getCell().getIndex();
				int interIndex = currentIndex + result;
				int intermediateIndex;
				int destinationIndex;

				/* If the player is not out of the board */
				if (interIndex < boardSize + 1) {
					intermediateIndex = interIndex;
					destinationIndex = this.getBoard().getCell(intermediateIndex).handleMove(result);
				} else {
					intermediateIndex = boardSize - (result - (boardSize - currentIndex));
					destinationIndex = intermediateIndex;
				}

				/* Gives the status of the player */
				if (currentIndex == 0) {
					System.out.print("\"" + p.toString() + " is on space \"Start\".");
					System.out.println("\"" + p.toString() + " rolls " + dice1 + "," + dice2 + ". " + p.toString()
							+ " moves from Start to " + destinationIndex + "\"");
				} else {
					System.out.print("\"" + p.toString() + " is in cell " + currentIndex + "\".");
					System.out.println("\"" + p.toString() + " rolls " + dice1 + "," + dice2 + ". " + p.toString()
							+ " moves from " + currentIndex + " to " + destinationIndex + "\"");
				}

				Cell destinationCell = this.getBoard().getCell(destinationIndex);

				destinationCell.welcomePlayer(p);

				p.setCell(destinationCell);	
				
				this.getBoard().getCell(destinationIndex).setPlayer(p);
				

				/* Check if there is a winner */
				if (destinationIndex == boardSize) {
					System.out.println("\"" + p.toString() + " is in cell " + destinationIndex + ". " + p.toString()+ " Wins!!\"");
					this.setGameFinished(true);
					break oneRound;
				}
			} 
		}

	}

	public void playGame() {
		int turnCount = 0;
		while (!this.getGameFinished()) {
			System.out.println("\nGame Round : " + turnCount);
			this.startGame();
			turnCount++;
		}
	}

}

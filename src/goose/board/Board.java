package goose.board;

import goose.cell.Cell;

/**
 * A class to represent the board of the Goose Game.
 * The board has all the cells of the game.
 */

public abstract class Board {
	
	/** The number of cells of the board*/
	protected int numberOfCells;
	
	/** The cells of the board */
	protected Cell[] theCells;
	
	/** Builds a board with an initial number of cells
	 * @param nbOfCells - is the number of wanted cells
	 */
	public Board (int nbOfCells) {
		this.numberOfCells = nbOfCells;
	}
	
	/** Builds the board */
	public abstract void initBoard();
	
	/** Get the cells of the board */
	public Cell[] getCells() {
		return this.theCells;
	}
	
	/** Set the cells of the board
	 * @param cells - are the cells we want to set
	 */
	public void setTheCells(Cell[] cells) {
		this.theCells = cells;
	}
	
	/** Get a specific cell in the board
	 * @param number - is the position of the wanted cell
	 */
	public Cell getCell(int number) {
		return this.getCells()[number];
	}
	
	/** Get the number of cells of the board
	 */
	public int getNbOfCells() {
		return this.numberOfCells;
	}
	

}
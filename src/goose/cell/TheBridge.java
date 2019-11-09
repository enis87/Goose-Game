package goose.cell;

import goose.player.Player;

public class TheBridge implements Cell {

	/* The index of the cell */
	protected int index;

	/* The player dealing with the cell */
	protected Player player;

	/* Constructor for a Bridge cell */
	public TheBridge(int iniIndex, Player iniPlayer) {
		this.index = iniIndex;
		this.player = iniPlayer;
	}

	/* Constructor for a Bridge cell */
	public TheBridge(int iniIndex) {
		this.index = iniIndex;

	}

	/**
	 * @return <tt>true</tt> because it is a Bridge cell.
	 */
	public boolean canBeLeft() {
		return true;
	}

	/* Returns the index of this cell */
	public int getIndex() {
		return this.index;
	}

	/** Returns <tt>true</tt> if a player is in this cell */
	public boolean isBusy() {
		return this.player != null;
	}

	/** Gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Sets the player in this cell
	 * 
	 **/
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Returns the index of the cell really reached by a player when the player
	 * reaches The Bridge.
	 * 
	 * @param diceThrow - the result of the dice when the player reaches this cell
	 * @return the index of the actual cell where the player arrives when the given
	 *         throw of dice sends the player in this cell
	 */
	public int handleMove(int diceThrow) {
		int finalIndex = 0;
		
		if(this.getIndex() == 6) {	
				finalIndex = 12;
			}

		System.out.print("The player reache \"The Bridge\"");
		System.out.println( " and jumps to " + finalIndex);
		
		return finalIndex;
		
	}

	/**
	 * Handles what happens when a player arrives in this cell
	 * 
	 * @param player - the new player in the cell
	 */
	public void welcomePlayer(Player player) {
		if (this.getPlayer() != null) {

			System.out.print("The player \"" + this.getPlayer().toString() + "\" is already here !");

			Player playerToTakeOff = this.getPlayer();

			Cell cellToSend = player.getCell();

			playerToTakeOff.setCell(cellToSend);

			System.out.println(" The player \"" + player.toString() + "\" takes his place and the player \""
					+ playerToTakeOff.toString() + "\" has been moved to the cell number " + cellToSend.getIndex()
					+ ".");
		}
	}

}

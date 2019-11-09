package goose.cell;

import goose.player.Player;

/**
 * Interface for the cells of the game. Note that there can be only 
 * one player by cell, the starting cell (index 0) excepted.
 */
public interface Cell {
	/**
	 * @return <tt>true</tt> if and only if the player in this cell can freely
	 *  leaves the cell, else he must wait for another player to reach this cell 
	 *  or wait a given number of turns
	 */
	public boolean canBeLeft();

	/** Returns the index of this cell */
	public int getIndex();

	  /**
     * Returns the index of the cell really reached by a player when the player
     *    reaches this cell.  For normal cells, the returned value equals
     *   <code>getIndex()</code> and is thus independent from
     *   <code>diceThrow</code>.
     * @param diceThrow - the result of the dice when the player reaches this cell
     * @return the index of the actual cell where the player eventually
     * arrives when the given throw of dice sends the player in this cell
     */
	public int handleMove(int diceThrow);

	/** Returns <tt>true</tt> if a player is in this cell */
	public boolean isBusy();

	 /**  Handles what happens when a player arrives in this cell 
     * @param player - the new player in the cell
     */
	public void welcomePlayer(Player player);

	/** Gets the player in this cell if none */
	public Player getPlayer();
	
	/** Sets the player in this cell */
	public void setPlayer(Player player);
	
	
}// Cell

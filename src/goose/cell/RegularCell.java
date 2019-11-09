package goose.cell;

import goose.player.Player;

public class RegularCell implements Cell {
	
	/* The index of the cell */
	protected int index;
	
	/* The player dealing with the cell */
	protected Player player;
	
	/* Constructor for a regular cell */
	public RegularCell(int iniIndex, Player iniPlayer) {
		this.index = iniIndex;
		this.player = iniPlayer;
	}
	
	/* Constructor for a regular cell */
	public RegularCell(int iniIndex) {
		this.index = iniIndex;
	}
	
	/* Return true</tt> because it is a regular cell. */
	public boolean canBeLeft(){
		return true;
	}
	
	/** Returns the index of this cell
	 * @return the index of the cell
	 */
	public int getIndex() {
		return this.index;
	}
	
	/** Returns <tt>true</tt> if a player is in this cell */
	public boolean isBusy() {
		return this.player != null;
	}
	
	 /**
     * Returns the index of the cell really reached by a player when the player
     *    reaches this cell.  For normal cells, the returned value equals
     *   <code>getIndex()</code> and is thus independent from
     *   <code>diceThrow</code>.
     * @param diceThrow - the result of the dice when the player reaches this cell
     * @return the current index of the cell
     */
	public int handleMove(int diceThrow) {
		return this.getIndex();
	}
	
	/** Gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer() {
		return this.player;
	}
	
	/** Sets the player in this cell
	 * @param p - is the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	 /**  Handles what happens when a player arrives in this cell 
     * @param player - the new player in the cell
     */
	public void welcomePlayer(Player player){

		if (this.getPlayer() != null) {

			System.out.print("The player \"" +this.getPlayer().toString() + "\" is already here !");
			Player playerToTakeOff = this.getPlayer();			
			Cell cellToSend = player.getCell();				
			playerToTakeOff.setCell(cellToSend);

			System.out.println(" The player \"" +player.toString() + "\" takes his place and the player \""+playerToTakeOff.toString()
			+ "\" has been moved to the cell number " + cellToSend.getIndex() + ".");

		}
	}
	

}

package goose.cell;

import goose.player.Player;

public class GooseCell implements Cell{
	
	/* The index of the cell */
	protected int index;
	
	/* The player dealing with the cell */
	protected Player player;
	
	/** Constructor for a goose cell */
	public GooseCell(int iniIndex, Player iniPlayer) {
		this.index = iniIndex;
		this.player = iniPlayer;
	}
	
	/** Constructor for a goose cell */
	public GooseCell(int iniIndex) {
		this.index = iniIndex;
	}
	
	/** Returns the index of this cell */
	public int getIndex() {
		return this.index;
	}
	
	/** Return true because it is a goose cell. */
	public boolean canBeLeft(){
		return true;
	}
	
	/** Returns true if a player is in this cell */
	public boolean isBusy() {
		return this.player != null;
	}
	
	 /**
     * Returns the index of the cell reached by a player when the player
     *    reaches this cell.
     * @param diceThrow - the result of the dice when the player reaches this cell
     * 
     */
	public int handleMove(int diceThrow) {
		
		System.out.print("The cell " + this.getIndex() + " is a goose cell !");
		int newIndex =  this.getIndex() + diceThrow;
		System.out.println(" Player will reach the cell number " + newIndex +".");
		return newIndex;
	}
	
	/** Gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer() {
		return this.player;
	}
	
	/* Sets the player in this cell */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	 /**  Handles what happens when a player arrives in this cell 
     * @param player the new player in the cell
     */
	public void welcomePlayer(Player player){
		if (this.getPlayer() != null ) {
			
			System.out.print("The player \"" +this.getPlayer().toString() + "\" is already here !");
			
			Player playerToTakeOff = this.getPlayer();			
			Cell cellToSend = player.getCell();			
			playerToTakeOff.setCell(cellToSend);
			
			System.out.println(" The player \"" +player.toString()
			+ "\" takes his place and the player \""+playerToTakeOff.toString()
			+ "\" has been moved to the cell number " + cellToSend.getIndex() + ".");
		}
	}
	
}

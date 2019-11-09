package goose.player;

import goose.cell.Cell;

/** A player in the Goose game */

public class Player {
	
    /** Current cell of the player */
    protected Cell cell;
    
    /** Name of the player*/
    protected String name;
    
    /** 
     * @param name - the name of this player
     * @param cell - the starting cell of this player
    */
    public Player (String name, Cell cell){
        this.name = name;
        this.cell = cell;
    }
    
    /**  A player with no current cell (== null)
     * @param name - the name of this player
     * 
    */
    public Player (String name){
        this(name, null);
    }
    
    /** Returns the name of the current player 
     *  @return the current player <tt>Name<tt>
     */
    public String toString() { return name; }
    
    /** Returns the current cell of the player 
      *  @return the current cell of the player 
      */
    public Cell getCell() { 
       return this.cell ; 
    }
    
    /** Changes the cell of the player 
     * @param newCell - the new cell
    */
    public void setCell(Cell newCell) { 
       this.cell = newCell; 
    }    
    
    /** Result of a throw
     * @return random result of a throw 
    */
    public int diceThrow() {	
        return ((int) (Math.random()*10000) % 6)+ 1; 
     }
    
    
}
// End of Player.class

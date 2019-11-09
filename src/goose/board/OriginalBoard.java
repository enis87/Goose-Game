package goose.board;

import goose.cell.Cell;
import goose.cell.GooseCell;
import goose.cell.RegularCell;
import goose.cell.TheBridge;
import goose.cell.ZeroCell;


public class OriginalBoard extends Board {
	
	/** Constructor for the original board. */
	public OriginalBoard() {
		super(64);
	}
	
	/** Initiate the original board with all the cells in it. */
	public void initBoard(){
		
		Cell[] myCells = new Cell[64];
		
		myCells[0] = new ZeroCell(0);
		
		for (int i = 1; i < 64; i++) {
			myCells [i] = new RegularCell(i);
		}
		
		/* The Bridge Cell*/
		myCells[6] = new TheBridge(6);
		
		/* Defined Goose cells */
		myCells [5] = new GooseCell(5);		
		myCells [9] = new GooseCell(9);		
		myCells [14] = new GooseCell(14);		
		myCells [18] = new GooseCell(18);		
		myCells [23] = new GooseCell(23);		
		myCells [27] = new GooseCell(27);		
		
		
		this.setTheCells(myCells);
	}

}

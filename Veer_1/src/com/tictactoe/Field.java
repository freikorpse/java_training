package com.tictactoe;

import java.util.Iterator;
import java.util.Vector;


public class Field {

	private final int SIZE = 3;
	private Boolean[][] field = new Boolean[SIZE][SIZE];
	private int move = -1;
	
	Field(){
		reset();
		this.move = 0;
	}
	
	private final void reset(){
		for (int i=0;i<SIZE;i++){
			for (int j=0;j<SIZE;j++){
				field[i][j]=null;
			}
		}
	}
	
	private void checkSize(int val) throws IllegalCoordinateException{
		if (val<0 || val>=SIZE){
			throw new IllegalCoordinateException();
		} else {
			return;
		}
	}
	
	public int setAny(int x, int y, boolean set) throws IllegalCoordinateException, IllegalMoveException{
		checkSize(x);
		checkSize(y);
		
		if (field[x-1][y-1]==null){
			field[x-1][y-1] = set;
			move++;
			return move;
		} else {
			throw new IllegalMoveException();
		}
	}
	
	@Deprecated
	public boolean isWin(){
		for (int i=0;i<SIZE;i++){
			for (int j=0;j<SIZE;j++){
				
			}
		}
		
		
		
		
		return false;
	}
	
	
	public boolean isLineMatch(Vector<Coordinate> line){
		Coordinate prev = line.get(0);
		boolean isSame = true;
		
		Iterator<Coordinate> it = line.listIterator(1);
		while (it.hasNext()){
			isSame = prev.equals(it.next());
		}
		
		return false;
	}

}

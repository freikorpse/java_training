package com.tictactoe;

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
	
	protected int setAny(int x, int y, boolean set) throws IllegalCoordinateException, IllegalMoveException{
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

	public boolean isWin(){
		for (int i=0;i<SIZE;i++){
			for (int j=0;j<SIZE;j++){
				if (findLine(new Coordinate(i,j), 3)!=null)
					return true;
			}
		}
		return false;
	}
	
	public Vector<Coordinate> findLine (Coordinate start, int steps){
		Directions[] dr = Directions.values();

		for (int i=0;i<dr.length;i++){
			Vector<Coordinate> vct = dr[i].getDirection(start, steps);
			Boolean match = true;
			for (int j=0;j<vct.size()-1;j++){
				Boolean one = vct.get(j).getFieldValue(field);
				Boolean two = vct.get(j+1).getFieldValue(field);
				match = one==null?one==two:one!=two;
				match = two==null?two==one:two!=one;
				match = !match?one.equals(two):false;
				if (!match){
					continue;
				} else {
					return vct;
				}		
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		StringBuffer ret = new StringBuffer();
		for (int i=0;i<SIZE;i++){
			ret.append("# ");
			for (int j=0;j<SIZE;j++){
				ret.append(" ");
				ret.append(field[i][j]);
				ret.append(" ");
			}
			ret.append(" #");
			ret.append(System.lineSeparator());
		}
		return ret.toString();
	}
}

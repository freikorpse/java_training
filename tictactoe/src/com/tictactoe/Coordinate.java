package com.tictactoe;


public class Coordinate {
	
	private int x=-1;
	private int y=-1;
	
	public Coordinate(int i, int j){
		this.x=i;
		this.y=j;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Boolean getFieldValue(Boolean[][] field){
		Boolean val = null;
		
		try{
			val = field[x][y];
		} catch (ArrayIndexOutOfBoundsException e){
			//keep silence
		}
		return val;
	}
	

}

package com.tictactoe;


public class Coordinate implements ICoordinate {
	
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
}

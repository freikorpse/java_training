package com.tictactoe;


public class Coordinate implements ICoordinate {
	
	private int x=-1;
	private int y=-1;
	
	public Coordinate(int i, int j){
		this.x=i-1;
		this.y=j-1;
	}
	
	public int getRealX(){
		return x;
	}
	
	public int getRealY(){
		return y;
	}
	
	public int getX() {
		return x+1;
	}
	
	public int getY(){
		return y+1;
	}
	
	@Override
	public String toString(){
		return "<X:"+getX()+" Y:"+getY()+"> ";
	}
}

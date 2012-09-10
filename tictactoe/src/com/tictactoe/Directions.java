package com.tictactoe;

import java.util.Vector;

public enum Directions {

	WW(0, -1), WN(-1,-1), NN(-1, 0), NE(-1,1), EE(0,1), ES(1, 1), SS(1,0), SW(1, -1);
	
	private int x = 0;
	private int y = 0;
	
	Directions(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	private int getXinc(){
		return x;
	}
	
	private int getYinc(){
		return y;
	}
	
	public Vector<ICoordinate> getDirection(ICoordinate crd, int steps){
		Vector<ICoordinate> ret = new Vector<ICoordinate>(steps, steps+2);
		ret.add(crd);
		for (int i=1;i<steps;i++){
			int k = ret.get(i-1).getX() + getXinc();
			int l = ret.get(i-1).getY() + getYinc();
			Coordinate newCrd = new Coordinate(k,l);
			ret.add(newCrd);
		}
		return ret;
	}
}

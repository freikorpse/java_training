package com.tictactoe;

public enum Directions {
	
	SS(1,0), SE(1, 1), EE(0,1), NE(-1,1)/*, NN(-1, 0), WN(-1,-1), WW(0, -1), SW(1, -1)*/;
	
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
	
	public PointVector<ICoordinate> getDirection(ICoordinate crd, int steps){
		PointVector<ICoordinate> ret = new PointVector<ICoordinate>(steps, steps+2);
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

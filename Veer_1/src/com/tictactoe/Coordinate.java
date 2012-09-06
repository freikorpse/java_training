package com.tictactoe;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

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
	
	public Vector<Coordinate> findLine (Boolean[][] field, int steps){
		Vector<Coordinate> ret = new Vector<Coordinate>(steps, steps+2);
		Directions[] dr = Directions.values();

		for (int i=0;i<dr.length;i++){
			Vector<Coordinate> vct = dr[i].getDirection(this, steps);
			
			
			
		}
		
		

		
		
		
		return ret;
	}
}

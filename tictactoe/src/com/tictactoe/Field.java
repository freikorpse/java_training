package com.tictactoe;

import java.util.Vector;

public class Field {

	private int SIZE = 3;
	private Boolean[][] field = new Boolean[SIZE][SIZE];
	private int move = -1;
	
	public Field(){
		reset();
	}
	
	public Field(int size){
		this.SIZE = size;
		reset();	
	}
	
	private final void reset(){
		for (int i=0;i<SIZE;i++){
			for (int j=0;j<SIZE;j++){
				field[i][j]=null;
			}
		}
		this.move = 0;
	}
	
	private boolean checkSize(ICoordinate point) {
		return !(point.getX()<0 || point.getY()>SIZE);
	}

	
	public int setAny(ICoordinate point, boolean set) throws IllegalCoordinateException, IllegalMoveException{
		if (!checkSize(point)){
			throw new IllegalCoordinateException();
		}
		int x = point.getX();
		int y = point.getY();
		if (field[x-1][y-1]==null){
			field[x-1][y-1] = set;
			move++;
			return move;
		} else {
			throw new IllegalMoveException();
		}
	}
	
	public Boolean getValue(ICoordinate point){
		Boolean val = null;
		int x= point.getX();
		int y= point.getY();
		try{
			val = field[x][y];
		} catch (ArrayIndexOutOfBoundsException e){
			//TODO keep silence
		}
		return val;
	}

	public Vector<ICoordinate> isWin(){
		for (int i=0;i<SIZE;i++){
			for (int j=0;j<SIZE;j++){
				Vector<ICoordinate> ret = findLine(new Coordinate(i,j), 3);
				if (ret!=null)
					return ret;
			}
		}
		return null;
	}
	
	protected Vector<ICoordinate> findLine (ICoordinate start, int steps){
		Directions[] dr = Directions.values();

		for (int i=0;i<dr.length;i++){
			Vector<ICoordinate> vct = dr[i].getDirection(start, steps);
			Boolean match = false;
			for (int j=0;j<vct.size()-1;j++){
				Boolean one = getValue(vct.get(j));
				Boolean two = getValue(vct.get(j+1));
				if (one==null || two==null){
					match = (one==two);
				} else {
					match = (one.equals(two));
				}
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

package com.tictactoe;

import java.util.Vector;

public class PointVector<E> extends Vector<E> {

	private static final long serialVersionUID = -2521445071927051230L;
	String SEP = System.lineSeparator();
	
	public PointVector(int steps, int i) {
		super(steps, i);
	}

	@Override
	public String toString(){
		StringBuffer ret = new StringBuffer("# vector: ");
		int size = size();
		for(int i=0;i<size;i++){
			if (i==size-1){
				ret.append(this.get(i).toString()+SEP);
			} else {
				ret.append(this.get(i).toString()+" ");
			}
		}
		return ret.toString();
	}	
}

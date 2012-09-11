package com.tictactoe;

public class Field {

	private int SIZE = 3;

	private Boolean[][] field;

	private int move = -1;

	public Field() {
		reset();
	}

	public Field(int size) {
		this.SIZE = size;
		reset();
	}

	private final void reset() {
		field = new Boolean[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				field[i][j] = null;
			}
		}
		this.move = 0;
	}

	private boolean checkSize(ICoordinate point) {
		return !((point.getRealX() < 0 || point.getRealX() > SIZE) || (point
				.getRealY() < 0 || point.getRealY() > SIZE));
	}


	public int setAny(ICoordinate point, boolean set) throws IllegalCoordinateException, IllegalMoveException{
		if (!checkSize(point)){
			throw new IllegalCoordinateException();
		}
		int x = point.getRealX();
		int y = point.getRealY();
		if (field[x][y] == null) {
			field[x][y] = set;
			move++;
			return move;
		} else {
			throw new IllegalMoveException();
		}
	}
	
	public Boolean getValue(ICoordinate point) {
		Boolean val = null;
		int x = point.getRealX();
		int y = point.getRealY();
		try {
			val = field[x][y];
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO keep silence
		}
		return val;
	}

	public PointVector<ICoordinate> isWin() {
		PointVector<ICoordinate> line = null;
		
		for (int i=1;i<=SIZE;i++){
			for (int j=1;j<=SIZE;j++){
				line = findLine(new Coordinate(i,j),3);
				if (line!=null){
					return line;
				}
			}
		}
		return null;
	}

	public PointVector<ICoordinate> findLine(ICoordinate start, int steps) {
		Directions[] dr = Directions.values();

		for (int i = 0; i < dr.length; i++) {
			PointVector<ICoordinate> vct = dr[i].getDirection(start, steps);
			boolean match = false;
			for (int j = 0; j < vct.size() - 1; j++) {
				Boolean one = getValue(vct.get(j));
				Boolean two = getValue(vct.get(j + 1));
				if (one == null || two == null) {
					match = false;
				} else {
					match = (one.equals(two));
				}
				if (!match) {
					break;
				}
			}
			if (match) {
				return vct;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("X -> Y" + System.lineSeparator());
		for (int i = 0; i < SIZE; i++) {
			ret.append("# ");
			for (int j = 0; j < SIZE; j++) {
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

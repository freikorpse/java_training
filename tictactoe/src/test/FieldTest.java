package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tictactoe.Coordinate;
import com.tictactoe.Field;
import com.tictactoe.ICoordinate;
import com.tictactoe.IllegalCoordinateException;
import com.tictactoe.IllegalMoveException;
import com.tictactoe.PointVector;

//small comment
public class FieldTest {

	PointVector<ICoordinate> line;

	@Test
	public void testIsWinHor() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field();
		field.setAny(new Coordinate(1,1),true);
		field.setAny(new Coordinate(1,2),true);
		field.setAny(new Coordinate(1,3),true);
		line = field.isWin();
		assertTrue("is win  horizontal", line!=null);
		assertTrue("vector is horizontal", line.toString().contains("<X:1 Y:1>  <X:1 Y:2>  <X:1 Y:3>"));
	}
	
	@Test
	public void testIsNotWinHor() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field();
		field.setAny(new Coordinate(1,1),true);
		field.setAny(new Coordinate(1,2),false);
		field.setAny(new Coordinate(1,3),true);
		line = field.isWin();
		//System.out.println(field.toString());
		//System.out.println(line.toString());
		assertTrue("is NOT win horizontal", line==null);
	}
	
	@Test
	public void testIsNotWinCross() throws IllegalCoordinateException, IllegalMoveException{
		Field field = new Field();
		field.setAny(new Coordinate(1,1),true);
		field.setAny(new Coordinate(2,2),false);
		field.setAny(new Coordinate(3,3),true);
		line = field.isWin();
		//System.out.println(field.toString());
		//System.out.println(line.toString());
		assertTrue("is not Win Cross", line==null);
	}
	
	@Test
	public void testIsWinCross() throws IllegalCoordinateException, IllegalMoveException{
		Field field = new Field();
		field.setAny(new Coordinate(1,1),true);
		field.setAny(new Coordinate(2,2),true);
		field.setAny(new Coordinate(3,3),true);
		line = field.isWin();
		//System.out.println(field.toString());
		//System.out.println(line.toString());
		assertTrue("is not Win Cross", line!=null);
	}
	
	@Test
	public void testWinMultiCross() throws IllegalCoordinateException, IllegalMoveException{
		Field field = new Field(10);
		field.setAny(new Coordinate(3,3),true);
		field.setAny(new Coordinate(4,4),true);
		field.setAny(new Coordinate(5,5),true);
		line = field.isWin();
		//System.out.println(field.toString());
		//System.out.println(line.toString());
		assertTrue("is Win Cross on multi field", line!=null);
	}

	@Test
	public void testFindLinePos() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field(10);
		field.setAny(new Coordinate(3,3),true);
		field.setAny(new Coordinate(4,4),true);
		field.setAny(new Coordinate(5,5),true);
		System.out.println(field.toString());
		line = field.findLine(new Coordinate(3,3), 3);
		assertTrue("line is found", line!=null);
		//System.out.println(line.toString());
	}
	
	@Test
	public void testFindLineNeg() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field(10);
		field.setAny(new Coordinate(3,3),true);
		field.setAny(new Coordinate(4,4),true);
		field.setAny(new Coordinate(5,5),true);
		System.out.println(field.toString());
		line = field.findLine(new Coordinate(3,3), 4);
		assertTrue("line is found", line==null);
		//System.out.println(line.toString());
	}

	@Test
	public void testToStringSetField() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field();		
		field.setAny(new Coordinate(1,1),true);
		String sf = field.toString();
		assertTrue("first line was set: ", sf.contains("#  true  null  null  #"));
		//System.out.println(field.toString());
	}
}

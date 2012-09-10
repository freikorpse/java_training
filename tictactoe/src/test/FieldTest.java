package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.tictactoe.Coordinate;
import com.tictactoe.Field;
import com.tictactoe.ICoordinate;
import com.tictactoe.IllegalCoordinateException;
import com.tictactoe.IllegalMoveException;

public class FieldTest {

	Vector<ICoordinate> line;
	
	@Test
	public void testIsWin() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field();
		field.setAny(new Coordinate(1,1),true);
		//field.setAny(new Coordinate(1,2),true);
		field.setAny(new Coordinate(1,3),true);
		line = field.isWin();
		assertTrue("is win  horizontal", line!=null);
		
		System.out.println(field.toString());
		System.out.println(line.toString());
		
		/*field = new Field();
		field.setAny(new Coordinate(1,1),true);
		field.setAny(new Coordinate(1,2),false);
		field.setAny(new Coordinate(1,3),true);
		System.out.println(field.toString());
		
		assertTrue("is NOT win horizontal", !field.isWin());
		
		field = new Field();
		field.setAny(new Coordinate(1,1),true);
		field.setAny(new Coordinate(2,2),true);
		field.setAny(new Coordinate(3,3),true);
		System.out.println(field.toString());
		
		assertTrue("is win down-slash", field.isWin());
		
		
		field = new Field();
		field.setAny(new Coordinate(1,3),true);
		field.setAny(new Coordinate(2,2),true);
		field.setAny(new Coordinate(3,1),true);
		
		assertTrue("is win up-slash", field.isWin());*/
	}

	@Test
	public void testFindLine() {
		fail("Not yet implemented");
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

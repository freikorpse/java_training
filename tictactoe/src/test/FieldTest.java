package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tictactoe.Field;
import com.tictactoe.IllegalCoordinateException;
import com.tictactoe.IllegalMoveException;

public class FieldTest {

	@Test
	public void testIsWin() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field();
		field.setAny(1,1,true);
		field.setAny(1,2,true);
		field.setAny(1,3,true);
		System.out.println(field.toString());
		
		assertTrue("is win  horizontal", field.isWin());
		
		field = new Field();
		field.setAny(1,1,true);
		field.setAny(1,2,false);
		field.setAny(1,3,true);
		
		assertTrue("is NOT win horizontal", !field.isWin());
		
		field = new Field();
		field.setAny(1,1,true);
		field.setAny(2,2,true);
		field.setAny(3,3,true);
		System.out.println(field.toString());
		
		assertTrue("is win down-slash", field.isWin());
		
		
		field = new Field();
		field.setAny(1,3,true);
		field.setAny(2,2,true);
		field.setAny(3,1,true);
		System.out.println(field.toString());
		
		assertTrue("is win up-slash", field.isWin());
	}

	@Test
	public void testFindLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testToStringSetField() throws IllegalCoordinateException, IllegalMoveException {
		Field field = new Field();		
		field.setAny(1,1,true);
		String sf = field.toString();
		assertTrue("first line was set: ", sf.contains("#  true  null  null  #"));
		//System.out.println(field.toString());
	}

}

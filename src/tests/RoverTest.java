package tests;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import common.MinhaException;
import common.Rover;

class RoverTest {
Rover rover;
	@Test
	public void createRover() {
		rover = new Rover(5, 5, 0, 0, 'N', 9, 10);
		assertEquals("(5, 5, N)", rover.toString());
	}

	@Test
	public void moveRight() {
		rover = new Rover(5, 5, 0, 0, 'N', 9, 10);
		try {
			rover.control('R');
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("(5, 5, E)", rover.toString());
	}
	
	@Test
	public void moveLeft() {
		rover = new Rover(5, 5, 0, 0, 'N', 9, 10);
		try {
			rover.control('L');
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("(5, 5, W)", rover.toString());
	}
	
	@Test
	public void move() {
		rover = new Rover(5, 5, 0, 0, 'N', 9, 10);
		try {
			rover.control('M');
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("(5, 6, N)", rover.toString());
	}
	
	@Test(expected = MinhaException.class)
	public void control()throws Exception {
		rover = new Rover(5, 5, 0, 0, 'N', 9, 10);
		rover.control('M');
	}
	
	@Test
	public void euConsigoIrParaONorte() {
		rover = new Rover(9, 10, 0, 0, 'N', 9, 10);
		assertEquals(false, rover.euConsigoIrParaONorte());
	}
}

package com.lmb.wallapop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.map.Map;
import com.lmb.wallapop.map.SingleMap;
import com.lmb.wallapop.rover.Coordinates;
import com.lmb.wallapop.rover.Direction;
import com.lmb.wallapop.rover.Rover;

public class RoverTest {

	Rover rover;

	@BeforeEach
	public void init() throws MapException {
		Coordinates coordinates = new Coordinates(0, 0);
		Map map = new SingleMap(4, 4);
		rover = new Rover(coordinates, Direction.N, map);
	}

	@Test
	public void testMoveForward() throws MapException {

		rover.moveForward();
		assertEquals(0, rover.getCoordinates().getX());
		assertEquals(1, rover.getCoordinates().getY());

	}

	@Test
	public void testMoveBackward() throws MapException {
		rover.moveBackward();
		assertEquals(0, rover.getCoordinates().getX());
		assertEquals(4, rover.getCoordinates().getY());
	}

	@Test
	public void testRotateRight() {
		rover.rotateRight();
		assertEquals(Direction.E, rover.getDirection());

	}

	@Test
	public void testRotateLeft() {
		rover.rotateLeft();
		assertEquals(Direction.W, rover.getDirection());
	}

}

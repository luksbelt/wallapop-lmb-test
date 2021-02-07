package com.lmb.wallapop.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.map.Map;
import com.lmb.wallapop.map.ObstaclesMap;
import com.lmb.wallapop.rover.Coordinates;
import com.lmb.wallapop.rover.Direction;
import com.lmb.wallapop.rover.Rover;

public class MoveControllerTest {

	MoveController controller;
	Rover rover;

	@BeforeEach
	public void init() throws MapException {
		Coordinates coordinates = new Coordinates(0, 0);
		int[][] obstacles = new int[4][5];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				obstacles[i][j] = 0;
			}
		}
		obstacles[0][2] = 1;
		obstacles[0][4] = 1;
		Map map = new ObstaclesMap(new Coordinates(3, 4), obstacles);
		rover = new Rover(coordinates, Direction.N, map);
		controller = new MoveController(rover);
	}

	@Test
	public void testMove() {
		controller.move("F");
		assertEquals(0, rover.getCoordinates().getX());
		assertEquals(1, rover.getCoordinates().getY());
		controller.move("F");
		// Test to fail
		assertEquals(0, rover.getCoordinates().getX());
		assertEquals(1, rover.getCoordinates().getY());

		controller.move("B");
		assertEquals(0, rover.getCoordinates().getX());
		assertEquals(0, rover.getCoordinates().getY());

		// Test to fail
		controller.move("B");
		assertEquals(0, rover.getCoordinates().getX());
		assertEquals(0, rover.getCoordinates().getY());

		controller.move("R");
		assertEquals(Direction.E, rover.getDirection());
		controller.move("L");
		assertEquals(Direction.N, rover.getDirection());
		controller.move("L");
		assertEquals(Direction.W, rover.getDirection());
		controller.move("L");
		assertEquals(Direction.S, rover.getDirection());

	}

}

package com.lmb.wallapop;
import org.junit.jupiter.api.BeforeEach;

import com.lmb.wallapop.controller.MoveController;
import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.map.Map;
import com.lmb.wallapop.map.SingleMap;
import com.lmb.wallapop.rover.Coordinates;
import com.lmb.wallapop.rover.Direction;
import com.lmb.wallapop.rover.Rover;

public class MoveControllerTest {

	MoveController controller;
	Rover rover;

	@BeforeEach
	public void init() throws MapException {
		Coordinates coordinates = new Coordinates(0, 0);
		Map map = new SingleMap(4, 4);
		rover = new Rover(coordinates, Direction.N, map);
		controller = new MoveController(rover);
	}
//
//	@Test
//	public void testMove() {
//		controller.move("F");
//		assertEquals(0, rover.getCoordinates().getX());
//		assertEquals(1, rover.getCoordinates().getY());
//		controller.move("B");
//		assertEquals(0, rover.getCoordinates().getX());
//		assertEquals(0, rover.getCoordinates().getY());
//		controller.move("R");
//		assertEquals(Direction.E, rover.getDirection());
//		controller.move("L");
//		assertEquals(Direction.N, rover.getDirection());
//		controller.move("L");
//		assertEquals(Direction.W, rover.getDirection());
//		controller.move("L");
//		assertEquals(Direction.S, rover.getDirection());
//
//	}

//	@Test
//	public void TestGetNextCoordinate() {
//		Coordinates coordinates = new Coordinates(0,0);
//		Coordinates nextCoordinates = controller.getNextCoordinate(Direction.N, coordinates);
//		assertEquals(0, nextCoordinates.getX());
//		assertEquals(1, nextCoordinates.getY());
//		nextCoordinates = controller.getNextCoordinate(Direction.W, coordinates);
//		assertEquals(4, nextCoordinates.getX());
//		assertEquals(0, nextCoordinates.getY());
//		nextCoordinates = controller.getNextCoordinate(Direction.S, coordinates);
//		assertEquals(0, nextCoordinates.getX());
//		assertEquals(4, nextCoordinates.getY());
//		nextCoordinates = controller.getNextCoordinate(Direction.E, coordinates);
//		assertEquals(1, nextCoordinates.getX());
//		assertEquals(0, nextCoordinates.getY());
//	}

}

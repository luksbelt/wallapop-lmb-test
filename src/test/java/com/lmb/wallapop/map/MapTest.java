package com.lmb.wallapop.map;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.lmb.wallapop.exception.ObstacleException;
import com.lmb.wallapop.exception.OutOfBoundsException;
import com.lmb.wallapop.rover.Coordinates;

public class MapTest {

	@Test
	public void testSingleMap() {
		Map map = new SingleMap(new Coordinates(4, 4));
		assertDoesNotThrow(() -> map.validatePosition(new Coordinates(0, 0)));
		assertDoesNotThrow(() -> map.validatePosition(new Coordinates(1, 1)));
		assertDoesNotThrow(() -> map.validatePosition(new Coordinates(1, 2)));
		assertThrows(OutOfBoundsException.class, () -> map.validatePosition(new Coordinates(3, 5)));
		assertThrows(OutOfBoundsException.class, () -> map.validatePosition(new Coordinates(5, 4)));
		assertThrows(OutOfBoundsException.class, () -> map.validatePosition(new Coordinates(5, 5)));
	}

	@Test
	public void testObstacles() {
		
		int[][] obstacles = new int[5][6];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				obstacles[i][j] = 0;
			}
		}
		obstacles[1][2] = 1;
		obstacles[3][4] = 1;
		obstacles[3][4] = 1;
		Map map = new ObstaclesMap(new Coordinates(4, 5), obstacles);
		assertDoesNotThrow(() -> map.validatePosition(new Coordinates(0, 0)));
		assertThrows(ObstacleException.class, () -> map.validatePosition(new Coordinates(3, 4)));
		assertThrows(OutOfBoundsException.class, () -> map.validatePosition(new Coordinates(5, 5)));

	}

}

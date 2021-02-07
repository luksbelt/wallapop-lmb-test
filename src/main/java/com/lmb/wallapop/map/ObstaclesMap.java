package com.lmb.wallapop.map;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.exception.ObstacleException;
import com.lmb.wallapop.exception.OutOfBoundsException;
import com.lmb.wallapop.rover.Coordinates;

public class ObstaclesMap extends Map {

	int[][] obstacles;

	public ObstaclesMap(Coordinates coordinates, int[][] obstacles) {
		super(coordinates);
		this.obstacles = obstacles;
	}
	public int[][] getObstacles() {
		return obstacles;
	}

	public void setObstacles(int[][] obstacles) {
		this.obstacles = obstacles;
	}

	@Override
	public void validatePosition(Coordinates coordinates) throws MapException {
		if (coordinates.getX() > this.getMaxCoordinates().getX() || coordinates.getX() < 0
				|| coordinates.getY() > this.getMaxCoordinates().getY() || coordinates.getY() < 0) {
			throw new OutOfBoundsException(
					String.format("Position x=%d, y=%d is not valid.", coordinates.getX(), coordinates.getY()));
		}
		if (this.getObstacles()[coordinates.getX()][coordinates.getY()] != 0) {
			throw new ObstacleException(
					String.format("There is an obstacle in the position x=%d, y=%d.",
							coordinates.getX(), coordinates.getY()));
		}

	}
}

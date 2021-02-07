package com.lmb.wallapop.map;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.exception.ObstacleException;
import com.lmb.wallapop.exception.OutOfBoundsException;

public class ObstaclesMap extends Map {

	int[][] obstacles;

	public ObstaclesMap(int maxX, int maxY, int[][] obstacles) {
		super(maxX, maxY);
		this.obstacles = obstacles;
	}
	public int[][] getObstacles() {
		return obstacles;
	}

	public void setObstacles(int[][] obstacles) {
		this.obstacles = obstacles;
	}

	@Override
	public void validatePosition(int x, int y) throws MapException {
		if (x > this.getMaxX() || x < 0 || y > this.getMaxY() || y < 0) {
			throw new OutOfBoundsException(String.format("Position x=%d, y=%d is not valid.", x, y));
		}
		if (this.getObstacles()[x][y] != 0) {
			throw new ObstacleException(
					String.format("There is an obstacle in the position x=%d, y=%d.",
							x, y));
		}

	}
}

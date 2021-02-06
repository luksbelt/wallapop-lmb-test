package com.lmb.wallapop.map;

import com.lmb.wallapop.exception.OutOfBoundsException;

public class SingleMap extends Map {

	public SingleMap(int maxX, int maxY) {
		super(maxX, maxY);
	}

	@Override
	public void validatePosition(int x, int y) throws OutOfBoundsException {
		if (x > this.getMaxX() || x < 0 || y > this.getMaxY() || y < 0) {
			throw new OutOfBoundsException(
					String.format("Position x=%d, y=%d is not valid.", x, y));
		}
	}

}

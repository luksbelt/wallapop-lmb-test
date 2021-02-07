package com.lmb.wallapop.map;

import com.lmb.wallapop.exception.OutOfBoundsException;
import com.lmb.wallapop.rover.Coordinates;

public class SingleMap extends Map {

	public SingleMap(Coordinates coordinates) {
		super(coordinates);
	}

	@Override
	public void validatePosition(Coordinates coordinates) throws OutOfBoundsException {
		if (coordinates.getX() > this.getMaxCoordinates().getX() || coordinates.getX() < 0
				|| coordinates.getY() > this.getMaxCoordinates().getY() || coordinates.getY() < 0) {
			throw new OutOfBoundsException(
					String.format("Position x=%d, y=%d is not valid.", coordinates.getX(), coordinates.getY()));
		}
	}

}

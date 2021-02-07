package com.lmb.wallapop.map;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.rover.Coordinates;

public abstract class Map {

	private Coordinates maxCoordinates;

	public Map(Coordinates coordinates) {
		super();
		this.maxCoordinates = coordinates;
	}

	public Coordinates getMaxCoordinates() {
		return maxCoordinates;
	}

	public void setMaxCoordinates(Coordinates coordinates) {
		this.maxCoordinates = coordinates;
	}


	public abstract void validatePosition(Coordinates coordinates) throws MapException;

}

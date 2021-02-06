package com.lmb.wallapop.map;

import com.lmb.wallapop.exception.MapException;

public abstract class Map {

	private int maxX;
	private int maxY;

	public Map(int maxX, int maxY) {
		super();
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public abstract void validatePosition(int x, int y) throws MapException;

}

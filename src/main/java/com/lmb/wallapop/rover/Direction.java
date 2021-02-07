package com.lmb.wallapop.rover;

public enum Direction {

	N(0, "North"), E(1, "East"), S(2, "South"), W(3, "West");

	private int value;
	private String label;

	private Direction(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public Direction back() {
		return values()[(this.getValue() + 2) % 4];
	}

	public Direction right() {
		return values()[(this.getValue() + 1) % values().length];
	}

	public Direction left() {
		return values()[Math.floorMod((this.getValue() - 1), values().length)];
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}

}

package com.lmb.wallapop.rover;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.map.Map;

public class Rover {

	private Coordinates coordinates;
	private Direction direction;
	private Map map;

	public Rover(Coordinates coordinates, Direction direction, Map map) throws MapException {
		super();
		this.coordinates = coordinates;
		this.direction = direction;
		map.validatePosition(coordinates);
		this.map = map;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void moveForward() throws MapException {
		Coordinates nextCoordinates = getNextCoordinate(getDirection(), getCoordinates());
		map.validatePosition(nextCoordinates);
		setCoordinates(nextCoordinates);
	}

	public void moveBackward() throws MapException {
		Coordinates nextCoordinates = getNextCoordinate(getDirection().back(), getCoordinates());
		map.validatePosition(nextCoordinates);
		setCoordinates(nextCoordinates);
	}

	public void rotateRight() {
		setDirection(direction.right());
	}

	public void rotateLeft() {
		setDirection(direction.left());
	}

	private Coordinates getNextCoordinate(Direction current, Coordinates coordinates) {
		Coordinates nextCoordinates = new Coordinates(coordinates.getX(), coordinates.getY());
		switch (current) {
		case N:
			int nextY = (coordinates.getY() + 1) % (map.getMaxCoordinates().getY() + 1);
			nextCoordinates.setY(nextY);
			break;
		case S:
			if (coordinates.getY() > 0) {
				nextCoordinates.setY(coordinates.getY() - 1);
			} else {
				nextCoordinates.setY(map.getMaxCoordinates().getY());
			}
			break;
		case E:
			int nextX = (coordinates.getX() + 1) % (map.getMaxCoordinates().getX() + 1);
			nextCoordinates.setX(nextX);
			break;
		case W:
			if (coordinates.getX() > 0) {
				nextCoordinates.setX(coordinates.getX() - 1);
			} else {
				nextCoordinates.setX(map.getMaxCoordinates().getX());
			}
			break;
		default:
			return null;
		}
		return nextCoordinates;
	}

}

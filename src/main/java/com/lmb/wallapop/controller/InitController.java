package com.lmb.wallapop.controller;

import java.util.Scanner;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.map.Map;
import com.lmb.wallapop.map.ObstaclesMap;
import com.lmb.wallapop.map.SingleMap;
import com.lmb.wallapop.rover.Coordinates;
import com.lmb.wallapop.rover.Rover;

public class InitController {

	private InputValidator inputValidator = new InputValidator();

	public Rover init() throws MapException {
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert horizontal map size:");
		int sizex = inputValidator.getIntInput(reader);
		System.out.println("Insert vertical map size:");
		int sizey = inputValidator.getIntInput(reader);
		System.out.println("Insert horizontal initial rover position:");
		int roverx = inputValidator.getIntInput(reader);
		System.out.println("Insert vertical initial rover position:");
		int rovery = inputValidator.getIntInput(reader);

		Coordinates mapCoordinates = new Coordinates(sizex, sizey);
		Coordinates coordinates = new Coordinates(roverx, rovery);
		Map map = createMap(reader, mapCoordinates, coordinates);

		return new Rover(coordinates, inputValidator.getDirectionInput(reader), map);
	}

	public int[][] createRandomObstacles(int sizex, int sizey) {
		int[][] obstacles = new int[sizex][sizey];
		// Initialize obstacles matrix
		for (int i = 0; i < sizex; i++) {
			for (int j = 0; j < sizey; j++) {
				obstacles[i][j] = (int) Math.round(Math.random());
			}
		}
		return obstacles;
	}

	public Map createMap(Scanner reader, Coordinates mapCoordinates, Coordinates roverCoordinates) {
		int mapType = 0;
		do {
			System.out.println("Choose a Map type:");
			System.out.println("1. Simple Map");
			System.out.println("2. Obstacles Map");
			mapType = inputValidator.getIntInput(reader);
		} while (mapType != 1 && mapType != 2);

		Map map = null;
		switch (mapType) {
		case 1:
			map = new SingleMap(mapCoordinates);
			break;
		case 2:
			int[][] obstacles = createRandomObstacles(mapCoordinates.getX() + 1, mapCoordinates.getY() + 1);
			// To be sure the initial position it does't match with an obstacle
			obstacles[roverCoordinates.getX()][roverCoordinates.getY()] = 0;
			map = new ObstaclesMap(mapCoordinates, obstacles);
			break;
		}
		return map;
	}

}

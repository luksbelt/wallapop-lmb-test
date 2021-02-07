package com.lmb.wallapop;

import java.util.Scanner;

import com.lmb.wallapop.map.Map;
import com.lmb.wallapop.map.ObstaclesMap;

public class MarsRover {

	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert horizontal map size:");
		int sizex = reader.nextInt();
		System.out.println("Insert vertical map size:");
		int sizey = reader.nextInt();
		int[][] obstacles = new int[sizex][sizey];
		// Initialize obstacles matrix
		for (int i = 0; i < sizex; i++) {
			for (int j = 0; j < sizex; j++) {
				obstacles[i][j] = (int) Math.round(Math.random());
			}
		}
		Map map = new ObstaclesMap(sizex - 1, sizey - 1, obstacles);

		System.out.println("Insert horizontal initial rover position:");
		int roverx = reader.nextInt();
		System.out.println("Insert vertical initial rover position:");
		int rovery = reader.nextInt();
		System.out.println("Insert initial rover direction:");
		String roverz = reader.next(); // n = north, e = east, w = west, s = south

		Coordinates coordinates = new Coordinates(roverx, rovery);
		Rover rover = new Rover(coordinates, Direction.valueOf(roverz.toUpperCase()), map);
		MoveController controller = new MoveController(rover);
		controller.start();
    }
}

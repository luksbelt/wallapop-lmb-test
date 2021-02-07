package com.lmb.wallapop.controller;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.lmb.wallapop.rover.Direction;

public class InputValidator {

	public int getIntInput(Scanner reader) {
		Integer value = null;
		do {
			try {
				value = reader.nextInt();
			} catch (InputMismatchException e) {
				reader.next();
				System.out.println("Input must be an Integer");
			}
		} while (value == null);
		return value;
	}

	public String getStringInput(Scanner reader, String message) {
		String st = "";
		do{
			try {
				st = reader.next();
			} catch (NoSuchElementException e) {
				System.out.println(message);
				reader.next();
			}
		} while (st.isBlank());
		return st;
	}

	public Direction getDirectionInput(Scanner reader) {
		Direction direction = null;
		System.out.println("Insert initial rover direction (N,S,E,W):");
		do {
			String roverz = getStringInput(reader,
					"Input must be a Direction ( n = north, e = east, w = west, s = south)");
			try {
				direction = Direction.valueOf(roverz.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("Input must be a Direction ( n = north, e = east, w = west, s = south)");
			}
		} while (direction == null);
		return direction;
	}

}

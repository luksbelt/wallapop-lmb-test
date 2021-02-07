package com.lmb.wallapop.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.lmb.wallapop.command.Command;
import com.lmb.wallapop.command.MoveBackward;
import com.lmb.wallapop.command.MoveForward;
import com.lmb.wallapop.command.RotateLeft;
import com.lmb.wallapop.command.RotateRight;
import com.lmb.wallapop.rover.Rover;

public class MoveController {

	private Rover rover;
	private Map<String, Command> commands;

	public MoveController(Rover rover) {
		super();
		this.rover = rover;
		this.commands = new HashMap<String, Command>();
		commands.put("F", new MoveForward(rover));
		commands.put("B", new MoveBackward(rover));
		commands.put("L", new RotateLeft(rover));
		commands.put("R", new RotateRight(rover));
	}

	public void start() {
		Scanner reader = new Scanner(System.in);
		do {
			System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
			String command = reader.next();
			move(command.toUpperCase());
			System.out.println(String.format("Rover is at x:%d y:%d facing:%s", rover.getCoordinates().getX(),
					rover.getCoordinates().getY(), rover.getDirection()));
		} while (true);
	}

	public void move(String commandST) {
		if (commands.get(commandST) !=null) {
			commands.get(commandST).execute(); 
		}
		else {
			System.out.println("Command not found.");
		}

	}

}

package com.lmb.wallapop.command;

import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.rover.Rover;

public class MoveForward implements Command {

	private Rover rover;

	public MoveForward(Rover rover) {
		super();
		this.rover = rover;
	}

	@Override
	public void execute() {
		try {
			rover.moveForward();
		} catch (MapException e) {
			System.out.println(e.getMessage() + "Rover cannot move forward");
		}
	}

}

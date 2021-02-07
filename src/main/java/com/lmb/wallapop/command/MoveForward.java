package com.lmb.wallapop.command;

import com.lmb.wallapop.Rover;
import com.lmb.wallapop.exception.MapException;

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

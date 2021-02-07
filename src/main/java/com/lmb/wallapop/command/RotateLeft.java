package com.lmb.wallapop.command;

import com.lmb.wallapop.Rover;

public class RotateLeft implements Command {

	private Rover rover;

	public RotateLeft(Rover rover) {
		super();
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.rotateLeft();
	}

}

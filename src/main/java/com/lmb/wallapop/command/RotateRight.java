package com.lmb.wallapop.command;

import com.lmb.wallapop.Rover;

public class RotateRight implements Command {

	private Rover rover;

	public RotateRight(Rover rover) {
		super();
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.rotateRight();
	}

}

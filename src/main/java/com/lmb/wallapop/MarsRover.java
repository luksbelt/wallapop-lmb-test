package com.lmb.wallapop;

import com.lmb.wallapop.controller.InitController;
import com.lmb.wallapop.controller.MoveController;
import com.lmb.wallapop.rover.Rover;

public class MarsRover {

	public static void main(String[] args) throws Exception {
		Rover rover = new InitController().init();
		MoveController controller = new MoveController(rover);
		controller.start();
    }
}

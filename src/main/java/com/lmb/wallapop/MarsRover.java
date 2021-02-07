package com.lmb.wallapop;

import com.lmb.wallapop.controller.InitController;
import com.lmb.wallapop.controller.MoveController;
import com.lmb.wallapop.exception.MapException;
import com.lmb.wallapop.rover.Rover;

public class MarsRover {

	public static void main(String[] args) throws MapException {
		Rover rover = new InitController().init();
		new MoveController(rover).start();
    }
}

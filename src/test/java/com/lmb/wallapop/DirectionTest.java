package com.lmb.wallapop;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lmb.wallapop.rover.Direction;


public class DirectionTest {

	private Direction direction;
	
	@Test
	public void testLeft() {
		direction = Direction.N;
		assertEquals(Direction.W, direction.left());
	}

	@Test
	public void testRigth() {
		direction = Direction.N;
		assertEquals(Direction.E, direction.right());
	}

	@Test
	public void testBack() {
		direction = Direction.N;
		assertEquals(Direction.S, direction.back());
	}
}

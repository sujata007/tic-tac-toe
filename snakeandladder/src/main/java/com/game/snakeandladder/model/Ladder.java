package com.game.snakeandladder.model;

import com.game.snakeandladder.excepption.SnakesAndLaddersException;

public class Ladder extends Jumper {

	public Ladder(int startPoint, int endPoint, boolean isLadder) {
		super(startPoint, endPoint, isLadder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidPosition(int cellPosition) throws SnakesAndLaddersException {
		// TODO Auto-generated method stub
		return true;
	}

}

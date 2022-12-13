package com.game.snakeandladder.model;

import com.game.snakeandladder.excepption.SnakesAndLaddersException;

public abstract class Jumper {
	public int startPos;
	public int endPos;
	public boolean isLadder;

	public Jumper(int startPoint, int endPoint, boolean isLadder) {
		this.startPos = startPoint;
		this.endPos = endPoint;
		this.isLadder = isLadder;
	}
	public int getStartPosition() {
        return startPos;
    }
	public int getEndPosition() {
        return endPos;
    }
	public abstract boolean isValidPosition(int cellPosition) throws SnakesAndLaddersException;
}

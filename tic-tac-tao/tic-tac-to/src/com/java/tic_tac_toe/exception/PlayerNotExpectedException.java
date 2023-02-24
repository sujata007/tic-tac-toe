package com.java.tic_tac_toe.exception;

public class PlayerNotExpectedException extends RuntimeException {
	private static final long serialVersionUID = 6171978443681353425L;

	public PlayerNotExpectedException(String message) {
		super(message);
	}

}

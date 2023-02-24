package com.java.tic_tac_toe.exception;

public class PlayerLimitExceedException extends RuntimeException {
	private static final long serialVersionUID = 6171978443681353425L;

	public PlayerLimitExceedException(String message) {
		super(message);
	}

}

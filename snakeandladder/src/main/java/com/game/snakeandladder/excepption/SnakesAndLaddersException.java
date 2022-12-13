package com.game.snakeandladder.excepption;


public class SnakesAndLaddersException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExceptionType exceptionType;
	private String message;
	public SnakesAndLaddersException(ExceptionType type, String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.exceptionType = type;
		this.message = message;
	}
	
}

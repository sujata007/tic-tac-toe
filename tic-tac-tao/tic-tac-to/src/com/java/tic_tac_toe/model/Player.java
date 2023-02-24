package com.java.tic_tac_toe.model;

public class Player {
	private String playerName;
	private int playerId;
	private char playerSymbol;

	public Player(String playerName, int playerId, char playerSymbol) {
		this.playerName = playerName;
		this.playerId = playerId;
		this.playerSymbol = playerSymbol;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public char getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(char playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
}

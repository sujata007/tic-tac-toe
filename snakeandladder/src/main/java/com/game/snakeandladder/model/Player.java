package com.game.snakeandladder.model;

public class Player {
	private int position;
	private String playerName;
	private int id;
	public Player( int position,String playerName,int id) {
		this.id = id;
		this.playerName =playerName;
		this.position = position;
	}
	public int getPosition() {
		return position;
	}
	public String getPlayerName() {
		return playerName;
	}
	public int getId() {
		return id;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

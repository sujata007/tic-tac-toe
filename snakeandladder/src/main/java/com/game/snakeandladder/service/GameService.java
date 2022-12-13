package com.game.snakeandladder.service;

import java.util.Queue;

import com.game.snakeandladder.datastore.GameData;
import com.game.snakeandladder.model.Board;
import com.game.snakeandladder.model.Player;

public interface GameService {

	public String launchGame();

	public Queue<Player> getWinners();

	public Queue<Player> getPlayers();

	public Board getBoard();

	public void addPlayer(String player);

	public String nextTurn();
}

package com.game.snakeandladder;

import com.game.snakeandladder.service.GameService;
import com.game.snakeandladder.service.GameServiceImpl;


public class SnakeandladderApplication {

	public static void main(String[] args) {
		GameService game = new GameServiceImpl(1,5);
		game.addPlayer("A");
		game.addPlayer("B");
		game.addPlayer("C");
		game.launchGame();
	}

}

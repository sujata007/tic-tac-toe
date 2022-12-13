package com.game.snakeandladder.service;

import com.game.snakeandladder.model.Dice;
import com.game.snakeandladder.model.Player;

public class PlayerServiceImpl implements PlayerService {
	//GameData gameData;
	private static final int DEFAULT_DICES = 1;
	Dice dice;
	PlayerServiceImpl(){
		 this.dice = new Dice(DEFAULT_DICES);
	}
	@Override
	public int rollDice(Player player) {
		// TODO Auto-generated method stub
		
		int diceNo = dice.rollDice();
		return diceNo;

	}

}

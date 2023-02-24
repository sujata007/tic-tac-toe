package com.java.tic_tac_toe.config;

import com.java.tic_tac_toe.model.Player;
import com.java.tic_tac_toe.service.TicTacToeStrategy;

public class Context {
	TicTacToeStrategy tictactoe;

	Context(TicTacToeStrategy tictactoe) {
		this.tictactoe = tictactoe;
	}

	public void addPlayer(Player player) {
		tictactoe.addPlayer(player);
	}

	public int playGame(int row, int col, int playerId) {
		return tictactoe.move(row, col, playerId);
	}
}

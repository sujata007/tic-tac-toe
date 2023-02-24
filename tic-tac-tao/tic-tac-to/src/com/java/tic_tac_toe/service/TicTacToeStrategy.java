package com.java.tic_tac_toe.service;

import com.java.tic_tac_toe.model.Player;

public interface TicTacToeStrategy {
	public int move(int row, int col, int player);

	public void addPlayer(Player player);
}

package com.java.tic_tac_toe.service;

import java.util.LinkedList;
import java.util.Queue;

import com.java.tic_tac_toe.exception.PlayerLimitExceedException;
import com.java.tic_tac_toe.exception.PlayerNotExpectedException;
import com.java.tic_tac_toe.model.Player;

public class SimpleTicTacToeStrategy implements TicTacToeStrategy {
	int rows[];
	int cols[];
	int diagonls;
	int antiDiagonals;
	Queue<Player> players;
	int n;

	public SimpleTicTacToeStrategy(int n) {
		this.rows = new int[n];
		this.cols = new int[n];
		this.diagonls = 0;
		this.antiDiagonals = 0;
		this.players = new LinkedList<>();
		this.n = n;
	}

	@Override
	public int move(int row, int col, int player) {
		// TODO Auto-generated method stub
		if(player!=players.peek().getPlayerId()) {
			throw new PlayerNotExpectedException("This turn doesn't belog to player " +player);
		}
		if(!players.isEmpty()) {
			players.add(players.poll());
		}
		int currentPlayer = (player==1)?1:-1;
        //check if the palyer wins
        rows[row]+=currentPlayer;
        cols[col]+=currentPlayer;
        if(row==col){
        	diagonls+=currentPlayer;
        }
        if(row==n-col-1){
        	antiDiagonals+=currentPlayer;
        }
        if(Math.abs(rows[row])==n ||Math.abs(cols[col])==n
        || Math.abs(diagonls)==n || Math.abs(antiDiagonals)==n){
            return player;
        }
        return 0;
	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		if(players.size()>2) {
			throw new PlayerLimitExceedException("Player limit is only 2");	
		}
		players.add(player);
	}
	

}

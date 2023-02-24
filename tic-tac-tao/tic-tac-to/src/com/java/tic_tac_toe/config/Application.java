package com.java.tic_tac_toe.config;

import com.java.tic_tac_toe.model.Player;
import com.java.tic_tac_toe.service.SimpleTicTacToeStrategy;

public class Application {
	public static void main(String args[]) {
		Context context = new Context(new SimpleTicTacToeStrategy(3));
		Player p1 = new Player("Sujata", 1,'X');
		Player p2 = new Player("Rishiraj", 2,'O');
		context.addPlayer(p1);
		context.addPlayer(p2);
		boolean win;
		win = context.playGame(0, 0, 1)==0?false:true;
		System.out.println("Game over "+ win);
		win = context.playGame(1, 0, 2)==0?false:true;
		System.out.println("Game over "+ win);
		win = context.playGame(0, 1, 1)==0?false:true;
		System.out.println("Game over "+ win);
		win = context.playGame(1, 1, 2)==0?false:true;
		System.out.println("Game over "+ win);
		win = context.playGame(0, 2, 1)==0?false:true;
		System.out.println("Game over "+ win);
	}
}

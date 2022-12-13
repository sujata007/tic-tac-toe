package com.game.snakeandladder.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.game.snakeandladder.model.Ladder;
import com.game.snakeandladder.model.Player;
import com.game.snakeandladder.model.Snake;

import lombok.Getter;

@Component
@Getter
public class GameData {
	private List<Player> listOfPlayer;
	private List<Snake> snakesInBoard;
	private List<Ladder> ladderInBoard;
	private HashMap<Integer, Snake> posToSnakes;
	private HashMap<Integer, Ladder> posToLadder;
	private HashMap<Integer, Player> idToPlayer;

	public GameData() {
		listOfPlayer = new ArrayList<>();
		snakesInBoard = new ArrayList<>();
		ladderInBoard = new ArrayList<>();
		posToSnakes = new HashMap<>();
		posToLadder = new HashMap<>();
		idToPlayer = new HashMap<>();
	}

	public void addPlayers(Player player) {
		listOfPlayer.add(player);
		idToPlayer.put(player.getId(), player);
	}

	public void setUpSnakes() {
		Snake s1 = new Snake(17, 7,false);
		snakesInBoard.add(s1);
		posToSnakes.put(17,s1);
		//posToSnakes.put(7,s1);
		
		Snake s2 = new Snake(54, 34,false);
		snakesInBoard.add(s2);
		posToSnakes.put(54,s2);
		//posToSnakes.put(34,s2);
		
		Snake s3 = new Snake(62, 19,false);
		snakesInBoard.add(s3);
		posToSnakes.put(62,s3);
		//posToSnakes.put(19,s3);
		
		Snake s4 = new Snake(64, 60,false);
		snakesInBoard.add(s4);
		posToSnakes.put(64,s4);
		//posToSnakes.put(60,s4);
		
		Snake s5 = new Snake(87, 45,false);
		snakesInBoard.add(s5);
		posToSnakes.put(87,s5);
		//posToSnakes.put(45,s5);
		
		Snake s6 = new Snake(93, 73,false);
		snakesInBoard.add(s6);
		posToSnakes.put(93,s6);
		//posToSnakes.put(73,s6);
		
		Snake s7 = new Snake(94, 75,false);
		snakesInBoard.add(s7);
		posToSnakes.put(94,s7);
		//posToSnakes.put(75,s7);
		
		Snake s8 = new Snake(98, 79,false);
		snakesInBoard.add(s8);
		posToSnakes.put(98,s8);
		//posToSnakes.put(79,s8);

	}

	public void setUpLadders() {
		Ladder l1 = new Ladder(1, 38,true);
		ladderInBoard.add(l1);
		posToLadder.put(1, l1);
		//posToLadder.put(38, l1);
		
		Ladder l2 = new Ladder(4, 14,true);
		ladderInBoard.add(l2);
		posToLadder.put(4, l2);
		//posToLadder.put(14,l2);
		
		Ladder l3 = new Ladder(9, 31,true);
		ladderInBoard.add(l3);
		posToLadder.put(9, l3);
		//posToLadder.put(31,l3);
		
		Ladder l4 = new Ladder(21, 42,true);
		ladderInBoard.add(l4);
		posToLadder.put(21, l4);
		//posToLadder.put(42,l4);
		
		Ladder l5 = new Ladder(28, 84,true);
		ladderInBoard.add(l5);
		posToLadder.put(28, l5);
		//posToLadder.put(84,l5);
		
		Ladder l6 = new Ladder(51, 67,true);
		ladderInBoard.add(l6);
		posToLadder.put(51, l6);
		//posToLadder.put(67,l6);
		
		Ladder l7 = new Ladder(72, 91,true);
		ladderInBoard.add(l7);
		posToLadder.put(72, l7);
		//posToLadder.put(91,l7);
		
		Ladder l8 = new Ladder(80, 99,true);
		ladderInBoard.add(l8);
		posToLadder.put(80, l8);
		//posToLadder.put(99,l8);
	}
}

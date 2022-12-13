package com.game.snakeandladder.service;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.snakeandladder.datastore.GameData;
import com.game.snakeandladder.excepption.ExceptionType;
import com.game.snakeandladder.excepption.SnakesAndLaddersException;
import com.game.snakeandladder.model.Board;
import com.game.snakeandladder.model.Jumper;
import com.game.snakeandladder.model.Player;
@Service
public class GameServiceImpl implements GameService {
    Board board;
    PlayerService playerService;
	Queue<Player> players;
	Queue<Player> winners;
	int size;
	int diceCount;
	int dimensions;
	GameData gameData;
	
	public GameServiceImpl(int diceCount, int dimensions) {
		players = new LinkedList<Player>();
		winners = new LinkedList<Player>();
		this.size = dimensions*dimensions;
		this.diceCount = diceCount;
		this.dimensions = dimensions;
		this.playerService = new PlayerServiceImpl();
		this.gameData = new GameData();
		this.board = new Board(gameData);
	}
	@Override
	public String launchGame() {
		// TODO Auto-generated method stub
		while(players.size()>1) {
			Player currPlayer = players.poll();
			System.out.println();
			System.out.println(currPlayer.getPlayerName()+"'s turn.");
			int diceValue = playerService.rollDice(currPlayer);
			makeMove(currPlayer,diceValue);
			
		}
		
		return "Player" + getPlayers().peek().getId() + " Roll the Dice";
		

	}
	@Override
	public void addPlayer(String player) {
		if (gameData.getListOfPlayer().size() < 5) {
			Player p = new Player(0, player, gameData.getListOfPlayer().size() + 1);
			players.add(p);
			gameData.addPlayers(p);
		} else {
			throw new SnakesAndLaddersException(ExceptionType.PLAYER_EXCEEDED, "Players in the game exceeded 5");
		}

	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Queue<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Queue<Player> players) {
		this.players = players;
	}
	public Queue<Player> getWinners() {
		return winners;
	}
	
	public void setWinners(Queue<Player> winners) {
		this.winners = winners;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public String nextTurn() {
		// TODO Auto-generated method stub		
		return getPlayers().peek().getPlayerName()+ " Plays the next turn";
	}
	public void makeMove(Player currPlayer,int diceNo) {
			
			int nextPos = currPlayer.getPosition() + diceNo;
			
			Board board = getBoard();
			boolean isSnakeOrLadder = board.hasSnakeOrLadder(nextPos);
			if(isSnakeOrLadder) {
				Jumper jump = board.getEntity(nextPos);
				nextPos = jump.endPos;
			}
			if(nextPos==100) {
				getWinners().add(currPlayer);
				 System.out.print("Player" + currPlayer.getId() + "is Winner");
				 return;
			}else if(nextPos<1) {
				nextPos = 0;
			}else if(nextPos>100) {
				nextPos = currPlayer.getPosition();
			}
			getPlayers().add(currPlayer);
			currPlayer.setPosition(nextPos);
			System.out.print("Player" + currPlayer.getId() + "has moved to " + nextPos);
			return;
		
	}


}

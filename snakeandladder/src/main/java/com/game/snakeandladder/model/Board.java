package com.game.snakeandladder.model;

import java.util.HashMap;

import com.game.snakeandladder.datastore.GameData;
public class Board {
	HashMap<Integer, Jumper> cells;
	int cellCount;
	GameData gameData;

	public Board(GameData getGameData) {
		this.gameData = getGameData;
		cells = new HashMap<Integer, Jumper>();
		for (int idx = 1; idx <= 100; idx++) {
			if (!hasSnakeOrLadder(idx)) {
				if (getGameData.getPosToSnakes().containsKey(idx)) {
					setEntity(idx, getGameData.getPosToSnakes().get(idx));
				} else if (getGameData.getPosToLadder().containsKey(idx)) {
					setEntity(idx, getGameData.getPosToLadder().get(idx));
				}

			}

		}
	}

	private void setEntity(int index, Jumper e) {
		cells.put(index, e);
	}

	public Jumper getEntity(int index) {
		if (hasSnakeOrLadder(index)) {
			return this.cells.get(index);
		}
		return null;
	}

	public boolean hasSnakeOrLadder(int cellIndex) {
		return cells.containsKey(cellIndex);
	}

}

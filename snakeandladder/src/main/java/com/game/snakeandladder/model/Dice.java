package com.game.snakeandladder.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Dice {
	private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int rollDice(){
        return ((int) (Math.random()*(6*numberOfDice - 1*numberOfDice))) + 1;
    }
}

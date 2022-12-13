package com.game.snakeandladder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.game.snakeandladder.model.Player;
import com.game.snakeandladder.service.PlayerService;

@RestController
public class PlayerController {
	
	PlayerService playerService;
	@Autowired
	PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@PostMapping(value = "/game/rollDice")
	public void rollDice(@RequestBody Player playerName) {
		playerService.rollDice(playerName);
	}
}


//Add players-> 
//launchGame->
//rollDice

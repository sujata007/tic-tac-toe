package com.game.snakeandladder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.game.snakeandladder.service.GameService;

@RestController
public class GameController {
	@Autowired
	GameService gameService;

	@PostMapping(value = "/game/launch")
	@ResponseStatus(HttpStatus.CREATED)
	public String launchGame() {
		return gameService.launchGame();
	}

	@GetMapping(value = "/game/next/Turn")
	public String nextTurn() {
		return gameService.nextTurn();
	}

	@PostMapping(value = "/game/{player}/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPlayer(@RequestParam String player) {
		gameService.addPlayer(player);
	}
}
// getCurrentGame->
// getCurrentPlayer
package com.jm.marvel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jm.marvel.integration.CharactersClient;
import com.jm.marvel.model.Characters;
import com.jm.marvel.model.CharactersData;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CharactersController {

	private CharactersClient charactersService;

	public CharactersController(CharactersClient charactersService) {
		this.charactersService = charactersService;
	}

	@ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/characters")
	public Flux<CharactersData> getCaracters() {
		return charactersService.getCharacters();
	}

	@ApiOperation(value = "Get characters by ID", notes = "Provides characters by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of character", response = Characters.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/characters/{characterId}")
	public Mono<CharactersData> getCharactersById(@PathVariable("characterId") int id) {
		return charactersService.getCharactersById(id);
	}

}

package com.jm.marvel.integration;

import com.jm.marvel.model.CharactersData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CharactersClient {
	
	public Flux<CharactersData> getCharacters();
	public Mono<CharactersData> getCharactersById(int id);
	public Mono<CharactersData> getCharactersPowers(int id);
}

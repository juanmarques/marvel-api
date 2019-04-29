package com.jm.marvel.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jm.marvel.integration.CharactersClient;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private CharactersClient charactersService;

	public AppRunner(CharactersClient charactersService) {
		this.charactersService = charactersService;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Loading characters from marvel api and caching");
		charactersService.getCharacters().subscribe();
	}
}

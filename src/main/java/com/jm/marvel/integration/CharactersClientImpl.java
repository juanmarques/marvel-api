package com.jm.marvel.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jm.marvel.model.CharactersData;
import com.jm.marvel.util.CharactersUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CharactersClientImpl implements CharactersClient {

	private WebClient webClient;
	
	@Value("${marvelApiPublicKey}")
	public String publicKey;
	@Value("${marvelApiPrivateKey}")
	public String privateKey;

	public CharactersClientImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://gateway.marvel.com:443/v1/public/").build();
	}

	@Cacheable(value = "characters")
	@Override
	public Flux<CharactersData> getCharacters() {
	
		return this.webClient.get()
               .uri(uriBuilder -> uriBuilder.path("/characters")
	                .queryParam("ts",  CharactersUtil.timeStamp)
	                .queryParam("apikey",publicKey)
	                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey,CharactersUtil.timeStamp))
	                .build())
	                .retrieve()
	                .bodyToFlux(CharactersData.class).cache().retry();
	}

	@Override
	public Mono<CharactersData> getCharactersById(int id) {		
		return this.webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/characters/" + id)
	                .queryParam("ts",  CharactersUtil.timeStamp)
	                .queryParam("apikey",publicKey)
	                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey,CharactersUtil.timeStamp))
	                .build())
					.retrieve()
					.bodyToMono(CharactersData.class).retry();
	}

	///TODO need to implement the chracters power
	@Override
	public Mono<CharactersData> getCharactersPowers(int id) {
		
		return null;
	}
}

package com.wpaul15.omniscienttutorapi.routes.deck;

import java.net.URI;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DeckHandler {

  public Mono<ServerResponse> getDeck(ServerRequest request) {
    return ServerResponse.ok().build();
  }

  public Mono<ServerResponse> getAllDecks(ServerRequest request) {
    return ServerResponse.ok().build();
  }

  public Mono<ServerResponse> createDeck(ServerRequest request) {
    return ServerResponse.created(URI.create(String.format("%s/%d", request.uri(), 1))).build();
  }

  public Mono<ServerResponse> updateDeck(ServerRequest request) {
    return ServerResponse.ok().build();
  }

  public Mono<ServerResponse> deleteDeck(ServerRequest request) {
    return ServerResponse.noContent().build();
  }
}

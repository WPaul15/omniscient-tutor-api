package com.wpaul15.omniscienttutorapi.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.wpaul15.omniscienttutorapi.routes.deck.DeckHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class RouterConfig {

  private static final RequestPredicate ACCEPT_JSON = accept(MediaType.APPLICATION_JSON);
  private static final RequestPredicate ACCEPT_AND_CONTENT_TYPE_JSON =
      accept(MediaType.APPLICATION_JSON).and(contentType(MediaType.APPLICATION_JSON));

  @Bean
  public RouterFunction<ServerResponse> deckRouter(DeckHandler deckHandler) {
    return route()
        .POST("/decks", ACCEPT_AND_CONTENT_TYPE_JSON, deckHandler::createDeck)
        .GET("/decks/{deckId}", ACCEPT_JSON, deckHandler::getDeck)
        .GET("/decks", ACCEPT_JSON, deckHandler::getAllDecks)
        .PUT("/decks/{deckId}", ACCEPT_AND_CONTENT_TYPE_JSON, deckHandler::updateDeck)
        .DELETE("/decks/{deckId}", ACCEPT_JSON, deckHandler::deleteDeck)
        .build();
  }
}

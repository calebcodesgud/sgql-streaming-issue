package com.example.graphqltester;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.graphql.client.WebSocketGraphQlClient;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SubscriptionControllerTest {

    @Test
    void getFluxOfObjects() {
        // run this test with the application running from local
        final WebClient webclient = WebClient.builder().baseUrl("http://localhost:8080/graphql").build();
        webclient.post().contentType(MediaType.APPLICATION_JSON).body(Mono.just(
                new GraphqlRequest("subscription getFluxOfObjects { getFluxOfObjects { numer } }")
        ), GraphQLRequest.class)
                .retrieve().bodyToFlux(String.class).doOnNext(each -> log.info("{}", each)).blockLast();
    }

    @Test
    void getFluxOfObjectsWebSocket() {
        // run this test with the application running from local
        final WebSocketGraphQlClient client = WebSocketGraphQlClient.builder("ws://localhost:8080/graphql", new ReactorNettyWebSocketClient()).build();
        client.start().block();
        client.documentName("test").executeSubscription().doOnNext(each -> log.info("{}", each)).blockLast();
        client.stop().block();
    }
}
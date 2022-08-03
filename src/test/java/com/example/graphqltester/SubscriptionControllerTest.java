package com.example.graphqltester;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@Slf4j
@GraphQlTest(SubscriptionController.class)
class SubscriptionControllerTest {

	@Autowired
	private GraphQlTester graphQlTester;


	@Test
	void getFluxOfObjects() {
		Flux<Integer> ints = this.graphQlTester.documentName("fluxOfObjects")
				.executeSubscription()
				.toFlux("getFluxOfObjects.numer", Integer.class);

		StepVerifier.create(ints)
				.expectNextCount(10)
				.verifyComplete();
	}

}
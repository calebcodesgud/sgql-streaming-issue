package com.example.graphqltester;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class SubscriptionController {

	@SubscriptionMapping
	public Flux<Result> getFluxOfObjects(@Argument Integer count) {
		return Flux.range(0, count).map(Result::new)
				.doOnSubscribe(sub ->
						log.info("getFluxOfObjects requested")
				)
				.doOnNext(value -> log.info("Sending value: " + value))
				.doOnTerminate(() -> log.info("done"));
	}

}

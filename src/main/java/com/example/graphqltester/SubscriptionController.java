package com.example.graphqltester;

import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Slf4j
@Controller
public class SubscriptionController {

    @SubscriptionMapping
    public Flux<Result> getFluxOfObjects(final DataFetchingEnvironment env) {
        // used the data fetching env here because its also used in the actual query i first noticed this issue on
        return Flux.range(0, env.getSelectionSet().getImmediateFields().toString().length() ).map(Result::new).doOnSubscribe(sub ->
            log.info("getFluxOfObjects requested")
        ).doOnTerminate(() -> log.info("done"));
    }

}

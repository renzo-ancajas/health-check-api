package com.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;

import reactor.core.publisher.Mono;

public class DownstreamServiceHealthIndicator implements ReactiveHealthIndicator {

	@Override
    public Mono<Health> health() {
        return checkDownstreamServiceHealth().onErrorResume(
          ex -> Mono.just(new Health.Builder().down(ex).build())
        );
    }

    private Mono<Health> checkDownstreamServiceHealth() {
        // could use WebClient to check health reactively
        return Mono.just(new Health.Builder().up().build());
    }

}

package com.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;

public class CustomHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.up()
			.withDetail("app", "Up and running.")
			.withDetail("error", "Error, Something went wrong");
	}

}

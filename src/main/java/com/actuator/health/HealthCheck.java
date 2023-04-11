package com.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("myBasicHealthCheck")
public class HealthCheck implements HealthIndicator {
	
	private static final String URL = "https://jsonplaceholder.typicode.com/todos";

	@Override
	public Health health() {
		int errorCode = checkServiceHealth();
		if (errorCode != 0) {
			return Health.down()
					.withDetail("Error Code:: ", errorCode).build();
		}
		return Health.up().build();
	}
	
	public int checkServiceHealth() {
		// logic to check health here
		return 0;
	}

}

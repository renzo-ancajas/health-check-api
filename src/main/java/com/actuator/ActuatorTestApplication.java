package com.actuator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.actuator.model.User;
import com.actuator.repository.UserRepository;


@SpringBootApplication
public class ActuatorTestApplication {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ActuatorTestApplication.class, args);
	}
	@Bean
	InitializingBean populateUsers() {
		return () -> {
			userRepository.deleteAll();
			userRepository.save(User.builder().firstName("Roger").lastName("Federer").profileURL("http://linkin.com/576567").build());
			userRepository.save(User.builder().firstName("Rafal").lastName("Nadal").build());
			userRepository.save(User.builder().firstName("Novak").lastName("Djokovik").build());
		};
	}
}

package com.actuator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
		return http.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/actuator/**").permitAll()
				.anyRequest().authenticated()
				.and().build();
	}

}

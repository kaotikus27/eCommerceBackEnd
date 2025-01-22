package com.hercodecommerce.demo.config;

import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//protect the end point /api/orders
		http.authorizeRequests(configurer -> 
				configurer.requestMatchers("/api/orders/**")
				.authenticated())
				.oauth2ResourceServer()
				.jwt();		
		
		//add CORS filters
		http.cors();
		
		// add content negotiation strategy
		http.setSharedObject(ContentNegotiationStrategy.class, 
				new HeaderContentNegotiationStrategy());
		
		// force a non-empty response body for 401's to make the response more friendly
		Okta.configureResourceServer401ResponseBody(http);
		
		return http.build();
	}
	
}

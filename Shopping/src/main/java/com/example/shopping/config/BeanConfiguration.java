package com.example.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class BeanConfiguration {

	@Bean
	Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}
}

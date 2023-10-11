package com.example.shopping.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

	@Bean
	Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}
}

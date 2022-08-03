package com.example.graphqltester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.graphql.servlet.GraphQlWebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class GraphqlTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlTesterApplication.class, args);
	}

}

package com.whut.lost_found;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LostFoundApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostFoundApplication.class, args);
	}
}

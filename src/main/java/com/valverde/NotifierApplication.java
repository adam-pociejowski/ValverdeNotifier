package com.valverde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@SpringBootApplication
@RestController
public class NotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifierApplication.class, args);
	}

	@GetMapping("/")
	public Map<String, String> dos() {
		Map<String, String> map = new HashMap<>();
		map.put("user", env.getProperty("security.user.name"));
		map.put("password", env.getProperty("security.user.password"));
		return map;
	}

	@Autowired
	private Environment env;
}

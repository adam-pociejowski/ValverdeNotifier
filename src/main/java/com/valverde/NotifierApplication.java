package com.valverde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@EnableScheduling
@SpringBootApplication
@RestController
public class NotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifierApplication.class, args);
	}

	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
//
//public class NotifierApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(NotifierApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(NotifierApplication.class, args);
//	}
//
//	@GetMapping("/user")
//	public Principal user(Principal user) {
//		return user;
//	}
//}
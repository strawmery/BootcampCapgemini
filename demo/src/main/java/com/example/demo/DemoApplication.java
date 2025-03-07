package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	Service service;

	@Override
	public void run(String... args) throws Exception {
		service.guardar();
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("CommandLineRunner running");
		};
	}


}

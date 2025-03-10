package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dependencias {
	@Bean
	Repository repositorio(Configuracion config, Registro registro) {
		System.err.println("soy el bean");
		//return new RepositorioMock();
		return new RepositoryImpl(config, registro);
	}
	@Bean
	Repository repo1(Configuracion config, Registro registro) {
		return new RepositoryImpl(config, registro);
	}
	@Bean
	Repository repo2() {
		return new RepositoryMock();
	}
}

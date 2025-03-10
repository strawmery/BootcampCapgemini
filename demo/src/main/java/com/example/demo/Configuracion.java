package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Configuracion {
    public Configuracion() {
        System.out.println("Configuracion created");
    }

    public void init() {
		System.err.println("Configuracion inicializada");
	}

}

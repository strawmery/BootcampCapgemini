package com.example.demo;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Repository;

//@Repository
//@Qualifier("verdad")
public class RepositoryImpl implements com.example.demo.Repository {
	public RepositoryImpl(Configuracion config, Registro registro) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void guardar() {
		System.err.println("Guardando");
	}
}

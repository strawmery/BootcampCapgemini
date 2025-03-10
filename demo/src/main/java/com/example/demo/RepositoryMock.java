package com.example.demo;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Repository;

//@Qualifier("mentira")
//@Repository
//@Primary
public class RepositoryMock implements com.example.demo.Repository {
	@Override
	public void guardar() {
		System.err.println("Guardando de mentira");
	}
}

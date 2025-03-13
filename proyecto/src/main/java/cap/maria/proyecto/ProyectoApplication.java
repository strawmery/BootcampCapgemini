package cap.maria.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cap.maria.proyecto.Repositories.ActorRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner running");
		exampleData();
	}

	@Autowired
	private ActorRepository dao;

	private void exampleData(){
		dao.findAll().forEach(System.out::println);
	}

}

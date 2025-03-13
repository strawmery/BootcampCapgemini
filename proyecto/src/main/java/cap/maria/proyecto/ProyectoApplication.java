package cap.maria.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cap.maria.proyecto.Entities.Actor;
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
		// var actor = new Actor(0,"zendaya", "ejemplo");
		// dao.save(actor);
		var item = dao.findById(204);
		if(item.isPresent()){
			var actor = item.get();
			actor.setFirstName("Zendaya");
			actor.setLastName(actor.getLastName().toUpperCase());
			dao.save(actor);
		}else{
			System.out.println("actor not found");
		}
		dao.findAll().forEach(System.out::println);
		dao.deleteById(204);
		dao.findAll().forEach(System.out::println);
	}

}

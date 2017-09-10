package rgc.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rgc.backend.aop.Person;
import rgc.backend.aop.PersonService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private PersonService service;

	@Autowired
	private Person person;

	@Override
	public void run(String... args) throws Exception {
		service.getFullName(person);
	}
}

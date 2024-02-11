package papillon.colibri.corbeau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"papillon.colibri.corbeau.basetest.repositories"})
public class CoccinelleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoccinelleApplication.class, args);
	}

}

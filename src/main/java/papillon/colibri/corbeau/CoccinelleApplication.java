package papillon.colibri.corbeau;

import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoccinelleApplication implements AppShellConfigurator {
	public static void main(String[] args) {
		SpringApplication.run(CoccinelleApplication.class, args);
	}
}

package bdbt_bada_project.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		DatabseController db = new DatabseController();
		SpringApplication.run(Application.class, args);
	}
}

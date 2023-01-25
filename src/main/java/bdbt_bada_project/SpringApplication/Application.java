package bdbt_bada_project.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		DatabseController db = new DatabseController();
		String q = "select * from tab;";
		try {
			db.select(q);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		SpringApplication.run(Application.class, args);
	}
}

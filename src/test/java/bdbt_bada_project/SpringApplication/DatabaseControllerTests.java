package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DatabaseControllerTests {
	@Test
	void driverPresent() {
		assertDoesNotThrow(() -> new DatabaseController());
	}
}

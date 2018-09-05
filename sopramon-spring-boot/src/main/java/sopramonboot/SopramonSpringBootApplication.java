package sopramonboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("sopramonbis.model")
public class SopramonSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SopramonSpringBootApplication.class, args);
	}
}

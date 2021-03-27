package stud.summits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SummitsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SummitsApplication.class, args);
	}
}

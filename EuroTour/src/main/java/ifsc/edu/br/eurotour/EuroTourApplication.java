package ifsc.edu.br.eurotour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EuroTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);
	}
}

package br.com.hospital.wesley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class WesleyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WesleyApplication.class, args);
	}

}

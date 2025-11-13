package br.com.futurodotrabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FuturodotrabalhoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FuturodotrabalhoApplication.class, args);
	}

}

package br.com.rfoliveira.clientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ClientApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClientApiApplication.class, args);

	}

}

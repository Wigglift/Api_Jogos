package br.edu.infnet.isaacApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IsaacApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsaacApiApplication.class, args);
	}

}

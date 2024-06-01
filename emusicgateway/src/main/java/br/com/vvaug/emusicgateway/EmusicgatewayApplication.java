package br.com.vvaug.emusicgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmusicgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmusicgatewayApplication.class, args);
	}
}

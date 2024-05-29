package br.com.vvaug.emusicgateway;

import br.com.vvaug.emusicgateway.config.RouteConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmusicgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmusicgatewayApplication.class, args);
	}

	@Bean
	public RouteConfiguration routeConfiguration(){
		return new RouteConfiguration();
	}
}

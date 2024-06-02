package br.com.vvaug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmusicUserDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmusicUserDsApplication.class, args);
	}

}

package br.com.vvaug.emusicservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmusicServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmusicServiceDiscoveryApplication.class, args);
	}

}

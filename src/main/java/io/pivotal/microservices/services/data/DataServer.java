package io.pivotal.microservices.services.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Users data-server. Works as a microservice client, fetching data from the
 * User-Service. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 * @author Paul Chapman
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DataServer {


	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 *
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for user-server.properties or
		// user-server.yml
		System.setProperty("spring.config.name", "data-server");

		SpringApplication.run(io.pivotal.microservices.services.data.DataServer.class, args);
	}
}

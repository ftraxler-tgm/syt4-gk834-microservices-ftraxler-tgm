package io.pivotal.microservices.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
<<<<<<< HEAD
 * Users web-server. Works as a microservice client, fetching data from the
=======
 * Accounts web-server. Works as a microservice client, fetching data from the
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2
 * User-Service. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 * @author Paul Chapman
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class WebServer {

	/**
	 * URL uses the logical name of user-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String UserS_SERVICE_URL = "http://UserS-SERVICE";

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton" 
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * The UserService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
	@Bean
	public WebUserService usersService() {
		return new WebUserService(UserS_SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link WebUserService} to use.
	 * 
	 * @return
	 */
	@Bean
	public WebUserController usersController() {
		return new WebUserController(usersService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}

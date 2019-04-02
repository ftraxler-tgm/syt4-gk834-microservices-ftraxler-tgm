package io.pivotal.microservices.services.user;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/user/UserServer.java
import io.pivotal.microservices.user.UserRepository;
import io.pivotal.microservices.user.UsersConfiguration;
=======
import io.pivotal.microservices.accounts.UserRepository;
import io.pivotal.microservices.accounts.UserConfiguration;
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/accounts/AccountsServer.java

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/user/UserServer.java
 * {@link UsersConfiguration}. This is a deliberate separation of concerns.
=======
 * {@link UserConfiguration}. This is a deliberate separation of concerns.
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/accounts/AccountsServer.java
 * <p>
 * This class declares no beans and current package contains no components for
 * ComponentScan to find. No point using <tt>@SptingBootApplication</tt>.
 * 
 * @author Paul Chapman
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/user/UserServer.java
@Import(UsersConfiguration.class)
public class UserServer {
=======
@Import(UserConfiguration.class)
public class AccountsServer {
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/accounts/AccountsServer.java

	@Autowired
	protected UserRepository userRepository;

	protected Logger logger = Logger.getLogger(UserServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for user-server.properties or
		// user-server.yml
		System.setProperty("spring.config.name", "users-server");

		SpringApplication.run(UserServer.class, args);
	}
}

package io.pivotal.microservices.services.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.pivotal.microservices.exceptions.UserNotFoundException;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Paul Chapman
 */
@Service
public class WebUserService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebUserService.class
			.getName());

	public WebUserService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory().getClass());
	}

<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/web/WebUserService.java
	public User findByNumber(String userNumber) {

		logger.info("findByNumber() invoked: for " + userNumber);
		return restTemplate.getForObject(serviceUrl + "/user/{number}",
				User.class, userNumber);
=======
	public User findByNumber(String accountNumber) {

		logger.info("findByNumber() invoked: for " + accountNumber);
		return restTemplate.getForObject(serviceUrl + "/accounts/{number}",
				User.class, accountNumber);
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/web/WebAccountsService.java
	}

	public List<User> byOwnerContains(String name) {
		logger.info("byOwnerContains() invoked:  for " + name);
		User[] users = null;

		try {
			users = restTemplate.getForObject(serviceUrl
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/web/WebUserService.java
					+ "/user/owner/{name}", User[].class, name);
=======
					+ "/users/owner/{name}", User[].class, name);
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/web/WebAccountsService.java
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}

		if (users == null || users.length == 0)
			return null;
		else
			return Arrays.asList(users);
	}

<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/web/WebUserService.java
	public User getByNumber(String userNumber) {
		User user = restTemplate.getForObject(serviceUrl
				+ "/user/{number}", User.class, userNumber);

		if (user == null)
			throw new UserNotFoundException(userNumber);
=======
	public User getByNumber(String accountNumber) {
		User user = restTemplate.getForObject(serviceUrl
				+ "/accounts/{number}", User.class, accountNumber);

		if (user == null)
			throw new AccountNotFoundException(accountNumber);
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/web/WebAccountsService.java
		else
			return user;
	}
}

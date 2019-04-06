package io.pivotal.microservices.user;

import java.util.List;
import java.util.logging.Logger;

import io.pivotal.microservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A RESTFul controller for accessing user information.
 *
 * @author Paul Chapman
 */
@RestController
public class UsersController {

	protected Logger logger = Logger.getLogger(UsersController.class
			.getName());
	protected UserRepository userRepository;

	/**
	 * Create an instance plugging in the respository of Users.
	 *
	 * @param userRepository
	 *            An user repository implementation.
	 */
	@Autowired
	public UsersController(UserRepository userRepository) {
		this.userRepository = userRepository;

		logger.info("UserRepository says system has "
				+ userRepository.countUsers() + " user");
	}


	/**
	 * Fetch user with the specified name. A partial case-insensitive match
	 * is supported. So <code>http://.../users/owner/a</code> will find any
	 * user with upper or lower case 'a' in their name.
	 *
	 * @param partialName
	 * @return A non-null, non-empty set of user.
	 * @throws UserNotFoundException
	 *             If there are no matches at all.
	 */
	@RequestMapping("/users/{name}")
	public List<User> byName(@PathVariable("name") String partialName) {
		logger.info("user-service byName() invoked: "
				+ userRepository.getClass().getName() + " for "
				+ partialName);

		List<User> users = userRepository.findByfnameContainingIgnoreCase(partialName);
		logger.info("user-service byName() found: " + users);

		if (users == null || users.size() == 0)
			throw new UserNotFoundException(partialName);
		else {
			return users;
		}
	}

}

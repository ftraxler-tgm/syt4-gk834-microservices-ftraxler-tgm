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
	 * Fetch an user with the specified user number.
	 * 
	 * @param userNumber
	 *            A numeric, 9 digit user number.
	 * @return The user if found.
	 * @throws UserNotFoundException
	 *             If the number is not recognised.
	 */
	@RequestMapping("/users/{userNumber}")
	public User byNumber(@PathVariable("userNumber") String userNumber) {

		logger.info("user-service byNumber() invoked: " + userNumber);
		User user = userRepository.findByNumber(userNumber);
		logger.info("user-service byNumber() found: " + user);

		if (user == null)
			throw new UserNotFoundException(userNumber);
		else {
			return user;
		}
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
	@RequestMapping("/users/owner/{name}")
	public List<User> byOwner(@PathVariable("name") String partialName) {
		logger.info("user-service byOwner() invoked: "
				+ userRepository.getClass().getName() + " for "
				+ partialName);

		List<User> users = userRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("user-service byOwner() found: " + users);

		if (users == null || users.size() == 0)
			throw new UserNotFoundException(partialName);
		else {
			return users;
		}
	}
}

package io.pivotal.microservices.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Repository for User data implemented using Spring DataServer JPA.
 * 
 * @author Paul Chapman
 */
public interface UserRepository extends Repository<User, Long> {
	/**
	 * Find an user with the specified user number.
	 *
	 * @param userNumber
	 * @return The user if found, null otherwise.
	 */
	public User findByNumber(String userNumber);

	/**
	 * Find user whose owner name contains the specified string
	 * 
	 * @param partialName
	 *            Any alphabetic string.
	 * @return The list of matching user - always non-null, but may be
	 *         empty.
	 */
	public List<User> findByNameContainingIgnoreCase(String partialName);

	/**
	 * Fetch the number of user known to the system.
	 * 
	 * @return The number of user.
	 */
	@Query("SELECT count(id) from User")
	public int countUsers();
}

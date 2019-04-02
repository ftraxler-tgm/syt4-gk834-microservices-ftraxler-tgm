package io.pivotal.microservices.user;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent user entity with JPA markup. Users are stored in an H2
 * relational database.
 * 
 * @author Paul Chapman
 */
@Entity
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/user/User.java
@Table(name = "T_User")
=======
@Table(name = "T_ACCOUNT")
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/user/User.java
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected Long id;

	protected String number;

	@Column(name = "name")
	protected String owner;

	/**
	 * This is a very simple, and non-scalable solution to generating unique
	 * ids. Not recommended for a real application. Consider using the
	 * <tt>@GeneratedValue</tt> annotation and a sequence to generate ids.
	 * 
	 * @return The next available id.
	 */
	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	/**
	 * Default constructor for JPA only.
	 */
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/user/User.java
	public User() {

=======
	protected User() {
		balance = BigDecimal.ZERO;
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/user/User.java
	}

	public User(String number, String owner) {
		id = getNextId();
		this.number = number;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	protected void setNumber(String userNumber) {
		this.number = userNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}



	@Override
	public String toString() {
		return number + " [" + owner + "]:";
	}

}

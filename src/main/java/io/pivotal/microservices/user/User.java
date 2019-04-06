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
@Table(name = "T_User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected Long id;


	@Column(name = "FNAME")
	protected String fname;

	@Column(name = "LNAME")
	protected String lname;

	@Column(name = "ROLE")
	protected String role;




	@Column(name="password")
	protected String password;

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
	public User() {

	}



	public User(String number, String fname, String lname, String role, String password) {
		id = getNextId();
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.password=password;
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


	public String getFName() {
		return fname;
	}

	protected void setFName(String name) {
		this.fname = name;
	}

	public String getLName() {
		return lname;
	}

	protected void setLName(String name) {
		this.lname = name;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return " [" + fname + "]:";
	}

}

package io.pivotal.microservices.user;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * The user Spring configuration.
 * 
 * @author Paul Chapman
 */
@Configuration
@ComponentScan
@EntityScan("io.pivotal.microservices.user")
@EnableJpaRepositories("io.pivotal.microservices.user")
@PropertySource("classpath:db-config.properties")
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/user/UsersConfiguration.java
public class UsersConfiguration {

	protected Logger logger;

	public UsersConfiguration() {
=======
public class UserConfiguration {

	protected Logger logger;

	public UserConfiguration() {
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/user/UserConfiguration.java
		logger = Logger.getLogger(getClass().getName());
	}

	/**
	 * Creates an in-memory "rewards" database populated with test data for fast
	 * testing
	 */
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		// Create an in-memory H2 relational database containing some demo
		// user.
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();

		logger.info("dataSource = " + dataSource);

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT number FROM T_User");
		logger.info("System has " + users.size() + " user");



		return dataSource;
	}
}

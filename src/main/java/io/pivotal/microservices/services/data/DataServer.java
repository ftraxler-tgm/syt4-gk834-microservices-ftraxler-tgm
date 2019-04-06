package io.pivotal.microservices.services.data;

import io.pivotal.microservices.services.user.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.util.logging.Logger;

/**
 * @author Fabian Traxler {@literal <ftraxler@student.tgm.ac.at>}
 * @version 2019-04-06
 * @project microservices-demo
 */
public class DataServer {


    @Autowired
    protected WindengineRepository repository;


    protected Logger logger = Logger.getLogger(DataServer.class.getName());


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

        SpringApplication.run(UserServer.class, args);
    }

}

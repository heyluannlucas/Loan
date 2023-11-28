/**
 * Main class for the university application.
 * The App class contains the main method to start the Spring Boot application.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-20
 */
package org.jala.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class App {
    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

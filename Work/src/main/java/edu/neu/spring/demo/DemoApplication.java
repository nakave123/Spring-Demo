package edu.neu.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("edu.neu.spring.demo.entity")
@ComponentScan("edu.neu.spring.demo.controller")
@ComponentScan("edu.neu.spring.demo.service")
@EnableJpaRepositories("edu.neu.spring.demo.repository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

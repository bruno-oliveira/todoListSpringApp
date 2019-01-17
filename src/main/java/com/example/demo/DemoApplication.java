package com.example.demo;

import com.example.todoitem.TodoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.example.todoitem.TodoController;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;


@SpringBootApplication
@ComponentScan(basePackageClasses = TodoController.class)
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses=TodoItem.class)
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private TodoRepository repository;

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoRepository repository) {
		return (args) -> {
			repository.save(new TodoItem(334L,"Bafdsuer"));
			repository.save(new TodoItem(134L,"Baudfer"));
			repository.save(new TodoItem(634L,"Baudfsdfer"));
			System.out.println("Save all");
		};
	}



}


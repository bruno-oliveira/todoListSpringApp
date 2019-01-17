package com.example;

import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;
import com.example.todoitem.TodoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private TodoRepository repository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoRepository repository, UserRepository userRepository) {
		return (args) -> {

			TodoItem some_kat_item = new TodoItem(334L, "some kat item", 0L);
			repository.save(some_kat_item);
			TodoItem other_kat_item = new TodoItem(134L, "other kat item", 0L);
			repository.save(other_kat_item);
			repository.save(new TodoItem(634L,"Baudfsdfer",-1L));
			TodoItem kat_item = new TodoItem(1L, "Kat Item",0L);
			repository.save(kat_item);
		};
	}



}


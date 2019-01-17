package com.example.repository;

import com.example.todoitem.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository  extends CrudRepository<TodoItem,Long> {

}

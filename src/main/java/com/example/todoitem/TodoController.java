package com.example.todoitem;

import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @RequestMapping(value="/todoitem", method=POST)
    public ResponseEntity<TodoItem> createToDoItem(@RequestBody TodoItem item) {
        System.out.println("Created to do item "+item.getId());
        return ResponseEntity.ok(item);
    }

    @RequestMapping(value = "/todoitem/{id}", method = GET)
    @ResponseBody
    public ResponseEntity<TodoItem> findToDoItemByID(
            @PathVariable("id") long id) {
        Optional<TodoItem> optionalTodoItem = repository.findById(id);
        return optionalTodoItem.map(todoItem -> new ResponseEntity<>(todoItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

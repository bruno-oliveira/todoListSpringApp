package com.example.todoitem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class TodoController {

    @RequestMapping(value = "/todo", method = POST)
    public ResponseEntity<TodoItem> createToDoItem(@RequestBody TodoItem item) {
        System.out.println("Created to do item "+item.getId());
        return ResponseEntity.ok(item);
    }

    @RequestMapping(value = "/todo/{id}", method = GET)
    public ResponseEntity<TodoItem> findToDoItemByID(
            @PathVariable("id") long id) {
        Optional<TodoItem> optionalTodoItem = Optional.of(new TodoItem(23L, "aa", 9L)); //this should come from service: service.getTodoItemByID(id)...
        return optionalTodoItem.map(todoItem -> new ResponseEntity<>(todoItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/todo/{id}", method = PUT)
    public TodoItem editToDoItem(
            @PathVariable("id") long id, @RequestBody TodoItem todoItem) {
        return todoItem;
    }

    @RequestMapping(
            value = "/todo/",
            params = {"id", "limit", "page"},
            method = GET)
    public List<TodoItem> getTodoListOfUser(
            @RequestParam("id") long id) {
        List<TodoItem> todoListOfUser = Collections.emptyList(); //this should come from service: service.getTodoItemListByUserID(id)...
        return todoListOfUser;
    }

    @RequestMapping(value = "/todo/{id}", method = DELETE)
    public ResponseEntity deleteTodoItem(
            @PathVariable("id") long id) {
        System.out.println("Delete todo item with ID " + id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

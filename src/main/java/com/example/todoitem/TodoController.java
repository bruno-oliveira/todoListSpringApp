package com.example.todoitem;

import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todo", method = POST)
    public ResponseEntity<TodoItem> createToDoItem(@RequestBody TodoItem item) {
        boolean wasSucessfullyCreated = todoService.create(item);
        if (wasSucessfullyCreated) {
            System.out.println("Created to do item " + item.getId());
        } else {
            System.out.println("Item with the id " + item.getId() + " already exists");
        }
        return wasSucessfullyCreated ? ResponseEntity.ok(item) : new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(value = "/todo/{id}", method = GET)
    public ResponseEntity<TodoItem> findToDoItemByID(
            @PathVariable("id") long id) {
        Optional<TodoItem> optionalTodoItem = Optional.ofNullable(todoService.findByID(id));
        return optionalTodoItem.map(todoItem -> new ResponseEntity<>(todoItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/todo/{id}", method = PUT)
    public TodoItem editToDoItem(
            @PathVariable("id") long id, @RequestBody TodoItem todoItem) {
        todoService.update(todoItem);
        return todoItem;
    }

    @RequestMapping(
            value = "/todo",
            params = {"authorId", "limit", "page"},
            method = GET)
    public List<TodoItem> getTodoListOfUser(
            @RequestParam("authorId") long authorId) {
        return todoService.getTodoItemListByUserId(authorId);
    }

    @RequestMapping(value = "/todo/{id}", method = DELETE)
    public ResponseEntity deleteTodoItem(
            @PathVariable("id") long id) {
        todoService.delete(id);
        System.out.println("Delete todo item with ID " + id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

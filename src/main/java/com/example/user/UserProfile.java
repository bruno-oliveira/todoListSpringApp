package com.example.user;

import com.example.todoitem.TodoItem;

import java.util.List;

public class UserProfile {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<TodoItem> todoItems;

    UserProfile(String username, String email, String firstName, String lastName, List<TodoItem> todoItems) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.todoItems = todoItems;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}

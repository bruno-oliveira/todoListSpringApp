package com.example.user;

import com.example.todoitem.TodoItem;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String address;
    @Column
    @ElementCollection
    private List<TodoItem> listOfItems;

    protected User() {}

    public User(@JsonProperty("id")Long id,@JsonProperty("name") String name, @JsonProperty("address")String address, @JsonProperty("listItems")List<TodoItem> listOfItems) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.listOfItems = listOfItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TodoItem> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<TodoItem> listOfItems) {
        this.listOfItems = listOfItems;
    }
}

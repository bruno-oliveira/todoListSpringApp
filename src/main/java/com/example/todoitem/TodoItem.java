package com.example.todoitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TodoItem {
    @Id
    private long id;
    private String taskContent;

    protected TodoItem(){}

    public TodoItem(@JsonProperty("id")long id, @JsonProperty("taskContent")String taskContent) {
        this.id = id;
        this.taskContent = taskContent;
    }

    public long getId() {
        return id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", taskContent='" + taskContent + '\'' +
                '}';
    }
}

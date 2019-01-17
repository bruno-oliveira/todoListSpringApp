package com.example.todoitem;

import com.example.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TodoItem {
    @Id
    private long id;
    private String taskContent;
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_USER"))
    @NonNull
    private long authorId;


    protected TodoItem(){}

    public TodoItem(@JsonProperty("id")long id, @JsonProperty("taskContent")String taskContent, @JsonProperty("author")long authorId) {
        this.id = id;
        this.taskContent = taskContent;
        this.authorId = authorId;
    }

     long getId() {
        return id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public long getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", taskContent='" + taskContent + '\'' +
                '}';
    }
}

package com.example.todoitem;

public class TodoItem {

    private long id;
    private String taskContent;
    private long authorId;


    protected TodoItem(){}

    public TodoItem(long id, String taskContent, long authorId) {
        this.id = id;
        this.taskContent = taskContent;
        this.authorId = authorId;
    }

    public long getId() {
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

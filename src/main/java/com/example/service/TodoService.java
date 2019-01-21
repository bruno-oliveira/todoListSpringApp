package com.example.service;

import com.example.todoitem.TodoItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static Map<Long, TodoItem> todoItemMap = new TreeMap<>();

    static {
        todoItemMap.put(1L, new TodoItem(1L, "some content", 0L));
        todoItemMap.put(2L, new TodoItem(2L, "some content", 0L));
        todoItemMap.put(3L, new TodoItem(3L, "some content", 1L));
        todoItemMap.put(4L, new TodoItem(4L, "some content", 2L));
    }

    public boolean create(TodoItem item) {
        TodoItem x = todoItemMap.putIfAbsent(item.getId(), item);
        return x == null;
    }

    public void update(TodoItem item) {
        todoItemMap.put(item.getId(), item);
    }

    public void delete(long itemId) {
        todoItemMap.remove(itemId);
    }

    public TodoItem findByID(Long id) {
        return todoItemMap.get(id);
    }

    public List<TodoItem> getTodoItemListByAuthorId(Long authorId) {
        List<TodoItem> todoItemsByAuthor = todoItemMap.entrySet().stream().filter(e -> e.getValue().getAuthorId() == authorId).map(Map.Entry::getValue).collect(Collectors.toList());
        return todoItemsByAuthor;
    }
}

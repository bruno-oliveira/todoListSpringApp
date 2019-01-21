package com.example.service.test;

import com.example.service.TodoService;
import com.example.todoitem.TodoItem;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class TodoServiceTest {

    private TodoService service = new TodoService();

    @Test
    public void findTodoItemByID() {
        TodoItem item = service.findByID(1L);
        Assert.assertEquals(1L, item.getId());
    }

    @Test
    public void todoItemInsert() {
        boolean createdSuccessfully = service.create(new TodoItem(10L, "testing insert", 0L));
        Assert.assertTrue(createdSuccessfully);
    }

    @Test
    public void updateTodoItem() {
        TodoItem item = service.findByID(10L);
        item.setTaskContent("updated");
        service.update(item);
        Assert.assertEquals(service.findByID(10L).getTaskContent(), "updated");
    }

    @Test
    public void findTodoItemAfterInsert() {
        TodoItem item = service.findByID(10L);
        Assert.assertNotNull(item);
    }

    @Test
    public void deleteTodoItem() {
        service.delete(10L);
        Assert.assertNull(service.findByID(10L));
    }
}

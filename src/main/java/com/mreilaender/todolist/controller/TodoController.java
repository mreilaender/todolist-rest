package com.mreilaender.todolist.controller;

import com.mreilaender.todolist.dao.TodoDAO;
import com.mreilaender.todolist.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author manuel
 * @version 12/7/16
 */
@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoDAO todoDAO;

    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return todoDAO.save(todo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> findAll() {
        return new ResponseEntity<>(getAllTodos(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Todo update(@RequestParam Todo todo) {
        Todo old = todoDAO.findOne(todo.getId());
            old.setDone(todo.isDone());
            old.setName(todo.getName());
        return todoDAO.save(todo);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteById(@RequestParam Integer id) {
        // TODO: change to /{id}
        todoDAO.delete(id);
    }

    private List<Todo> getAllTodos() {
        return (List<Todo>) todoDAO.findAll();
    }
}

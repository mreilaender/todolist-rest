package com.mreilaender.todolist.dao;

import com.mreilaender.todolist.entities.Todo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author manuel
 * @version 12/7/16
 */
public interface TodoDAO extends CrudRepository<Todo, Integer> {
}

package com.utn.todoapp.repositories;

import com.utn.todoapp.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}

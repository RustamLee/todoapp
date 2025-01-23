package com.utn.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.lang.annotation.Retention;

@Entity
public class ToDoItem {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public ToDoItem() {
    }

    public ToDoItem(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ToDoItem(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.example.todo;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.naming.NamingStrategies;

@MappedEntity(value = "todos", namingStrategy = NamingStrategies.Raw.class)
public class Todo {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    private String title;
    private String description;
    private boolean completed;

    // Constructors
    public Todo() {
    }

    public Todo(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed=completed;
    }
}

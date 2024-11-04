package com.example.todo;

import io.micronaut.http.annotation.*;
import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/todos")
public class TodoController {

    private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

    @Inject
    private TodoRepository todoRepository;

    @Get
    public Iterable<Todo> list() {
        LOG.info("Listing all todos");
        return todoRepository.findAll();
    }

    @Get("/{id}")
    public HttpResponse<Todo> get(Long id) {
        LOG.info("Getting todo with id: {}", id);
        return todoRepository.findById(id)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Post
    public HttpResponse<Todo> create(@Body Todo todo) {
        Todo savedTodo = todoRepository.save(todo);
        LOG.info("Created todo with id: {}", savedTodo.getId());
        return HttpResponse.created(savedTodo);
    }

    @Put("/{id}")
    public HttpResponse<Todo> update(Long id, @Body Todo todo) {
        if (!todoRepository.existsById(id)) {
            LOG.warn("Todo with id {} not found for update", id);
            return HttpResponse.notFound();
        }
        todo.setId(id);
        Todo updatedTodo = todoRepository.update(todo);
        LOG.info("Updated todo with id: {}", id);
        return HttpResponse.ok(updatedTodo);
    }

    @Delete("/{id}")
    public HttpResponse<Void> delete(Long id) {
        if (!todoRepository.existsById(id)) {
            LOG.warn("Todo with id {} not found for deletion", id);
            return HttpResponse.notFound();
        }
        todoRepository.deleteById(id);
        LOG.info("Deleted todo with id: {}", id);
        return HttpResponse.noContent();
    }
}

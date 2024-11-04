package com.example.todo;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.client.*;
import io.micronaut.http.*;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class TodoControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testCreateAndRetrieveTodo() {
        // Create a new Todo
        Todo todo = new Todo();
        todo.setTitle("Test Todo");
        todo.setDescription("Testing create and retrieve");
        todo.setCompleted(false);

        HttpRequest<Todo> request = HttpRequest.POST("/todos", todo);
        HttpResponse<Todo> response = client.toBlocking().exchange(request, Todo.class);

        assertEquals(HttpStatus.CREATED, response.getStatus());
        Todo createdTodo = response.body();
        assertNotNull(createdTodo);
        assertNotNull(createdTodo.getId());

        // Retrieve the created Todo
        HttpRequest<?> getRequest = HttpRequest.GET("/todos/" + createdTodo.getId());
        HttpResponse<Todo> getResponse = client.toBlocking().exchange(getRequest, Todo.class);

        assertEquals(HttpStatus.OK, getResponse.getStatus());
        Todo retrievedTodo = getResponse.body();
        assertNotNull(retrievedTodo);
        assertEquals(createdTodo.getId(), retrievedTodo.getId());
        assertEquals("Test Todo", retrievedTodo.getTitle());
    }

    @Test
    void testUpdateTodo() {
        // Create a new Todo
        Todo todo = new Todo();
        todo.setTitle("Update Test");
        todo.setDescription("Before update");
        todo.setCompleted(false);

        HttpRequest<Todo> createRequest = HttpRequest.POST("/todos", todo);
        Todo createdTodo = client.toBlocking().retrieve(createRequest, Todo.class);

        // Update the Todo
        createdTodo.setDescription("After update");
        createdTodo.setCompleted(true);
        HttpRequest<Todo> updateRequest = HttpRequest.PUT("/todos/" + createdTodo.getId(), createdTodo);
        HttpResponse<Todo> updateResponse = client.toBlocking().exchange(updateRequest, Todo.class);

        assertEquals(HttpStatus.OK, updateResponse.getStatus());
        Todo updatedTodo = updateResponse.body();
        assertNotNull(updatedTodo);
        assertTrue(updatedTodo.isCompleted());
        assertEquals("After update", updatedTodo.getDescription());
    }

    @Test
    void testDeleteTodo() {
        // Create a new Todo
        Todo todo = new Todo();
        todo.setTitle("Delete Test");
        todo.setDescription("To be deleted");
        todo.setCompleted(false);

        HttpRequest<Todo> createRequest = HttpRequest.POST("/todos", todo);
        Todo createdTodo = client.toBlocking().retrieve(createRequest, Todo.class);

        // Delete the Todo
        HttpRequest<Void> deleteRequest = HttpRequest.DELETE("/todos/" + createdTodo.getId());
        HttpResponse<Void> deleteResponse = client.toBlocking().exchange(deleteRequest);

        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatus());

        // Verify deletion
        HttpRequest<?> getRequest = HttpRequest.GET("/todos/" + createdTodo.getId());
        // HttpResponse<Todo> getResponse = client.toBlocking().exchange(getRequest, Todo.class);

        assertThrows(HttpClientResponseException.class, () ->
            client.toBlocking().exchange(getRequest, Todo.class)
        );

        // assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatus());
    }
}

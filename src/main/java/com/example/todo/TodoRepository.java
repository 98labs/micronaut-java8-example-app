package com.example.todo;

import java.util.List;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Override
    List<Todo> findAll();

}

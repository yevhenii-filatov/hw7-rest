package com.nadia.hw7.service;

import com.nadia.hw7.model.domain.TodoList;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

public interface TodoListService {
    List<TodoList> findAll();

    TodoList findById(@NotNull @Positive Long id);

    TodoList create(@NotNull @Valid TodoList list);

    TodoList deleteById(@NotNull @Positive Long id);
}

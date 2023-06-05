package com.nadia.hw7.controller;

import com.nadia.hw7.model.domain.TodoList;
import com.nadia.hw7.service.TodoListService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo-list")
public class TodoListController {
    private static final String ID_MAPPING = "/{listId}";

    private final TodoListService todoListService;

    @GetMapping
    public ResponseEntity<List<TodoList>> findAll() {
        return ResponseEntity.ok(todoListService.findAll());
    }

    @GetMapping(ID_MAPPING)
    public ResponseEntity<TodoList> findById(@NotNull @Positive @PathVariable Long listId) {
        return ResponseEntity.ok(todoListService.findById(listId));
    }

    @PostMapping
    public ResponseEntity<TodoList> create(@NotNull @Valid @RequestBody TodoList list) {
        return ResponseEntity.ok(todoListService.create(list));
    }

    @DeleteMapping(ID_MAPPING)
    public ResponseEntity<TodoList> deleteById(@NotNull @Positive @PathVariable Long listId) {
        return ResponseEntity.ok(todoListService.deleteById(listId));
    }
}

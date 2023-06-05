package com.nadia.hw7.service.impl;

import com.nadia.hw7.mapper.TodoListMapper;
import com.nadia.hw7.model.domain.TodoList;
import com.nadia.hw7.model.entity.TodoListEntity;
import com.nadia.hw7.repository.TodoListRepository;
import com.nadia.hw7.service.TodoListService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;
    private final TodoListMapper todoListMapper;

    @Override
    public List<TodoList> findAll() {
        return todoListRepository.findAll()
           .stream()
           .map(todoListMapper::fromEntity)
           .toList();
    }

    @Override
    public TodoList findById(@NotNull Long id) {
        return todoListRepository.findById(id)
           .map(todoListMapper::fromEntity)
           .orElseThrow(() -> new NoSuchElementException("Todo list not found with ID = " + id));
    }

    @Override
    public TodoList create(@NotNull TodoList list) {
        TodoListEntity entity = todoListMapper.toEntity(list);
        if (entity.getTasks() != null) {
            entity.getTasks().forEach(taskEntity -> taskEntity.setTodoList(entity));
        }
        return todoListMapper.fromEntity(todoListRepository.save(entity));
    }

    @Override
    public TodoList deleteById(@NotNull Long id) {
        return todoListRepository.findById(id)
           .map(todoListEntity -> {
               todoListRepository.deleteById(id);
               return todoListMapper.fromEntity(todoListEntity);
           })
           .orElseThrow(() -> new NoSuchElementException("Todo list not found by ID = " + id));
    }
}

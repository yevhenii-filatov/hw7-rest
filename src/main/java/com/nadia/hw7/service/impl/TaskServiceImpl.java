package com.nadia.hw7.service.impl;

import com.nadia.hw7.mapper.TaskMapper;
import com.nadia.hw7.model.domain.Task;
import com.nadia.hw7.model.entity.TaskEntity;
import com.nadia.hw7.model.shared.TaskStatus;
import com.nadia.hw7.repository.TaskRepository;
import com.nadia.hw7.repository.TodoListRepository;
import com.nadia.hw7.service.TaskService;
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
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TodoListRepository todoListRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll()
           .stream()
           .map(taskMapper::fromEntity)
           .toList();
    }

    @Override
    public Task findById(@NotNull Long taskId) {
        return taskRepository.findById(taskId)
           .map(taskMapper::fromEntity)
           .orElseThrow(() -> new NoSuchElementException("Task not found with ID = " + taskId));
    }

    @Override
    public Task create(@NotNull Task task) {
        return save(task);
    }

    @Override
    public Task update(@NotNull Task task) {
        return save(task);
    }

    @Override
    public Task patchStatus(@NotNull Long taskId, @NotNull TaskStatus newStatus) {
        return taskRepository.findById(taskId)
           .map(taskEntity -> {
               taskEntity.setStatus(newStatus);
               return taskMapper.fromEntity(taskRepository.save(taskEntity));
           }).orElseThrow(() -> new NoSuchElementException("Task not found by ID = " + taskId));
    }

    @Override
    public Task deleteById(@NotNull Long taskId) {
        return taskRepository.findById(taskId)
           .map(taskEntity -> {
               taskRepository.deleteById(taskId);
               return taskMapper.fromEntity(taskEntity);
           }).orElseThrow(() -> new NoSuchElementException("Task not found with ID = " + taskId));
    }

    private Task save(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);
        todoListRepository
           .findById(task.getTodoListId())
           .ifPresentOrElse(
              entity::setTodoList,
              () -> {
                  throw new NoSuchElementException("Todo list not found with ID = " + task.getTodoListId());
              });
        return taskMapper.fromEntity(taskRepository.save(entity));
    }
}

package com.nadia.hw7.service;

import com.nadia.hw7.model.domain.Task;
import com.nadia.hw7.model.shared.TaskStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

public interface TaskService {
    List<Task> findAll();

    Task findById(@NotNull @Positive Long taskId);

    Task create(@NotNull @Valid Task task);

    Task update(@NotNull @Valid Task task);

    Task patchStatus(@NotNull @Positive Long taskId, @NotNull TaskStatus newStatus);

    Task deleteById(@NotNull @Positive Long taskId);
}

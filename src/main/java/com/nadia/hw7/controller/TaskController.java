package com.nadia.hw7.controller;

import com.nadia.hw7.model.domain.Task;
import com.nadia.hw7.model.shared.TaskStatus;
import com.nadia.hw7.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private static final String ID_MAPPING = "/{taskId}";
    private static final String UPDATE_STATUS_MAPPING = ID_MAPPING + "/{newStatus}";

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@NotNull @Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.create(task));
    }

    @PutMapping
    public ResponseEntity<Task> update(@NotNull @Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.update(task));
    }

    @DeleteMapping(ID_MAPPING)
    public ResponseEntity<Task> deleteById(@NotNull @Positive @PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.deleteById(taskId));
    }

    @PatchMapping(UPDATE_STATUS_MAPPING)
    public ResponseEntity<Task> patchStatus(@NotNull @Positive @PathVariable Long taskId,
                                            @NotNull @PathVariable TaskStatus newStatus) {
        return ResponseEntity.ok(taskService.patchStatus(taskId, newStatus));
    }
}

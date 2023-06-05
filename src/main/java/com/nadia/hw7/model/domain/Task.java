package com.nadia.hw7.model.domain;

import com.nadia.hw7.model.shared.TaskStatus;
import lombok.Builder;
import lombok.Data;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Data
@Builder
public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Long todoListId;
}

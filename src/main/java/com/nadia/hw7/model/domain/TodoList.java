package com.nadia.hw7.model.domain;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Data
@Builder
public class TodoList {
    private Long id;
    private Instant createdAt;
    private String name;
    private String author;
    private List<Task> tasks;
}

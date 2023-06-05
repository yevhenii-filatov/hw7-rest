package com.nadia.hw7.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "todo_list")
public class TodoListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks = new ArrayList<>();
}

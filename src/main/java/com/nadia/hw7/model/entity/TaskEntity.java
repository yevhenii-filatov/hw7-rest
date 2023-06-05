package com.nadia.hw7.model.entity;

import com.nadia.hw7.model.shared.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(targetEntity = TodoListEntity.class)
    private TodoListEntity todoList;
}

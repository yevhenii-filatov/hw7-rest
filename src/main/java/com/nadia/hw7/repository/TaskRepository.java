package com.nadia.hw7.repository;

import com.nadia.hw7.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}

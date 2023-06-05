package com.nadia.hw7.mapper;

import com.nadia.hw7.model.domain.Task;
import com.nadia.hw7.model.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Mapper(
   componentModel = "spring",
   nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TaskMapper {
    TaskEntity toEntity(Task task);

    @Mapping(target = "todoListId", source = "todoList.id")
    Task fromEntity(TaskEntity entity);
}

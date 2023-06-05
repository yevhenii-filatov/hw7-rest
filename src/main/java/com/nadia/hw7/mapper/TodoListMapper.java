package com.nadia.hw7.mapper;

import com.nadia.hw7.model.domain.TodoList;
import com.nadia.hw7.model.entity.TodoListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author Yevhenii Filatov
 * @since 6/5/23
 */

@Mapper(
   componentModel = "spring",
   nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
   uses = TaskMapper.class
)
public interface TodoListMapper {
    TodoListEntity toEntity(TodoList list);

    TodoList fromEntity(TodoListEntity entity);
}

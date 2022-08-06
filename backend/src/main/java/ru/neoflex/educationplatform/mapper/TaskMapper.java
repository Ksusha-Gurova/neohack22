package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.TaskRequestDto;
import org.openapitools.model.TasksAllInfo;
import ru.neoflex.educationplatform.model.Lesson;
import ru.neoflex.educationplatform.model.Task;

@Mapper(componentModel = "spring", uses = AnswerMapper.class)
public interface TaskMapper {

    @Mapping(target = "lesson", source = "lesson")
    @Mapping(target = "id", source = "taskRequestDto.id")
    @Mapping(target = "name", source = "taskRequestDto.name")
    Task mapRequestDtoToEntity(TaskRequestDto taskRequestDto, Lesson lesson);

    @Mapping(target = "lesson", source = "lesson")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "taskRequestDto.name")
    Task updateTaskFromRequestDto(@MappingTarget Task task, TaskRequestDto taskRequestDto, Lesson lesson);

    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "answers", source = "answers")
    TasksAllInfo mapEntityToTasksAllInfo(Task task);
}

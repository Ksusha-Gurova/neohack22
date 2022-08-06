package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.TaskRequestDto;
import org.openapitools.model.TasksAllInfo;
import ru.neoflex.educationplatform.model.Question;
import ru.neoflex.educationplatform.model.Task;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "questions", source = "questionList")
    Task mapRequestDtoToEntity(TaskRequestDto taskRequestDto, List<Question> questionList);

    @Mapping(target = "questions", source = "questionList")
    Task updateTaskFromRequestDto(@MappingTarget Task task, TaskRequestDto taskRequestDto, List<Question> questionList);

    @Mapping(target = "lessonId", source = "lesson.id")
    TasksAllInfo mapEntityToTasksAllInfo(Task task);
}

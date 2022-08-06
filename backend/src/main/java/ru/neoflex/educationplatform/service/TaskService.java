package ru.neoflex.educationplatform.service;

import org.openapitools.model.QuestionAllInfo;
import org.openapitools.model.TaskRequestDto;
import org.openapitools.model.TasksAllInfo;

import java.util.List;

public interface TaskService {

    void deleteTaskById(Long id);

    List<QuestionAllInfo> getQuestionsByTaskId(Long id);

    TasksAllInfo getTaskById(Long id);

    TasksAllInfo saveOrUpdateTask(TaskRequestDto taskRequestDto);
}

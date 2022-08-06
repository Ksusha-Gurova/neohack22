package ru.neoflex.educationplatform.api.controller;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApi;
import org.openapitools.model.QuestionAllInfo;
import org.openapitools.model.TaskRequestDto;
import org.openapitools.model.TasksAllInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.educationplatform.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<Void> deleteTask(Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<QuestionAllInfo>> getQuestionsByTaskId(Long id) {
        return ResponseEntity.ok(taskService.getQuestionsByTaskId(id));
    }

    @Override
    public ResponseEntity<TasksAllInfo> getTaskById(Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @Override
    public ResponseEntity<TasksAllInfo> saveOrUpdateTask(TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.saveOrUpdateTask(taskRequestDto));
    }
}

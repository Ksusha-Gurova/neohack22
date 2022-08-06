package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.AnswerAllInfo;
import org.openapitools.model.TaskRequestDto;
import org.openapitools.model.TasksAllInfo;
import org.springframework.stereotype.Service;
import ru.neoflex.educationplatform.mapper.TaskMapper;
import ru.neoflex.educationplatform.model.Answer;
import ru.neoflex.educationplatform.model.Task;
import ru.neoflex.educationplatform.repository.AnswerRepository;
import ru.neoflex.educationplatform.repository.TaskRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AnswerRepository answerRepository;
    private final TaskMapper taskMapper;

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<AnswerAllInfo> getAnswersByTaskId(Long id) {
        return null;
    }

    @Override
    public TasksAllInfo getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::mapEntityToTasksAllInfo)
                .orElseThrow(() -> new EntityNotFoundException("В базе нет задачи с id " + id));
    }

    @Override
    public TasksAllInfo saveOrUpdateTask(TaskRequestDto taskRequestDto) {
        Task task;
        List<Answer> questions = answerRepository.findAllByIdIn(taskRequestDto.getAnswers());
        if (taskRequestDto.getId() != null) {
            task = taskRepository.findById(taskRequestDto.getId())
                    .map(t -> taskMapper.updateTaskFromRequestDto(t, taskRequestDto, questions))
                    .orElse(taskMapper.mapRequestDtoToEntity(taskRequestDto, questions));
        } else {
            task = taskMapper.mapRequestDtoToEntity(taskRequestDto, questions);
        }
        Task savedTask = taskRepository.save(task);
        return taskMapper.mapEntityToTasksAllInfo(savedTask);
    }
}

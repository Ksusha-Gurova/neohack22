package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.AnswerAllInfo;
import org.openapitools.model.TaskRequestDto;
import org.openapitools.model.TasksAllInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.educationplatform.mapper.AnswerMapper;
import ru.neoflex.educationplatform.mapper.TaskMapper;
import ru.neoflex.educationplatform.model.Answer;
import ru.neoflex.educationplatform.model.Lesson;
import ru.neoflex.educationplatform.model.Task;
import ru.neoflex.educationplatform.repository.AnswerRepository;
import ru.neoflex.educationplatform.repository.LessonRepository;
import ru.neoflex.educationplatform.repository.TaskRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AnswerRepository answerRepository;
    private final TaskMapper taskMapper;
    private final AnswerMapper answerMapper;
    private final LessonRepository lessonRepository;

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
        Lesson lesson = lessonRepository.findById(taskRequestDto.getLesson())
                .orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + taskRequestDto.getLesson()));

        Task task;
        if (taskRequestDto.getId() == null){
            task = taskMapper.mapRequestDtoToEntity(taskRequestDto, lesson);
        } else {
            task = taskRepository.findById(taskRequestDto.getId())
                    .map(t -> taskMapper.updateTaskFromRequestDto(t, taskRequestDto, lesson))
                    .orElse(taskMapper.mapRequestDtoToEntity(taskRequestDto, lesson));
        }

        Task save = taskRepository.save(task);
        List<Answer> answers = taskRequestDto.getAnswers().stream()
                .map(answerMapper::mapEntityFromDto)
                .map(answer -> answer.toBuilder().task(save).build()).collect(Collectors.toList());
        answerRepository.saveAll(answers);
        return taskMapper.mapEntityToTasksAllInfo(taskRepository.getById(save.getId()));
    }
}

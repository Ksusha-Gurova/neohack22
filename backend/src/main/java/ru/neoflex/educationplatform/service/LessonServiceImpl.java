package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.LessonAllInfo;
import org.openapitools.model.LessonsRequestDto;
import org.openapitools.model.TasksAllInfo;
import org.springframework.stereotype.Service;
import ru.neoflex.educationplatform.mapper.TaskMapper;
import ru.neoflex.educationplatform.mapper.LessonMapper;
import ru.neoflex.educationplatform.model.Course;
import ru.neoflex.educationplatform.model.Lesson;
import ru.neoflex.educationplatform.model.User;
import ru.neoflex.educationplatform.repository.LessonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final TaskMapper taskMapper;

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public LessonAllInfo getLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + id));
        return lessonMapper.mapEntityToLessonAllInfo(lesson);
    }

    @Override
    public List<TasksAllInfo> getTasksByLessonId(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + id));
        return lesson.getTasks().stream().map(taskMapper::mapEntityToTasksAllInfo).collect(Collectors.toList());
    }

    @Override
    public LessonAllInfo updateLessons(LessonsRequestDto lessonsRequestDto) {

        Course course = lessonRepository.findById(lessonsRequestDto.getId())
                .map(lesson -> lesson.getCourse())
                .orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + lessonsRequestDto.getId()));

        User teacher = lessonRepository.findById(lessonsRequestDto.getId())
                .map(lesson -> lesson.getTeacher())
                .orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + lessonsRequestDto.getId()));

        User author = lessonRepository.findById(lessonsRequestDto.getId())
                .map(lesson -> lesson.getAuthor())
                .orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + lessonsRequestDto.getId()));


        if (lessonsRequestDto.getId() != null){
            Lesson lesson = lessonRepository.findById(lessonsRequestDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("в базе нет урока с id " + lessonsRequestDto.getId()));
            lesson = lessonMapper.updateLessonFromLessonsRequestDto(lesson, lessonsRequestDto, course, author, teacher);
            return lessonMapper.mapEntityToLessonAllInfo(lessonRepository.save(lesson));
        } else {
            Lesson lesson = lessonMapper.mapLessonFromLessonsRequestDto(lessonsRequestDto, course, author, teacher);
            lesson = lessonRepository.save(lesson);
            return lessonMapper.mapEntityToLessonAllInfo(lesson);
        }
    }
}

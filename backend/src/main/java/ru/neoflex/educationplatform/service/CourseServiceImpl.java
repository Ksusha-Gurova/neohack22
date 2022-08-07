package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.CourseAllInfoResponseDto;
import org.openapitools.model.CourseRequestDto;
import org.openapitools.model.LessonAllInfo;
import org.springframework.stereotype.Service;
import ru.neoflex.educationplatform.mapper.CourseMapper;
import ru.neoflex.educationplatform.mapper.LessonMapper;
import ru.neoflex.educationplatform.model.Course;
import ru.neoflex.educationplatform.model.InterestTag;
import ru.neoflex.educationplatform.model.User;
import ru.neoflex.educationplatform.repository.CoursRepository;
import ru.neoflex.educationplatform.repository.InterestTagRepository;
import ru.neoflex.educationplatform.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CoursRepository coursRepository;
    private final CourseMapper courseMapper;
    private final InterestTagRepository tagRepository;
    private final UserRepository userRepository;
    private final LessonMapper lessonMapper;

    @Override
    public void deleteCourse(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public List<CourseAllInfoResponseDto> getAllPublicCourses() {
        return coursRepository.findAllByIsPrivateAndStatus(false, "AVAILABLE")
                .stream().map(courseMapper::mapEntityToCourseAllInfoResponseDto).collect(Collectors.toList());
    }

    @Override
    public CourseAllInfoResponseDto getCourse(Long id) {
        return courseMapper.mapEntityToCourseAllInfoResponseDto(coursRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("В базе нет курса с id " + id)));
    }

    @Override
    public CourseAllInfoResponseDto updateCourse(CourseRequestDto courseRequestDto) {
        List<InterestTag> allTagsById = tagRepository.findAllByIdIn(courseRequestDto.getInterestTags());
        User author = userRepository.findById(courseRequestDto.getAuthor())
                .orElseThrow(() -> new EntityNotFoundException("В базе нет пользователя с id " + courseRequestDto.getAuthor()));

        if (courseRequestDto.getId() != null) {
            Course course = coursRepository.findById(courseRequestDto.getId())
                    .map(c -> courseMapper.updateEntityFromCourseRequestDto(c, courseRequestDto, allTagsById, author))
                    .orElseThrow(() -> new EntityNotFoundException("В базе нет курса с id " + courseRequestDto.getId()));
            course = coursRepository.save(course);
            return courseMapper.mapEntityToCourseAllInfoResponseDto(course);
        } else {
            Course save = coursRepository.save(courseMapper.mapCourseRequestDtoToEntity(courseRequestDto, allTagsById, author));
            return courseMapper.mapEntityToCourseAllInfoResponseDto(save);
        }

    }

    @Override
    public List<LessonAllInfo> getLessonsByCourseId(Long id) {
        Course course = coursRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("В базе нет курса с id " + id));
        return course.getLessons().stream().map(lessonMapper::mapEntityToLessonAllInfo).collect(Collectors.toList());
    }
}

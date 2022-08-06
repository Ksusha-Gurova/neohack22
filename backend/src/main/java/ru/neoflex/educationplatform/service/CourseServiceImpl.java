package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.CourseAllInfoResponseDto;
import org.openapitools.model.CourseRequestDto;
import org.springframework.stereotype.Service;
import ru.neoflex.educationplatform.mapper.CourseMapper;
import ru.neoflex.educationplatform.model.Course;
import ru.neoflex.educationplatform.repository.CoursRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CoursRepository coursRepository;
    private final CourseMapper courseMapper;

    @Override
    public void deleteCourse(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public List<CourseAllInfoResponseDto> getAllPublicCourses() {
        return coursRepository.findAllByIsPrivateAndStatus(false, "available")
                .stream().map(courseMapper::mapEntityToCourseAllInfoResponseDto).collect(Collectors.toList());
    }

    @Override
    public CourseAllInfoResponseDto getCourse(Long id) {
        return courseMapper.mapEntityToCourseAllInfoResponseDto(coursRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("В базе нет курса с id " + id)));
    }

    @Override
    public CourseAllInfoResponseDto updateCourse(CourseRequestDto courseRequestDto) {
        if(courseRequestDto.getId() != null) {
            Course course = coursRepository.findById(courseRequestDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("В базе нет курса с id " + courseRequestDto.getId()));
            course = coursRepository.save(courseMapper.updateEntityFromCourseRequestDto(course, courseRequestDto));
            return courseMapper.mapEntityToCourseAllInfoResponseDto(course);
        } else {
            Course save = coursRepository.save(courseMapper.mapCourseRequestDtoToEntity(courseRequestDto));
            return courseMapper.mapEntityToCourseAllInfoResponseDto(save);
        }


    }
}

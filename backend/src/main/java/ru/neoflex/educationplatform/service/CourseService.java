package ru.neoflex.educationplatform.service;

import org.openapitools.model.CourseAllInfoResponseDto;
import org.openapitools.model.CourseRequestDto;
import org.openapitools.model.LessonAllInfo;

import java.util.List;

public interface CourseService {
    void deleteCourse(Long id);

    List<CourseAllInfoResponseDto> getAllPublicCourses();

    CourseAllInfoResponseDto getCourse(Long id);

    CourseAllInfoResponseDto updateCourse(CourseRequestDto courseRequestDto);

    List<LessonAllInfo> getLessonsByCourseId(Long id);
}

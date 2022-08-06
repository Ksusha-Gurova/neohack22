package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.CourseAllInfoResponseDto;
import org.openapitools.model.CourseRequestDto;
import ru.neoflex.educationplatform.model.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "status", target = "status")
    CourseAllInfoResponseDto mapEntityToCourseAllInfoResponseDto(Course course);

    Course mapCourseRequestDtoToEntity(CourseRequestDto courseRequestDto);

    @Mapping(target = "id", ignore = true)
    Course updateEntityFromCourseRequestDto(@MappingTarget Course course, CourseRequestDto courseRequestDto);
}

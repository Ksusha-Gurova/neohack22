package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.CourseAllInfoResponseDto;
import org.openapitools.model.CourseRequestDto;
import ru.neoflex.educationplatform.model.Course;
import ru.neoflex.educationplatform.model.InterestTag;
import ru.neoflex.educationplatform.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "status", target = "status")
    CourseAllInfoResponseDto mapEntityToCourseAllInfoResponseDto(Course course);

    @Mapping(target = "interestTags", source = "allTagsById")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "id", source = "courseRequestDto.id")
    Course mapCourseRequestDtoToEntity(CourseRequestDto courseRequestDto, List<InterestTag> allTagsById, User author);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "interestTags", source = "allTagsById")
    @Mapping(target = "author", source = "author")
    Course updateEntityFromCourseRequestDto(@MappingTarget Course course, CourseRequestDto courseRequestDto, List<InterestTag> allTagsById, User author);
}

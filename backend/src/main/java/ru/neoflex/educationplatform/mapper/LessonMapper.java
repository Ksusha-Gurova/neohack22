package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.LessonAllInfo;
import ru.neoflex.educationplatform.model.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "teacher", source = "teacher.id")
    LessonAllInfo mapEntityToLessonAllInfo(Lesson lesson);
}

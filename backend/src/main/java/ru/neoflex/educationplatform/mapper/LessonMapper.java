package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.LessonAllInfo;
import org.openapitools.model.LessonsRequestDto;
import ru.neoflex.educationplatform.model.Course;
import ru.neoflex.educationplatform.model.Lesson;
import ru.neoflex.educationplatform.model.User;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "teacher", source = "teacher.id")
    LessonAllInfo mapEntityToLessonAllInfo(Lesson lesson);

    @Mapping(target = "course", source = "course")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "teacher", source = "teacher")
    @Mapping(target = "name", source = "lessonsRequestDto.name")
    @Mapping(target = "isPrivate", source = "lessonsRequestDto.isPrivate")
    @Mapping(target = "cover", source = "lessonsRequestDto.cover")
    @Mapping(target = "status", source = "lessonsRequestDto.status")
    @Mapping(target = "userLessonLinks", ignore = true)
    @Mapping(target = "id", ignore = true)
    Lesson updateLessonFromLessonsRequestDto(@MappingTarget Lesson lesson,
                                             LessonsRequestDto lessonsRequestDto,
                                             Course course,
                                             User author,
                                             User teacher);

    @Mapping(target = "course", source = "course")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "teacher", source = "teacher")
    @Mapping(target = "name", source = "lessonsRequestDto.name")
    @Mapping(target = "isPrivate", source = "lessonsRequestDto.isPrivate")
    @Mapping(target = "cover", source = "lessonsRequestDto.cover")
    @Mapping(target = "status", source = "lessonsRequestDto.status")
    @Mapping(target = "userLessonLinks", ignore = true)
    @Mapping(target = "id", source = "lessonsRequestDto.id")
    Lesson mapLessonFromLessonsRequestDto(LessonsRequestDto lessonsRequestDto,
                                          Course course,
                                          User author,
                                          User teacher);
}

package ru.neoflex.educationplatform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.openapitools.model.UserAllInfoResponseDto;
import org.openapitools.model.UserRequestDto;
import org.openapitools.model.UserResponseDto;
import ru.neoflex.educationplatform.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto mapEntityToUserResponseDto(User user);

    UserAllInfoResponseDto mapEntityToUserAllInfoResponseDto(User user);

    User mapEntityFromUserRequestDto(UserRequestDto userRequestDto);

    User updateEntityFromUserRequestDto(@MappingTarget User user, UserRequestDto userRequestDto);
}

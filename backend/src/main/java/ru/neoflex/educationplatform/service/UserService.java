package ru.neoflex.educationplatform.service;

import org.openapitools.model.UserAllInfoResponseDto;
import org.openapitools.model.UserRequestDto;
import org.openapitools.model.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserAllInfoResponseDto getUser(Long id);

    UserAllInfoResponseDto updateUser(UserRequestDto userRequestDto);
}

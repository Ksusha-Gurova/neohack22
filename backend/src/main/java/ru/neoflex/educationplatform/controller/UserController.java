package ru.neoflex.educationplatform.controller;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.UsersApi;
import org.openapitools.model.UserAllInfoResponseDto;
import org.openapitools.model.UserRequestDto;
import org.openapitools.model.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsrs() {
        return UsersApi.super.getAllUsrs();
    }

    @Override
    public ResponseEntity<UserAllInfoResponseDto> getUser(Long id) {
        return UsersApi.super.getUser(id);
    }

    @Override
    public ResponseEntity<List<UserAllInfoResponseDto>> updateUser(UserRequestDto userRequestDto) {
        return UsersApi.super.updateUser(userRequestDto);
    }
}

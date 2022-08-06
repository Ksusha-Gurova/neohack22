package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.UserAllInfoResponseDto;
import org.openapitools.model.UserRequestDto;
import org.openapitools.model.UserResponseDto;
import org.springframework.stereotype.Service;
import ru.neoflex.educationplatform.mapper.UserMapper;
import ru.neoflex.educationplatform.model.User;
import ru.neoflex.educationplatform.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::mapEntityToUserResponseDto).collect(Collectors.toList());
    }

    @Override
    public UserAllInfoResponseDto getUser(Long id) {
        return userMapper.mapEntityToUserAllInfoResponseDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("В базе нет пользователя с id " + id)));
    }

    @Override
    public UserAllInfoResponseDto updateUser(UserRequestDto userRequestDto) {
        if (userRequestDto.getId() != null){
            User user = userRepository.findById(userRequestDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("В базе нет пользователя с id " + userRequestDto.getId()));
            User user1 = userMapper.updateEntityFromUserRequestDto(user, userRequestDto);
            user = userRepository.save(user1);
            return userMapper.mapEntityToUserAllInfoResponseDto(user);
        } else {
            User save = userRepository.save(userMapper.mapEntityFromUserRequestDto(userRequestDto));
            return userMapper.mapEntityToUserAllInfoResponseDto(save);
        }
    }
}

package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.dto.UserRequestDto;
import ru.itmentor.spring.boot_security.demo.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(long id);

    void addUser(UserRequestDto userRequestDto);

    void removeUser(long id);

    void updateUser(UserRequestDto userRequestDto);

    UserResponseDto findByUsername(String username);
}

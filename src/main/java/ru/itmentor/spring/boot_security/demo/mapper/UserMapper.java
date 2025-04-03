package ru.itmentor.spring.boot_security.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.itmentor.spring.boot_security.demo.dto.UserRequestDto;
import ru.itmentor.spring.boot_security.demo.dto.UserResponseDto;
import ru.itmentor.spring.boot_security.demo.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(user.getRoles().stream().map(role -> role.getName()).collect(java.util.stream.Collectors.joining(\", \")))")
    UserResponseDto toUserResponseDto(User user);

    @Mapping(target = "roles", ignore = true)
    User toUser(UserRequestDto userRequestDto);

    @Mapping(target = "roles", ignore = true)
    void updateUserFromDto(UserRequestDto userRequestDto, @MappingTarget User user);
}
package ru.itmentor.spring.boot_security.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.stream.Collectors;
import ru.itmentor.spring.boot_security.demo.dto.UserRequestDto;
import ru.itmentor.spring.boot_security.demo.dto.UserResponseDto;
import ru.itmentor.spring.boot_security.demo.model.User;

@Mapper(componentModel = "spring",imports = Collectors.class)
public interface UserMapper {

        @Mapping(target = "roles",
                expression = "java(user.getRoles().stream().map(role -> role.getName()).collect(Collectors.joining(\", \")))")
        @Mapping(target = "roleIds",
                expression = "java(user.getRoles().stream().map(role -> role.getId()).collect(Collectors.toSet()))")
    UserResponseDto toUserResponseDto(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toUser(UserRequestDto userRequestDto);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    void updateUserFromDto(UserRequestDto userRequestDto, @MappingTarget User user);
}
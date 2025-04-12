package ru.itmentor.spring.boot_security.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserRequestDto {
    private Long id;
    private String name;
    private String surname;
    private byte age;
    private String email;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Username cannot be empty")
    private String username;
    private String password;
    private Set<Long> roleIds;

}
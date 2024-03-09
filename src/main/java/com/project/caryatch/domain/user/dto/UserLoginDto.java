package com.project.caryatch.domain.user.dto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
}

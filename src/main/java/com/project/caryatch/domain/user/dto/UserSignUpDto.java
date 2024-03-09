package com.project.caryatch.domain.user.dto;

import lombok.Data;

@Data
public class UserSignUpDto {
    private String name;
    private String surname;
    private String companyName;
    private String email;
    private String password;
}

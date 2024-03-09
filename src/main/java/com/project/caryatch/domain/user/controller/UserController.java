package com.project.caryatch.domain.user.controller;


import com.project.caryatch.domain.user.dto.LoginResponseDto;
import com.project.caryatch.domain.user.dto.UserLoginDto;
import com.project.caryatch.domain.user.dto.UserSignUpDto;
import com.project.caryatch.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Rest APIs for User Operations")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto loginDto) {

        return ResponseEntity.ok(userService.login(loginDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpDto signUpDto) {
        return ResponseEntity.ok(userService.signUp(signUpDto));
    }

}

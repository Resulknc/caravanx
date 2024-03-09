package com.project.caryatch.domain.user.service;

import com.project.caryatch.domain.user.User;
import com.project.caryatch.domain.user.dto.LoginResponseDto;
import com.project.caryatch.domain.user.dto.UserLoginDto;
import com.project.caryatch.domain.user.dto.UserSignUpDto;
import com.project.caryatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


//    private JwtUtil jwtUtil;
//    public UserService(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//
//    }

    public User signUp(UserSignUpDto signUpDto) {

        // checking for email exists in a database
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            throw new RuntimeException("Email is already exist!");
        }
        // creating user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setSurname(signUpDto.getSurname());
        user.setCompanyName(signUpDto.getCompanyName());
        user.setEmail(signUpDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(signUpDto.getPassword()));
//        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
//        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return user;
    }

    public String login(UserLoginDto loginDto) {

        try {
//            Authentication authentication =
//                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
//            String email = authentication.getName();
            User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new RuntimeException("User does not Exist"));
//            String token = jwtUtil.createToken(user);
            if (user.getEmail().equals(loginDto.getEmail()) && passwordEncoder.matches(loginDto.getPassword(),user.getPasswordHash())) {
                return "Success";
            } else {
                throw new RuntimeException("Invalid username or password");
            }

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}

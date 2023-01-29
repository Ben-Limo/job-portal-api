package com.teckmils.jobportalapi.domain._user.controller;

import com.teckmils.jobportalapi.domain._user.model._User;
import com.teckmils.jobportalapi.domain._user.repository._UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    _UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody _User user) {
        _User savedUser = null;
        ResponseEntity response = null;
        try {
            savedUser = userRepository.save(user);
            if(savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("User registered successfully.");
            }
        } catch (Exception exception) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + exception.getMessage());
        }
        return response;
    }
}

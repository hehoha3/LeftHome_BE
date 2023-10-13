package com.example.firstWebBE.controller;

import com.example.firstWebBE.model.dto.userDTO.*;
import com.example.firstWebBE.model.entity.User;
import com.example.firstWebBE.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/user")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private final UserService userService;

//    sign Up
    @PostMapping("/signup")
    public ResponseDTO signup(@RequestBody SignupDTO signupDTO){
        return userService.signUp(signupDTO);
    }

//    Sign In
    @PostMapping("/signin")
    public SignInResponseDTO signIn(@RequestBody SignInDTO signInDTO){
        return userService.signIn(signInDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
}

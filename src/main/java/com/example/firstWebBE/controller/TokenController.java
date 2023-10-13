package com.example.firstWebBE.controller;

import com.example.firstWebBE.model.entity.AuthenticationToken;
import com.example.firstWebBE.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/test")
@RequiredArgsConstructor
public class TokenController {
    @Autowired
    private final TokenRepository tokenRepository;

    @GetMapping
    public ResponseEntity<List<AuthenticationToken>> getAllToken(){
        return new ResponseEntity<>(tokenRepository.findAll(), HttpStatus.OK);
    }
}

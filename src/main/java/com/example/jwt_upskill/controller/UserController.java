package com.example.jwt_upskill.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public String getMyInfo(Authentication authentication) {
        return "로그인한 사용자: " + authentication.getName();
    }
}

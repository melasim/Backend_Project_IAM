package com.example.msusers.controller;

import com.example.msusers.domain.User;
import com.example.msusers.domain.UserBills;
import com.example.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/bills")
    public ResponseEntity<UserBills> findUserById (@AuthenticationPrincipal JwtAuthenticationToken authenticationToken){
        String userId = authenticationToken.getName();
        System.out.println("ms-users: user controller");
        return ResponseEntity.ok(service.findById(userId));
    }
}

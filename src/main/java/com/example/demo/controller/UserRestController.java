package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.handler.Response;
import com.example.demo.service.AccountService;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private AccountService accountService;

    @PostMapping("user/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest login) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
                Response.generate(HttpStatus.OK, "account has been login");
            }
        return Response.generate(HttpStatus.OK, "data failed to login");
        }

    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest) {
        Boolean result = accountService.register(registerRequest);
        if(result) {
            Response.generate(HttpStatus.OK, "data has been saved");
        }
        return Response.generate(HttpStatus.OK, "data failed to saved");
    }

    @PostMapping("user/forgot")
    public String forgotPassword() {
        return "";
    }

    @PostMapping("profile/changePassword")
    public String changePassword() {
        return "";
    }
}
package com.glory.jsonwebtoken.controller;

import com.glory.jsonwebtoken.entity.Role;
import com.glory.jsonwebtoken.entity.User;
import com.glory.jsonwebtoken.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI location = URI.create(ServletUriComponentsBuilder
                                          .fromCurrentContextPath()
                                          .path("/jwt/users").toUriString());
        return ResponseEntity.created(location).body(userService.saveUser(user));
    }

    @PostMapping("/users/roles")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI location = URI.create(ServletUriComponentsBuilder
                                          .fromCurrentContextPath()
                                          .path("/jwt/users/roles").toUriString());
        return ResponseEntity.created(location).body(userService.saveRole(role));
    }

    @PostMapping("/users/{userId}/{roleName}")
    public ResponseEntity<?> addRoleToUser(@PathVariable Long userId, @PathVariable String roleName) {
        userService.addRoleToUser(userId, roleName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.createRefreshToken(request, response);
    }


}


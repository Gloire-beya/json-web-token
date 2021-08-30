package com.glory.jsonwebtoken.service;

import com.glory.jsonwebtoken.entity.Role;
import com.glory.jsonwebtoken.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(Long userId, String roleName);

    User getUserByEmail(String email);

    List<User> getUsers();
}

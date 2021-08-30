package com.glory.jsonwebtoken.service;

import com.glory.jsonwebtoken.entity.Role;
import com.glory.jsonwebtoken.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(Long userId, String roleName);

    User getUserByEmail(String email);

    List<User> getUsers();

    void createRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException ;

}

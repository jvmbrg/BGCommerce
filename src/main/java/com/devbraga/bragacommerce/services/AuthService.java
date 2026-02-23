package com.devbraga.bragacommerce.services;

import com.devbraga.bragacommerce.entities.User;
import com.devbraga.bragacommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    public void validateSelOrAdmin(Long userId){

        User authenticatedUser = userService.authenticated();
        if(!authenticatedUser.hasRole("ROLE_ADMIN") && !authenticatedUser.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
}

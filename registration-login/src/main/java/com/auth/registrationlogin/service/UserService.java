package com.auth.registrationlogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.auth.registrationlogin.model.User;
import com.auth.registrationlogin.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

package com.valverde.service;

import com.valverde.entity.User;
import com.valverde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;
}
package com.codeMaker.MyShop.App.user.service;

import com.codeMaker.MyShop.App.user.model.User;
import com.codeMaker.MyShop.App.user.model.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void updateEmail(Long userId, String newEmail) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setEmail(newEmail);
        userRepository.save(user);
    }

    public void updateAddress(Long userId, String newAddress) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setAddress(newAddress); // Zakładając, że klasa User ma metodę setAddress
        userRepository.save(user);
    }

    public void updateFirstName(Long userId, String newFirstName) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setFirstName(newFirstName);
        userRepository.save(user);
    }
}

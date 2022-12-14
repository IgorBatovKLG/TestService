package com.example.demo2.services;

import com.example.demo2.models.User;
import com.example.demo2.models.enums.Role;
import com.example.demo2.repositoryes.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        if (userRepository.findByName(user.getName()) != null)
            return false;
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.USER);
        System.out.println(user);
            userRepository.save(user);

        return true;
    }
}

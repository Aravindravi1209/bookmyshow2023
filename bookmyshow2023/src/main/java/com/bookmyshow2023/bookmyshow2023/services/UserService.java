package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.User;
import com.bookmyshow2023.bookmyshow2023.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User createUser(String email)
    {
        User user = new User();
        user.setEmail(email);

        User savedUser = this.userRepository.save(user);
        return savedUser;
    }
}

package com.bookmyshow2023.bookmyshow2023.controllers;

import com.bookmyshow2023.bookmyshow2023.Dtos.CreateUserRequestDto;
import com.bookmyshow2023.bookmyshow2023.Dtos.CreateUserResponseDto;
import com.bookmyshow2023.bookmyshow2023.Models.User;
import com.bookmyshow2023.bookmyshow2023.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    public CreateUserResponseDto createUser(CreateUserRequestDto requestDto)
    {
        User savedUser = userService.createUser(requestDto.getEmail());
        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setUser(savedUser);
        return responseDto;
    }
}

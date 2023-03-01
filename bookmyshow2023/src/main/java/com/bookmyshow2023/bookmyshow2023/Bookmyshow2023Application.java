package com.bookmyshow2023.bookmyshow2023;

import com.bookmyshow2023.bookmyshow2023.Dtos.CreateUserRequestDto;
import com.bookmyshow2023.bookmyshow2023.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bookmyshow2023Application implements CommandLineRunner {

	@Autowired
	private UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(Bookmyshow2023Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CreateUserRequestDto requestDto = new CreateUserRequestDto();
		requestDto.setEmail("arvfrj@gmail.com");
		userController.createUser(requestDto);
	}
}

package com.bookmyshow2023.bookmyshow2023;

import com.bookmyshow2023.bookmyshow2023.Dtos.CreateUserRequestDto;
import com.bookmyshow2023.bookmyshow2023.controllers.CityController;
import com.bookmyshow2023.bookmyshow2023.controllers.TheatreController;
import com.bookmyshow2023.bookmyshow2023.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bookmyshow2023Application implements CommandLineRunner {

//	@Autowired
	private UserController userController;
//	@Autowired
	private CityController cityController;
	private TheatreController theatreController;

	@Autowired
	public Bookmyshow2023Application(UserController userController, CityController cityController, TheatreController theatreController)
	{
		this.userController=userController;
		this.cityController=cityController;
		this.theatreController=theatreController;
	}
	public static void main(String[] args) {
		SpringApplication.run(Bookmyshow2023Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CreateUserRequestDto requestDto = new CreateUserRequestDto();
		requestDto.setEmail("arvfrj@gmail.com");
		this.userController.createUser(requestDto);
		this.cityController.addCity("Chennai");
		this.theatreController.createTheatre("PVR, VR MALL","Anna Nagar",1L);
		this.theatreController.addAuditorium(1L, "AUDI 1",100);
	}
}

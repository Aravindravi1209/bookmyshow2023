package com.bookmyshow2023.bookmyshow2023;

import com.bookmyshow2023.bookmyshow2023.Dtos.CreateUserRequestDto;
import com.bookmyshow2023.bookmyshow2023.Models.Language;
import com.bookmyshow2023.bookmyshow2023.Models.SeatType;
import com.bookmyshow2023.bookmyshow2023.controllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Bookmyshow2023Application implements CommandLineRunner {

//	@Autowired
	private UserController userController;
//	@Autowired
	private CityController cityController;
	private TheatreController theatreController;
	private ShowController showController;
	private TicketController ticketController;

	private MovieController movieController;

	@Autowired
	public Bookmyshow2023Application(UserController userController, CityController cityController,
									 TheatreController theatreController, ShowController showController,
									 TicketController ticketController, MovieController movieController)
	{
		this.userController=userController;
		this.cityController=cityController;
		this.theatreController=theatreController;
		this.showController=showController;
		this.ticketController=ticketController;
		this.movieController=movieController;
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

		HashMap<SeatType, Integer> seatsForAuditorium = new HashMap<>();
		seatsForAuditorium.put(SeatType.GOLD,100);
		seatsForAuditorium.put(SeatType.VIP,50);
		this.theatreController.addSeats(1L,seatsForAuditorium);
		this.movieController.addMovie("MASTER",150,9.2);

		this.showController.createShow(1L,new Date(), new Date(), 1L, null, Language.TAMIL);

		TicketBookRunner ticketBookRunner1 = new TicketBookRunner(this.ticketController,1L,List.of(9L,10L,11L),1L);
		TicketBookRunner ticketBookRunner2 = new TicketBookRunner(this.ticketController,1L,List.of(12L,10L,13L),1L);

		Thread t1 = new Thread(ticketBookRunner1);
		Thread t2 = new Thread(ticketBookRunner2);
		t1.start();
		t2.start();
	}
}

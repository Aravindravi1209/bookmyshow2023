package com.bookmyshow2023.bookmyshow2023.controllers;

import com.bookmyshow2023.bookmyshow2023.Models.Movie;
import com.bookmyshow2023.bookmyshow2023.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie addMovie(String name, int length, double rating)
    {
        return this.movieService.addMovie(name, length, rating);
    }
}

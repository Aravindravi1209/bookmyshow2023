package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.Movie;
import com.bookmyshow2023.bookmyshow2023.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(String name, int length, double rating)
    {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setLength(length);
        movie.setRating(rating);
        return this.movieRepository.save(movie);
    }
}

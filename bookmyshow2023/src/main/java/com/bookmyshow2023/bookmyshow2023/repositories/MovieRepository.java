package com.bookmyshow2023.bookmyshow2023.repositories;

import com.bookmyshow2023.bookmyshow2023.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

package com.bookmyshow2023.bookmyshow2023.repositories;

import com.bookmyshow2023.bookmyshow2023.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findById(Long id);

    Show save(Show show);
}

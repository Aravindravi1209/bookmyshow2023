package com.bookmyshow2023.bookmyshow2023.repositories;

import com.bookmyshow2023.bookmyshow2023.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    City save(City city);
    @Override
    Optional<City> findById(Long id);
}

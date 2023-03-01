package com.bookmyshow2023.bookmyshow2023.repositories;

import com.bookmyshow2023.bookmyshow2023.Models.User;
import com.bookmyshow2023.bookmyshow2023.services.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);
}

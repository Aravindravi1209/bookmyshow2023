package com.bookmyshow2023.bookmyshow2023.repositories;

import com.bookmyshow2023.bookmyshow2023.Models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findByIdIn(List<Long> showSeatIds);

//    We can also write SQL queries if we are not able to see options like findByIdIn etc.,
//    @Query("select * from show_seat_mapping where show_seat_mapping.seat_id in {}")
//    List<ShowSeat> findByIdIn(List<Long> showSeatIds);
    ShowSeat save(ShowSeat showSeat);
}

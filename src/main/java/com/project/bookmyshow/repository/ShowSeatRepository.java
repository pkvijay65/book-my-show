package com.project.bookmyshow.repository;

import com.project.bookmyshow.models.Seat;
import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

  List<ShowSeat> findAllBySeatAndShow(List<Seat> seats, Show show);

  ShowSeat save(ShowSeat showSeat);
}

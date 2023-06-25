package com.project.bookmyshow.repository;

import com.project.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

  @Override
  List<Seat> findAllById(Iterable<Long> seatIds);
}

package com.project.bookmyshow.repository;

import com.project.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
  @Override
  Optional<Show> findById(Long showId);
}

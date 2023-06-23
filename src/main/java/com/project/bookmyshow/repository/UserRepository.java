package com.project.bookmyshow.repository;

import com.project.bookmyshow.models.Seat;
import com.project.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Override
  Optional<User> findById(Long userId);
}

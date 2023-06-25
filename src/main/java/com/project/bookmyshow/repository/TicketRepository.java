package com.project.bookmyshow.repository;

import com.project.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Override
    Ticket save(Ticket ticket);
}

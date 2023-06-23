package com.project.bookmyshow.service;

import com.project.bookmyshow.exception.InvalidArgumentException;
import com.project.bookmyshow.exception.SeatNotAvailableException;
import com.project.bookmyshow.models.*;
import com.project.bookmyshow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TicketService {
  private final SeatRepository seatRepository;
  private final ShowSeatRepository showSeatRepository;
  private final ShowRepository showRepository;
  private final UserRepository userRepository;
  private final TicketRepository ticketRepository;

  @Autowired
  public TicketService(SeatRepository seatRepository,
                       ShowSeatRepository showSeatRepository,
                       ShowRepository showRepository,
                       UserRepository userRepository,
                       TicketRepository ticketRepository) {
    this.seatRepository = seatRepository;
    this.showSeatRepository = showSeatRepository;
    this.showRepository = showRepository;
    this.userRepository = userRepository;
    this.ticketRepository = ticketRepository;
  }

  public Ticket bookTicket(List<Long> seatIds, Long userId, Long showId) throws InvalidArgumentException, SeatNotAvailableException {
    //1. for these seatIds, get the corresponding showSeats -- getSeatById
    //2. check if all the showSeats are available -- getShowSeatsForSeats(seatIds)
    //2.a if yes,
    //2.a.1 mark all the seats as booked(lock every seat)
    //2.a.2 create a ticket and return it
    //2.b if some of the seats are not available, throw an exception

    List<Seat> seats = seatRepository.findAllById(seatIds);
    Optional<Show> show = showRepository.findById(showId);

    if (!show.isPresent()) {
      throw new InvalidArgumentException("Show not found for show Id: " + showId);
    }
    List<ShowSeat> showSeats = showSeatRepository.findAllBySeatAndShow(seats, show.get());

    for (ShowSeat showSeat : showSeats) {
      if (!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)) {
        throw new SeatNotAvailableException();
      }
    }

    List<ShowSeat> bookedShowSeats = new ArrayList<>();
    for (ShowSeat showSeat : showSeats) {
      showSeat.setStatus(ShowSeatStatus.BOOKED);
      showSeat.setLockedAt(LocalDateTime.now());
      bookedShowSeats.add(showSeatRepository.save(showSeat));
    }

    Optional<User> user = userRepository.findById(userId);
    if (user.isEmpty()) {
      throw new InvalidArgumentException("User not found for user Id: " + userId);
    }

    Ticket ticket = new Ticket();
    ticket.setBookedBy(user.get());
    ticket.setStatus(TicketStatus.PROCESSING);
    ticket.setAmount(0);
    ticket.setShow(show.get());
    ticket.setSeats(seats);
    ticket.setTimeOfPurchase(LocalDateTime.now());

    return ticketRepository.save(ticket);
  }

}

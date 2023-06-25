package com.project.bookmyshow.controller;

import com.project.bookmyshow.dto.BookTicketRequestDto;
import com.project.bookmyshow.dto.BookTicketResponseDto;
import com.project.bookmyshow.exception.InvalidArgumentException;
import com.project.bookmyshow.exception.SeatNotAvailableException;
import com.project.bookmyshow.models.Seat;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

  private final TicketService ticketService;
  @Autowired
  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) throws InvalidArgumentException, SeatNotAvailableException {
    BookTicketResponseDto response = new BookTicketResponseDto();
    Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getSeatIds(),bookTicketRequestDto.getShowId(), bookTicketRequestDto.getUserId());
    response.setTicketId(ticket.getId());
    response.setAmount(ticket.getAmount());
    return response;
  }

}

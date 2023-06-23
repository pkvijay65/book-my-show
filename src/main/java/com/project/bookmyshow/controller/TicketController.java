package com.project.bookmyshow.controller;

import com.project.bookmyshow.dto.BookTicketRequestDto;
import com.project.bookmyshow.dto.BookTicketResponseDto;
import com.project.bookmyshow.models.Seat;
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

  public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
    return null;
  }

}

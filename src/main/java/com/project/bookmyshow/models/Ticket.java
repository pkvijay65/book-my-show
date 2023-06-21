package com.project.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel {
  private int amount;
  private LocalTime timeOfPurchase;
  private List<Seat> seats;
  private User bookedBy;
  private Show show;
  private List<Payment> payments;
  private TicketStatus status;
}

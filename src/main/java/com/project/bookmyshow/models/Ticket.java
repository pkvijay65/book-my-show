package com.project.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
  private int amount;
  private LocalDateTime timeOfPurchase;
  @ManyToMany
  private List<Seat> seats;
  @ManyToOne
  private User bookedBy;
  @ManyToOne
  private Show show;
  @OneToMany(mappedBy = "ticket")
  private List<Payment> payments;
  @Enumerated(EnumType.ORDINAL)
  private TicketStatus status;
}

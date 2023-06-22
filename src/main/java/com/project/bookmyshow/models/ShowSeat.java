package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat extends BaseModel {
  @ManyToOne
  private Show show;
  @ManyToOne
  private Seat seat;
  @Enumerated(EnumType.STRING)
  private ShowSeatStatus status;
}

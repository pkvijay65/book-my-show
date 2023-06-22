package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeatType extends BaseModel {
  @ManyToOne
  private Show show;
  @ManyToOne
  private SeatType seatType;
  private int price;
}

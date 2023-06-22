package com.project.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
  private String seatNumber;
  @Column(name = "r_number")
  private int rowNumber;
  @Column(name = "c_number")
  private int columnNumber;
  @ManyToOne
  private SeatType seatType;
}

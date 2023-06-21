package com.project.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
  private String seatNumber;
  private int rowNumber;
  private int columnNumber;
  private SeatType seatType;

}

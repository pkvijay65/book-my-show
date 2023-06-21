package com.project.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Show extends BaseModel {
  private Auditorium auditorium;
  private LocalDate startTime;
  private LocalDate endTime;

  private Movie movie;
  private Language language;
}

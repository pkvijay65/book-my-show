package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
  @ManyToOne
  private Auditorium auditorium;
  private LocalDate startTime;
  private LocalDate endTime;
  @ManyToOne
  private Movie movie;
  @Enumerated(EnumType.STRING)
  private Language language;
}

package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Auditorium extends BaseModel {
  private String name;
  @OneToMany
  private List<Seat> seats;

  /**
   * This annotation is used to specify how an enum type should be persisted in the database.
   *
   * - EnumType.STRING: the enum is persisted as a string.
   *    - Drawback of EnumType.STRING: the size of the column in the database will be larger.
   *
   * - EnumType.ORDINAL: the enum is persisted as an integer.
   *    - Drawback of EnumType.ORDINAL: if we add a new enum value in the middle of the enum,
   *      the ordinal value of all the subsequent enum values will change.
   */
  @Enumerated(EnumType.STRING)
  private List<Feature> features;
}

package com.project.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


/**
 *
 This annotation is used to indicate that ORM should not create a separate table for this class in the database.
 Instead, it should include all the fields of this class in the table of the class that extends it.
 */
@MappedSuperclass
@Getter
@Setter
public class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

}

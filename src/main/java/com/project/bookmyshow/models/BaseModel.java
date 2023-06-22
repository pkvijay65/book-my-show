package com.project.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass //this annotation is for making sure that ORM does not create a table for this class in the database
//instead put all its fields in the table of the class that extends it
public class BaseModel {
  @Id
  private Long id;

}

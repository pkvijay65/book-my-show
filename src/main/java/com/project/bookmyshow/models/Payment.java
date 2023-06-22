package com.project.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
  private int amount;
  @Enumerated(EnumType.STRING)
  private PaymentProvider paymentProvider;
  private LocalTime timeOfPayment;
  private String transactionId;
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;
  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;
  @ManyToOne
  private Ticket ticket;
}

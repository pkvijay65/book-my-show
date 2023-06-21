package com.project.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class Payment extends BaseModel {
  private int amount;
  private PaymentProvider paymentProvider;
  private LocalTime timeOfPayment;
  private PaymentStatus status;
  private PaymentType type;
}

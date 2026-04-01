package com.example.crud.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Loan {
  Long id;
  int bookId;
  int memberId;
  LocalDate loanDate;
  LocalDate returnDate;
}
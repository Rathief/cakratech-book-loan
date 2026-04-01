package com.example.crud.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Loan {
  Long id;
  Long bookId;
  Long memberId;
  LocalDate loanDate;
  LocalDate returnDate;
}
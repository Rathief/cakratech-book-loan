package com.example.crud.domain;

import java.time.LocalDate;

public class Loans {
  int id;
  int book_id;
  int member_id;
  LocalDate loan_date;
  LocalDate return_date;
}
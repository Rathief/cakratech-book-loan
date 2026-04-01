package com.example.crud.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "loans")
@Data
public class Loan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "book_id",
    nullable = false
  )
  Book book;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "member_id",
    nullable = false
  )
  Member member;

  @Column
  LocalDate loanDate;

  @Column
  LocalDate returnDate;
}
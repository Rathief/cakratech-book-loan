package com.example.crud.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "author_id",
    nullable = false
  )
  private Author author;
}

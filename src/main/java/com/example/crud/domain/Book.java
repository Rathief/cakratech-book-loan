package com.example.crud.domain;

import lombok.Data;

@Data
public class Book {
  Long id;
  String title;
  Long authorId;
}

package com.example.crud.entities;

import java.time.LocalDate;

// 3. Buat tampilan (GET) dengan struktur data (id member, email, name, title, loan_date, return_date).
public class View {
    Long id;
    String email;
    String name;
    String title;
    LocalDate loanDate;
    LocalDate returnDate;
}

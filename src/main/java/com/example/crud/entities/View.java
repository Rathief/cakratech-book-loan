package com.example.crud.entities;

import java.time.LocalDate;

import lombok.*;

// 3. Buat tampilan (GET) dengan struktur data (id member, email, name, title, loan_date, return_date).
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class View {
    Long id;
    String email;
    String name;
    String title;
    LocalDate loanDate;
    LocalDate returnDate;
}

package com.example.crud.domain;

import java.time.LocalDate;

// 3. Buat tampilan (GET) dengan struktur data (id member, email, name, title, loan_date, return_date).
public class View {
    int id;
    String email;
    String name;
    String title;
    LocalDate loan_date;
    LocalDate return_date;
}

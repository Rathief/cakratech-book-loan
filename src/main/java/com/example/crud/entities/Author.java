package com.example.crud.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor 
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(columnDefinition = "DEFAULT 'Inactive'")
    private String status;
}

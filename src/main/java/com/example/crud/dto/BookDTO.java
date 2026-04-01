package com.example.crud.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class BookDTO {
    Long id;
    String title;
    Long authorId;
}

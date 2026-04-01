package com.example.crud.dto;

import java.time.LocalDate;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class LoanDTO {
    Long id;
    Long bookId;
    Long memberId;
    LocalDate loanDate;
    LocalDate returnDate;
}

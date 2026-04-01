package com.example.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Book;
import com.example.crud.entities.Loan;
import com.example.crud.entities.Member;
import com.example.crud.entities.View;
import com.example.crud.repository.LoanRepository;
import com.example.crud.repository.MemberRepository;

@Service
public class ViewService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    public ViewService(LoanRepository loanRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    public List<View> getView(Long id) {
        // get member
        Member member = memberRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        // get loans of the member
        List<Loan> loans = loanRepository.findByMemberId(member.getId());
        // construct view
        return loans.stream().map(loan -> {
            Book book = loan.getBook();
            View v = View.builder()
                    .id(id)
                    .email(member.getEmail())
                    .name(member.getName())
                    .title(book.getTitle())
                    .loanDate(loan.getLoanDate())
                    .returnDate(loan.getReturnDate())
                    .build();
            return v;
        }).collect(Collectors.toList());
    }
}

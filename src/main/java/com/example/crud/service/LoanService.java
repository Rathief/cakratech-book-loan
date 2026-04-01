package com.example.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.crud.dto.LoanDTO;
import com.example.crud.entities.Book;
import com.example.crud.entities.Loan;
import com.example.crud.entities.Member;
import com.example.crud.repository.BookRepository;
import com.example.crud.repository.LoanRepository;
import com.example.crud.repository.MemberRepository;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    private LoanDTO toDTO(Loan loan) {
        return LoanDTO.builder()
                .id(loan.getId())
                .loanDate(loan.getLoanDate())
                .returnDate(loan.getReturnDate())
                .bookId(loan.getBook().getId())
                .memberId(loan.getMember().getId())
                .build();
    }

    // Create
    public LoanDTO createLoan(LoanDTO req) {
        Book book = bookRepository.findById(req.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(req.getMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(req.getLoanDate());
        loan.setReturnDate(req.getReturnDate());
        return toDTO(loanRepository.save(loan));
    }

    // Read all
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    // Read by ID
    public Optional<LoanDTO> getLoanById(Long id) {
        return loanRepository.findById(id)
                    .map(this::toDTO);
    }

    // Update
    public LoanDTO updateLoan(Long id, LoanDTO req) {
        Book book = bookRepository.findById(req.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(req.getMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));
        Loan res = loanRepository.findById(id)
                .map(loan -> {
                    loan.setBook(book);
                    loan.setMember(member);
                    loan.setLoanDate(req.getLoanDate());
                    loan.setReturnDate(req.getReturnDate());
                    return loanRepository.save(loan);
                })
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));
        return toDTO(res);
    }

    // Delete
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}

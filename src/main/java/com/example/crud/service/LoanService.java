package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.crud.domain.Loan;
import com.example.crud.repository.LoanRepository;

public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // Create
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // Read all
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
    
    // Read by ID
    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    // Update
    public Loan updateLoan(Long id, Loan updatedLoan) {
        return loanRepository.findById(id)
                .map(loan -> {
                    loan.setBookId(updatedLoan.getBookId());
                    loan.setMemberId(updatedLoan.getMemberId());
                    loan.setLoanDate(updatedLoan.getLoanDate());
                    loan.setReturnDate(updatedLoan.getReturnDate());
                    return loanRepository.save(loan);
                })
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));
    }

    // Delete
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}

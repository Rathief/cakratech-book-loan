package com.example.crud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.domain.Loan;
import com.example.crud.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @PostMapping
  public Loan createLoan(@RequestBody Loan loan) {
    return loanService.createLoan(loan);
  }

  @GetMapping
  public List<Loan> getAllLoans() {
    return loanService.getAllLoans();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
    return loanService.getLoanById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
      return ResponseEntity.ok(loanService.updateLoan(id, loan));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
    loanService.deleteLoan(id);
    return ResponseEntity.noContent().build();
  }
}

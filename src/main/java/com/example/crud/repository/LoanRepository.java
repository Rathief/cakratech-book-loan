package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
    List<Loan> findByMemberId(Long memberId);
}

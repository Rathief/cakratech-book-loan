package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Author;
import com.example.crud.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Create
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Read all
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    
    // Read by ID
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    // Update
    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(updatedAuthor.getName());
                    author.setAddress(updatedAuthor.getAddress());
                    author.setStatus(updatedAuthor.getStatus());
                    return authorRepository.save(author);
                })
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    // Delete
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

package com.example.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.crud.dto.BookDTO;
import com.example.crud.entities.Author;
import com.example.crud.entities.Book;
import com.example.crud.repository.AuthorRepository;
import com.example.crud.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorId(book.getAuthor().getId())
                .build();
    }

    // Create
    public BookDTO createBook(BookDTO req) {
        Author author = authorRepository.findById(req.getAuthorId())
                        .orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = new Book();
        book.setTitle(req.getTitle());
        book.setAuthor(author);
        return toDTO(bookRepository.save(book));
    }

    // Read all
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    // Read by ID
    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::toDTO);
    }

    // Update
    public BookDTO updateBook(Long id, BookDTO req) {
        Author author = authorRepository.findById(req.getAuthorId())
                        .orElseThrow(() -> new RuntimeException("Author not found"));
        Book res = bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(req.getTitle());
                    book.setAuthor(author);
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        return toDTO(res);
    }

    // Delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

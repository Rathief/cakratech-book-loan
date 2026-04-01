package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.domain.Book;
import com.example.crud.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Read all
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // Read by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthorId(updatedBook.getAuthorId());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    // Delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

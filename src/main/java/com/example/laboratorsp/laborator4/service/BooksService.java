package com.example.laboratorsp.laborator4.service;


import com.example.laboratorsp.laborator4.model.Book;
import com.example.laboratorsp.laborator4.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBookById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);
        if (existing == null) return null;
        book.setId(id);
        return booksRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        if (!booksRepository.existsById(id)) return false;
        booksRepository.deleteById(id);
        return true;
    }
}
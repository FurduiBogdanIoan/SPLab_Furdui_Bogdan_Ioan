package com.example.laboratorsp.laborator4.service;

import com.example.laboratorsp.laborator4.model.Book;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BooksService {
    private final Map<Long, Book> books = new HashMap<>();
    private long counter = 1;

    public BooksService() {
        books.put(counter, new Book(counter++, "Noapte buna, copii!", "Radu Pavel Gheo"));
        books.put(counter, new Book(counter++, "Morometii", "Marin Preda"));
        books.put(counter, new Book(counter++, "Amintiri din copilarie", "Ion Creanga"));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public Book createBook(Book book) {
        book.setId(counter++);
        books.put(book.getId(), book);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        if (!books.containsKey(id)) return null;
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}
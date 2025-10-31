package com.example.laboratorsp.laborator4.controller;


import com.example.laboratorsp.laborator4.command.*;
import com.example.laboratorsp.laborator4.model.Book;
import com.example.laboratorsp.laborator4.repository.BooksRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksRepository booksRepository;
    private final CommandExecutor executor;

    public BooksController(BooksRepository booksRepository, CommandExecutor executor) {
        this.booksRepository = booksRepository;
        this.executor = executor;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return executor.execute(new GetAllBooksCommand(new CommandContext(booksRepository)));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return executor.execute(new GetBookByIdCommand(new CommandContext(booksRepository), id));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return executor.execute(new CreateBookCommand(new CommandContext(booksRepository), book));
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return executor.execute(new UpdateBookCommand(new CommandContext(booksRepository), id, book));
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        boolean deleted = executor.execute(new DeleteBookCommand(new CommandContext(booksRepository), id));
        return deleted ? "Book deleted." : "Book not found.";
    }
}
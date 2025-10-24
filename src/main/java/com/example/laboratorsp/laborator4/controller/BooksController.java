package com.example.laboratorsp.laborator4.controller;


import com.example.laboratorsp.laborator4.command.*;
import com.example.laboratorsp.laborator4.model.Book;
import com.example.laboratorsp.laborator4.service.BooksService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor executor;

    public BooksController(BooksService booksService, CommandExecutor executor) {
        this.booksService = booksService;
        this.executor = executor;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return executor.execute(new GetAllBooksCommand(new CommandContext(booksService)));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return executor.execute(new GetBookByIdCommand(new CommandContext(booksService), id));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return executor.execute(new CreateBookCommand(new CommandContext(booksService), book));
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return executor.execute(new UpdateBookCommand(new CommandContext(booksService), id, book));
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        boolean deleted = executor.execute(new DeleteBookCommand(new CommandContext(booksService), id));
        return deleted ? "Book deleted." : "Book not found.";
    }
}
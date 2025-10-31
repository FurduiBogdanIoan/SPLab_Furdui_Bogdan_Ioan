package com.example.laboratorsp.laborator4.command;


import com.example.laboratorsp.laborator4.model.Book;

public class CreateBookCommand implements Command<Book> {
    private final CommandContext context;
    private final Book book;

    public CreateBookCommand(CommandContext context, Book book) {
        this.context = context;
        this.book = book;
    }

    @Override
    public Book execute() {
        return context.getBooksRepository().save(book);
    }
}
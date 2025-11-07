package com.example.laboratorsp.laborator4.command;

import com.example.laboratorsp.laborator4.model.Book;

public class UpdateBookCommand implements Command<Book> {
    private final CommandContext context;
    private final Long id;
    private final Book book;

    public UpdateBookCommand(CommandContext context, Long id, Book book) {
        this.context = context;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        if (!context.getBooksRepository().existsById(id)) {
            return null;
        }
        book.setId(id);
        return context.getBooksRepository().save(book);
    }
}
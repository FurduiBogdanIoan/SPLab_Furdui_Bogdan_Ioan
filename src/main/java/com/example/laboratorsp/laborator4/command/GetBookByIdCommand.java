package com.example.laboratorsp.laborator4.command;

import com.example.laboratorsp.laborator4.model.Book;

public class GetBookByIdCommand implements Command<Book> {
    private final CommandContext context;
    private final Long id;

    public GetBookByIdCommand(CommandContext context, Long id) {
        this.context = context;
        this.id = id;
    }

    @Override
    public Book execute() {
        return context.getBooksRepository().findById(id).orElse(null);
    }
}
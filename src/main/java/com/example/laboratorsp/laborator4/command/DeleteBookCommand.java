package com.example.laboratorsp.laborator4.command;

public class DeleteBookCommand implements Command<Boolean> {
    private final CommandContext context;
    private final Long id;

    public DeleteBookCommand(CommandContext context, Long id) {
        this.context = context;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return context.getBooksService().deleteBook(id);
    }
}
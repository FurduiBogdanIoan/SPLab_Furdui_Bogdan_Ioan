package com.example.laboratorsp.laborator4.command;

import com.example.laboratorsp.laborator4.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandContext {
    private BooksService booksService;
}
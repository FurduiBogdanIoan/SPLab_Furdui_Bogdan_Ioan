package com.example.laboratorsp.laborator4.command;

public interface CommandExecutor {
    <T> T execute(Command<T> command);
}
package com.example.laboratorsp.laborator7;

import com.example.laboratorsp.laborator4.model.Book;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}

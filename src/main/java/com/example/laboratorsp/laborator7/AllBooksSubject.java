package com.example.laboratorsp.laborator7;

import com.example.laboratorsp.laborator4.model.Book;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        observers.forEach(o -> o.update(book));
    }

    public void add(Book book) {
        notifyObservers(book);
    }
}
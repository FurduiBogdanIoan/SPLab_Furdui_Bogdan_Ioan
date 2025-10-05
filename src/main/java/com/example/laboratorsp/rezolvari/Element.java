package com.example.laboratorsp.rezolvari;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    protected List<Element> children = new ArrayList<>();

    public abstract void print();

    public void add(Element element) {
        children.add(element);
    }

    public void remove(Element element) {
        children.remove(element);
    }

    public Element get(int index) {
        return children.get(index);
    }
}
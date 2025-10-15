package com.example.laboratorsp.rezolvari;

public class TableOfContents implements Element {

    @Override
    public void print() {
        System.out.println("Table of contents...");
    }

    @Override
    public void add(Element element) { }

    @Override
    public void remove(Element element) { }

    @Override
    public Element get(int index) {
        return null;
    }
}
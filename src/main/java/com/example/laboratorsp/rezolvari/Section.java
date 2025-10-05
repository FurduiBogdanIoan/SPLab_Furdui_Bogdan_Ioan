package com.example.laboratorsp.rezolvari;

public class Section extends Element {
    private String title;

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element : children) {
            element.print();
        }
    }
}
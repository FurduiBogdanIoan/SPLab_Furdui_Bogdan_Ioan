package com.example.laboratorsp.rezolvari;

public class Image extends Element {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + url);
    }
}
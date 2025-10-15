package com.example.laboratorsp.rezolvari;

public class Image implements Element {
    private String url;
    private ImageContent content;

    public Image(String url) {
        this.url = url;
        this.content = new ImageContent(url);
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    @Override
    public void add(Element element) { }

    @Override
    public void remove(Element element) { }

    @Override
    public Element get(int index) {
        return null;
    }

    private static class ImageContent {
        String name;

        public ImageContent(String name) {
            this.name = name;
        }
    }
}
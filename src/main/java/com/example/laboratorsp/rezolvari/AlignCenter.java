package com.example.laboratorsp.rezolvari;

import java.io.PrintStream;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, PrintStream out) {
        out.println("Align Center: " + paragraph.getText());
    }
}
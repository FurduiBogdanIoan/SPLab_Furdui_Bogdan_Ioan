package com.example.laboratorsp.rezolvari;

import java.io.PrintStream;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, PrintStream out) {
        out.println("Align Left: " + paragraph.getText());
    }
}
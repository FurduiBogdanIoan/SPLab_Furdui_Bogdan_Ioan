package com.example.laboratorsp.rezolvari;

import java.io.PrintStream;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, PrintStream out) {
        out.println("Align Right: " + paragraph.getText());
    }
}
package com.example.javafx.model.enums;

public enum Type {
    SUM('+'), DIVISION('/'), SUBTRACTION('-'), MULTIPLICATION('*');

    private char signal;

    Type(char c) {
        this.signal = c;
    }

    public char getSignal() {
        return signal;
    }
}

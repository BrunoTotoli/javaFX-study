package com.example.javafx.model.entities;

import com.example.javafx.model.enums.Type;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TypeImp {

    public static Double arithmeticCalculation(Type type, Double number1, Double number2) {
        return switch (type) {
            case SUM -> number1 + number2;
            case DIVISION -> number1 / number2;
            case SUBTRACTION -> number1 - number2;
            case MULTIPLICATION -> number1 * number2;
        };
    }

    public static List<Type> getTypeList() {
        return List.of(Type.SUM, Type.SUBTRACTION, Type.DIVISION, Type.MULTIPLICATION);
    }

    public static String printCalculation(Type type, TextField number1, TextField number2, Label result) {
        return number1.getText() + " " + type.getSignal() + " " + number2.getText() + " = " + result.getText();
    }


}

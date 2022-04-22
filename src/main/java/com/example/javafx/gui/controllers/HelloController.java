package com.example.javafx.gui.controllers;

import com.example.javafx.gui.util.Alerts;
import com.example.javafx.gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;


    @FXML
    private Label labelResult;

    @FXML
    private Button buttonSumCalculate;

    @FXML
    protected void onButtonSumAction() {
        try {
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = number1 + number2;
            labelResult.setText(String.format("%.2f", sum));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Error", "ParseError", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1,12);
        Constraints.setTextFieldMaxLength(txtNumber2,12);
    }
}
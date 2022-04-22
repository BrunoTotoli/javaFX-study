package com.example.javafx.gui.controllers;

import com.example.javafx.gui.util.Alerts;
import com.example.javafx.gui.util.Constraints;
import com.example.javafx.model.entities.TypeImp;
import com.example.javafx.model.enums.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class HelloController implements Initializable {

    Type type = null;
    List<String> list = new ArrayList<>();
    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;


    @FXML
    private Label labelResult;

    @FXML
    private Button buttonSumCalculate;

    @FXML
    private Button buttonHistory;

    @FXML
    public void onButtonAllAction() {
        String historyString = list.stream().collect(Collectors.joining("\n"));
        Alerts.showAlert("Expression", "History", historyString.equals("") ? "No exists History" : historyString, Alert.AlertType.INFORMATION);
    }

    @FXML
    protected void onButtonSumAction() {
        try {
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = TypeImp.arithmeticCalculation(type, number1, number2);
            labelResult.setText(String.format("%.2f", sum));
            list.add(TypeImp.printCalculation(type, txtNumber1, txtNumber2, labelResult));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Error", "ParseError", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @FXML
    protected void onTypeComboBoxAction() {
        type = typeComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    private ComboBox<Type> typeComboBox;


    private ObservableList<Type> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableList = FXCollections.observableArrayList(TypeImp.getTypeList());
        typeComboBox.setItems(observableList);
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1, 12);
        Constraints.setTextFieldMaxLength(txtNumber2, 12);

    }
}
package com.example.javafx.gui.controllers;

import com.example.javafx.gui.util.Alerts;
import com.example.javafx.gui.util.Constraints;
import com.example.javafx.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private Button buttonAll;

    @FXML
    public void onButtonAllAction() {
        for (Person person : personComboBox.getItems()) {
            System.out.println(person);
        }
    }

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

    @FXML
    protected void onComboBoxPersonAction() {
        Person person = personComboBox.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @FXML
    private ComboBox<Person> personComboBox;


    private ObservableList<Person> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Maria", "maria@gmail.com"));
        list.add(new Person(1, "Marta", "marta@gmail.com"));
        list.add(new Person(1, "Marita", "marita@gmail.com"));
        list.add(new Person(1, "Marilia", "marilia@gmail.com"));
        observableList = FXCollections.observableArrayList(list);
        personComboBox.setItems(observableList);
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1, 12);
        Constraints.setTextFieldMaxLength(txtNumber2, 12);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        personComboBox.setCellFactory(factory);
        personComboBox.setButtonCell(factory.call(null));
    }
}
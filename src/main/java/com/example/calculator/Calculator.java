package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ((CalculatorController) fxmlLoader.getController()).setGlobalKeyPressed(scene);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        ((CalculatorController) fxmlLoader.getController()).getFocus();
    }

    public static void main(String[] args) {launch();}
}
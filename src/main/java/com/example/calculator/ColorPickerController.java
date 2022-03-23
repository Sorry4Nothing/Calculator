package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ColorPickerController {
    private BorderPane calcBackground;
    public ColorPickerController(BorderPane grid){
        this.calcBackground = grid;
    }
    @FXML
    private void redPressed(){
        calcBackground.setStyle("-fx-background-color: red");
    }
    @FXML
    private void greenPressed(){
        calcBackground.setStyle("-fx-background-color: green");
    }
    @FXML
    private void bluePressed(){
        calcBackground.setStyle("-fx-background-color: blue");
    }
}


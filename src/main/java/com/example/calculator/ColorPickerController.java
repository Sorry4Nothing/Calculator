package com.example.calculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ColorPickerController {

    @FXML
    private BorderPane BorderPane;

    @FXML
    public void Colorchanger() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ColorPickerController.class.getResource("colorChanger.fxml"));
        fxmlLoader.setController(new ColorPickerController(BorderPane));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Change Backgroundcolor");
        stage.setScene(scene);
        stage.show();
    }


}

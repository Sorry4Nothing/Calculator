package com.example.calculator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CalculatorController {

    public TextField txtcalc;
    public Button btnZero;
    public Button btnOne;
    public Button btnTwo;
    public Button btnThree;
    public Button btnFour;
    public Button btnFive;
    public Button btnSix;
    public Button btnSeven;
    public Button btnEight;
    public Button btnNine;
    public Button btnSqrt;
    public Button btnMinus;
    public Button btnPlus;
    public Button btnTimes;
    public Button btnDevide;
    public Button btnEqual;
    public Button btnDot;
    public BorderPane calcBackground;
    String num;
    double num1;
    double num2;
    String operator = "";
    boolean sqrtRoot = false;
    boolean secondNum = false;
    String[] splitNum;

    @FXML
    private void btnzeroclicked() {
        refreshText("0");
    }

    @FXML
    private void btnoneclicked() {
        refreshText("1");
    }

    @FXML
    private void btntwoclicked() {
        refreshText("2");
    }

    @FXML
    private void btnthreeclicked() {
        refreshText("3");
    }

    @FXML
    private void btnfourclicked() {
        refreshText("4");
    }

    @FXML
    private void btnfiveclicked() {
        refreshText("5");
    }

    @FXML
    private void btnsixclicked() {
        refreshText("6");
    }

    @FXML
    private void btnsevenclicked() {
        refreshText("7");
    }

    @FXML
    private void btneightclicked() {
        refreshText("8");
    }

    @FXML
    private void btnnineclicked() {
        refreshText("9");
    }


    @FXML
    private void btnplusclicked() {
        if (!secondNum && !Objects.equals(txtcalc.getText(), "")) {
            operator = "\\+";
            secondNum = true;
            refreshText("+");
        }
    }

    @FXML
    private void btnminusclicked() {
        if (!secondNum && !Objects.equals(txtcalc.getText(), "")) {
            operator = "\\-";
            secondNum = true;
            refreshText("-");
        }
    }

    @FXML
    private void btntimesclicked() {
        if (!secondNum && !Objects.equals(txtcalc.getText(), "")) {
            operator = "\\*";
            secondNum = true;
            refreshText("*");
        }
    }


    @FXML
    private void btndevidedclicked() {
        if (!secondNum && !Objects.equals(txtcalc.getText(), "")) {
            operator = "\\/";
            secondNum = true;
            refreshText("/");
        }
    }

    @FXML
    private void btndotclicked() {
        num = txtcalc.getText();
        if (!secondNum) {
            if (!num.contains(".") && !(num.isEmpty())) {
                refreshText(".");
            }

        } else {
            splitNum = num.split(operator, 2);
            if (!(String.valueOf(splitNum[1]).contains(".")) && !(String.valueOf(splitNum[1]).isEmpty())) {
                refreshText(".");
            }
        }
    }
    @FXML
    private void btnclearclicked() {
        num = "";
        num1 = 0.0;
        num2 = 0.0;
        operator = "";
        sqrtRoot = false;
        secondNum = false;
        txtcalc.setText("");
    }

    @FXML
    private void btnsqrtclicked() {
        try {
            if (!secondNum) {
                num = txtcalc.getText();
                txtcalc.setText(String.valueOf(Math.sqrt(Double.parseDouble(num))));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btntoggleclicked() {
        txtcalc.setText("not implemented");
    }



    public void setGlobalKeyPressed(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case NUMPAD0:
                    case DIGIT0:
                        btnZero.fire();

                        break;
                    case NUMPAD1:
                    case DIGIT1:
                        btnOne.fire();

                        break;
                    case NUMPAD2:
                    case DIGIT2:
                        btnTwo.fire();

                        break;
                    case NUMPAD3:
                    case DIGIT3:
                        btnThree.fire();

                        break;
                    case NUMPAD4:
                    case DIGIT4:
                        btnFour.fire();

                        break;
                    case NUMPAD5:
                    case DIGIT5:
                        btnFive.fire();

                        break;
                    case NUMPAD6:
                    case DIGIT6:
                        btnSix.fire();

                        break;
                    case NUMPAD7:
                    case DIGIT7:
                        btnSeven.fire();

                        break;
                    case NUMPAD8:
                    case DIGIT8:
                        btnEight.fire();

                        break;
                    case NUMPAD9:
                    case DIGIT9:
                        btnNine.fire();

                        break;
                    case ADD:
                    case PLUS:
                        btnPlus.fire();

                        break;
                    case SUBTRACT:
                    case MINUS:
                        btnMinus.fire();

                        break;
                    case MULTIPLY:
                        btnTimes.fire();

                        break;
                    case DIVIDE:
                        btnDevide.fire();

                        break;
                    case ENTER:
                        btnEqual.fire();

                        break;
                    case DECIMAL:
                    case PERIOD:
                        btnDot.fire();

                        break;

                }
                keyEvent.consume();
                btnEqual.requestFocus();

            }
        });
    }

    private void refreshText(String calc) {
        txtcalc.appendText(calc);
        btnEqual.requestFocus();

    }

    @FXML
    private void btnequalsclicked() {
        if (secondNum) {
            try {
                num = txtcalc.getText();
                splitNum = num.split(operator, 2);
                num1 = Double.parseDouble(splitNum[0]);
                num2 = Double.parseDouble(splitNum[1]);
                secondNum = false;
                sqrtRoot = false;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            switch (operator) {
                case "\\+":
                    num = String.valueOf(num1 + num2);
                    break;
                case "\\-":
                    num = String.valueOf(num1 - num2);
                    break;
                case "\\*":
                    num = String.valueOf(num1 * num2);
                    break;
                case "\\/":
                    num = String.valueOf(num1 / num2);
                    break;
            }
            txtcalc.setText(num);


        }


    }
    public void getFocus(){
        btnEqual.requestFocus();
    }
    @FXML
    private void backGroundWindow() throws IOException {
        Stage backgroundWindow = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("colorChanger.fxml"));

        fxmlLoader.setController(new ColorPickerController(calcBackground));
        Scene scene = new Scene(fxmlLoader.load());

        backgroundWindow.initModality(Modality.APPLICATION_MODAL);
        backgroundWindow.setScene(scene);
        backgroundWindow.setTitle("Background Color");
        backgroundWindow.setResizable(true);
        backgroundWindow.show();
    }
}
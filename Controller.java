package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

import java.text.DecimalFormat;

public class Controller {

    @FXML
    private Pane panel_color;

    @FXML
    private Slider slider_red;

    @FXML
    private Slider slider_green;

    @FXML
    private Slider slider_blue;

    @FXML
    private TextField txt_red;

    @FXML
    private TextField txt_green;

    @FXML
    private TextField txt_blue;

    @FXML
    private TextField txt_hex;


    @FXML
    private void initialize(){
        //System.out.println("initialize");

        // Slider RED
        slider_red.setShowTickLabels(true);
        slider_red.setShowTickMarks(true);
        slider_red.valueProperty().addListener(
                new ChangeListener<Number>() {
                   @Override
                   public void changed(ObservableValue<? extends Number> observableValue, Number number, Number valueSlider) {
                       //System.out.println("Hello slider_red");
                       txt_red.setText(String.format("%.2f", valueSlider));
                       changePanelColor();
                   }
               }
        );

        // Slider GREEN
        slider_green.setShowTickLabels(true);
        slider_green.setShowTickMarks(true);
        slider_green.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number valueSlider) {
                        //System.out.println("Hello slider_green");
                        txt_green.setText(String.format("" + valueSlider));
                        changePanelColor();
                    }
                }
        );

        // Slider BLUE
        slider_blue.setShowTickLabels(true);
        slider_blue.setShowTickMarks(true);
        slider_blue.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number valueSlider) {
                        //System.out.println("Hello slider_blue");
                        txt_blue.setText(String.format("%.2f", valueSlider));
                        changePanelColor();
                    }
                }
        );
    }

    private void changePanelColor(){

        int redValue = (int)slider_red.getValue();
        int greenValue = (int)slider_green.getValue();
        int blueValue = (int)slider_blue.getValue();

        BackgroundFill myBF = new BackgroundFill(Color.rgb(redValue,greenValue,blueValue), CornerRadii.EMPTY, Insets.EMPTY);
        panel_color.setBackground(new Background(myBF));
        txt_hex.setText(toHex(redValue, greenValue, blueValue));
    }

    // Méthodes Utils
    private static String toHex(int r, int g, int b) {
        return "#" + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
    }
    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }

}

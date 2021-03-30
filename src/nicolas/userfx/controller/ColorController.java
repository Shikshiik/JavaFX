package nicolas.userfx.controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import nicolas.userfx.model.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorController implements Initializable {

    private Color color;

    @FXML
    private Slider sliderRed;

    @FXML
    private TextField textRed;

    @FXML
    private Slider sliderGreen;

    @FXML
    private TextField textGreen;

    @FXML
    private Slider sliderBlue;

    @FXML
    private TextField textBlue;

    //int rouge;
    //int vert;
    //int bleu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sliderRed.setMin(0);
        sliderRed.setMax(255);
        sliderRed.setShowTickLabels(true);
        sliderRed.setShowTickMarks(true);
        sliderRed.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                textRed.setText(String.valueOf(Math.round((Double) newValue)));
                System.out.println("Rouge sur : " + Math.round((Double) newValue));
            }
        });
        sliderGreen.setMin(0);
        sliderGreen.setMax(255);
        sliderGreen.setShowTickLabels(true);
        sliderGreen.setShowTickMarks(true);
        sliderGreen.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                textGreen.setText(String.valueOf(Math.round((Double) newValue)));
                System.out.println("Vert sur : " + Math.round((Double) newValue));
            }
        });
        sliderBlue.setMin(0);
        sliderBlue.setMax(255);
        sliderBlue.setShowTickLabels(true);
        sliderBlue.setShowTickMarks(true);
        sliderBlue.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                textBlue.setText(String.valueOf(Math.round((Double) newValue)));
                System.out.println("Bleu sur : " + Math.round((Double) newValue));
            }
        });


        //int blue = sliderBlue.getMinorTickCount();
        //int green = sliderGreen.getMinorTickCount();

        //color = new Color(rouge, vert, bleu);
        //System.out.println(color.getRed() + " " + color.getGreen() + " " + color.getBlue());

    }
}

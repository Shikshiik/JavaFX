package nicolas.userfx.controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nicolas.userfx.model.Color;

import java.net.URL;
import java.util.Locale;
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

    @FXML
    private Pane colorView;

    @FXML
    private TextField TextHexValue;

    //int rouge;
    //int vert;
    //int bleu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        color = new Color(0, 0, 0);
        sliderAction();
        textFieldAction();
    }

    public void sliderAction() {

        sliderRed.setMin(0);
        sliderRed.setMax(255);
        sliderRed.setShowTickLabels(true);
        sliderRed.setShowTickMarks(true);
        sliderRed.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                color.setRed(newValue.intValue());
                updateColorRGB();
                updateColorView();

                textRed.setText(String.valueOf(Math.round((Double) newValue)));
                TextHexValue.textProperty().setValue(color.getHexValue());
            }
        });
        sliderGreen.setMin(0);
        sliderGreen.setMax(255);
        sliderGreen.setShowTickLabels(true);
        sliderGreen.setShowTickMarks(true);
        sliderGreen.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                color.setGreen(newValue.intValue());
                updateColorRGB();
                updateColorView();

                textGreen.setText(String.valueOf(Math.round((Double) newValue)));
                TextHexValue.textProperty().setValue(color.getHexValue());
            }
        });
        sliderBlue.setMin(0);
        sliderBlue.setMax(255);
        sliderBlue.setShowTickLabels(true);
        sliderBlue.setShowTickMarks(true);
        sliderBlue.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                color.setBlue(newValue.intValue());
                updateColorRGB();
                updateColorView();

                textBlue.setText(String.valueOf(Math.round((Double) newValue)));
                TextHexValue.textProperty().setValue(color.getHexValue());

            }
        });

        if (textRed != null && textBlue != null && textGreen != null ) {
            TextHexValue.setText(color.getHexValue());
            updateColorRGB();
            updateColorView();
        }

    }

    public void textFieldAction() {
        textRed.textProperty().addListener((observableValue, oldValue, newValue) -> {
            color.setRed(Integer.parseInt(newValue));
            updateColorRGB();
            updateColorView();
        });
        textGreen.textProperty().addListener((observableValue, oldValue, newValue) -> {
            color.setGreen(Integer.parseInt(newValue));
            updateColorRGB();
            updateColorView();
        });
        textBlue.textProperty().addListener((observableValue, oldValue, newValue) -> {
            color.setBlue(Integer.parseInt(newValue));
            updateColorRGB();
            updateColorView();
        });
        TextHexValue.textProperty().addListener((observableValue, oldValue, newValue) -> {
            color.setHexValue(newValue.toUpperCase(Locale.ROOT));
            updateColorRGB();
            updateColorView();
        });
    }


    private void updateColorView() {
        colorView.setStyle("-fx-background-color: " + color.getHexValue());
    }

    private void updateColorRGB() {
        sliderRed.setValue(color.getRed());
        sliderGreen.setValue(color.getGreen());
        sliderBlue.setValue(color.getBlue());

    }

}

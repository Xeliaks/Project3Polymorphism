package com.example.project3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

interface ClickHandler {
    void handle();
}

class CustomControl extends Pane {
    private ClickHandler clickHandler;
    private String text;
    private boolean isSelected = false;

    public CustomControl(String text) {
        setStyle("-fx-background-color: lightgrey;");
        this.text = text;
        setPrefSize(100, 100);
        Label label = new Label(text);
        label.setLayoutX(20);
        label.setLayoutY(40);
        getChildren().add(label);

        setOnMouseClicked(e -> {
            if (clickHandler != null) {
                clickHandler.handle();
            }
        });
    }

    public void setClickHandler(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    public String getText() {
        return text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        if (isSelected) {
            setStyle("-fx-background-color: red;");
        } else {
            setStyle("-fx-background-color: lightgrey;");
        }
    }
}

public class Part3 extends Application {

    private Label currentControlName;
    private List<CustomControl> selectedControls = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        currentControlName = new Label("No control selected");
        currentControlName.setFont(new Font("Arial", 24));
        currentControlName.setLayoutX(50);
        currentControlName.setLayoutY(40);
        root.getChildren().add(currentControlName);

        for (int i = 0; i < 7; i++) {
            CustomControl customControl = new CustomControl("Control" + i);
            customControl.setTranslateX(50 + i * 105);
            customControl.setTranslateY(200);

            customControl.setClickHandler(() -> {
                if (!customControl.isSelected()) {
                    customControl.setSelected(true);
                    selectedControls.add(customControl);
                } else {
                    customControl.setSelected(false);
                    selectedControls.remove(customControl);
                }
                updateLabel();
            });

            root.getChildren().add(customControl);
        }

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Custom Control Demo");
        stage.show();
    }

    private void updateLabel() {
        if (selectedControls.isEmpty()) {
            currentControlName.setText("No control selected");
        } else {
            StringBuilder labelText = new StringBuilder("Selected controls: ");
            for (CustomControl control : selectedControls) {
                labelText.append(control.getText()).append(", ");
            }
            labelText.delete(labelText.length() - 2, labelText.length()); //Deleting commas at the end
            currentControlName.setText(labelText.toString());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

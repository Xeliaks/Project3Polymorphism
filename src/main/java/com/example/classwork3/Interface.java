package com.example.classwork3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

interface ClickHandler {
    void handle();
}

class CustomControl extends Pane {
    private ClickHandler clickHandler;
    private String text;

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
}

public class Interface extends Application {

    private CustomControl currentControl;

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Label currentControlName = new Label("No control selected");
        currentControlName.setFont(new Font("Arial", 24));
        currentControlName.setLayoutX(50);
        currentControlName.setLayoutY(40);
        root.getChildren().add(currentControlName);

        for (int i = 0; i < 7; i++) {
            CustomControl customControl = new CustomControl("Control" + i);
            customControl.setTranslateX(50 + i * 105);
            customControl.setTranslateY(200);

            customControl.setClickHandler(() -> {
                customControl.setStyle("-fx-background-color: red;");
                currentControlName.setText("Selected control: " + customControl.getText());
                if (currentControl != null) {
                    currentControl.setStyle("-fx-background-color: lightgrey;");
                }
                currentControl = customControl;
            });

            root.getChildren().add(customControl);
        }

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Custom Control Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package com.example.demostracionpresentacion;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.JMetroStyleClass;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


       Label label = new Label("Hello World");
       Button button = new Button("Click me");
       label.snapPositionX(0);
       label.snapPositionY(0);
       button.snapPositionX(20);
       button.snapPositionY(20);
       VBox root = new VBox(20);

       root.getChildren().addAll(label, button);
       Scene scene = new Scene(root,400,300);
       JMetro jmetro = new JMetro(Style.LIGHT);

       root.getStyleClass().add(JMetroStyleClass.BACKGROUND);
       jmetro.setScene(scene);

       stage.setTitle("Hello World");
       stage.setScene(scene);
       stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
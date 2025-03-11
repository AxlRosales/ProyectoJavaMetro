package com.example.demostracionpresentacion;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.JMetroStyleClass;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Pantalla 1


       Label labelNombre = new Label("Nombre");
       TextField txtnombre = new TextField();
       Label lblPassword = new Label("Contraseña");
       PasswordField txtPassWord = new PasswordField();


       Button button = new Button("Saludo");
       Button BotonNuevaEscena = new Button("Nueva Pantalla");
       Button BotonSalir = new Button("Salir");


       Label lblResultado = new Label("");
       lblResultado.setStyle("-fx-font-weight: bold;");

       labelNombre.setAlignment(Pos.CENTER);

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(labelNombre,txtnombre);
        hbox1.setAlignment(Pos.CENTER);


        HBox hbox2 = new HBox(10);
        hbox2.getChildren().addAll(lblPassword,txtPassWord);
        hbox2.setAlignment(Pos.CENTER);

        HBox hbox3 = new HBox(10);
        hbox3.getChildren().addAll(button, BotonNuevaEscena,BotonSalir);
        hbox3.setAlignment(Pos.CENTER);

        HBox hbox4 = new HBox(10);
        hbox4.getChildren().addAll(lblResultado);
        hbox4.setAlignment(Pos.CENTER);


        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
        vbox.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(vbox);

        StackPane root  = new StackPane();
        root.getChildren().add(pane);
        root.setAlignment(pane, Pos.CENTER);

       Scene scene = new Scene(root,500,500);
       JMetro jmetro = new JMetro(Style.LIGHT);

       root.getStyleClass().add(JMetroStyleClass.BACKGROUND);
       jmetro.setScene(scene);

       stage.setTitle("Hello World");
       stage.setScene(scene);
       stage.show();

        button.setOnAction(event -> {
            lblResultado.setText("Hola " + txtnombre.getText());

        });

        BotonSalir.setOnAction(event -> {
            stage.close();
        });

        BotonNuevaEscena.setOnAction(event -> {
            Alert alerta  = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario o contraseña incorrectos");
            if(txtnombre.getText().isEmpty() && (txtPassWord.getText().isEmpty()))
            {
                alerta.show();
                return;

            }
            else if(!txtPassWord.getText().equals("123456")){
                alerta.show();
                return;
            }


            Stage NuevaEscena = new Stage();
            NuevaEscena.setTitle("Nueva Pantalla");

            Button btnClose = new Button("Cerrar");
            btnClose.setOnAction(actionEvent -> {
                NuevaEscena.close();
            });

            HBox hboxCerrar = new HBox(10);
            hboxCerrar.setAlignment(Pos.CENTER);

            ComboBox combo = new ComboBox();
            combo.getItems().addAll("Elemento1","Elemento2","Elemento3","Elemento4");

            hboxCerrar.getChildren().addAll(combo, btnClose);
            BorderPane pane2 = new BorderPane();
            pane2.setCenter(hboxCerrar);

            StackPane root2 = new StackPane();
            root2.getChildren().addAll(hboxCerrar);


            Scene scene2 = new Scene(root2,500,500);
            JMetro jmetro2 = new JMetro(Style.DARK);
            jmetro2.setScene(scene2);

            root2.getStyleClass().add(JMetroStyleClass.BACKGROUND);

            NuevaEscena.setScene(scene2);
            NuevaEscena.setTitle("Nueva Pantalla");
            NuevaEscena.show();






        });



        //Pantalla 2

    }

    public static void main(String[] args) {
        launch(args);
    }
}
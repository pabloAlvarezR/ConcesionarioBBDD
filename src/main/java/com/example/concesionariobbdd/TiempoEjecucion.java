package com.example.concesionariobbdd;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TiempoEjecucion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 580, 200);
        Button btnCrear = new Button("Crear");
        Button btnCancelar = new Button("Cancelar");
        TextField tfMarca = new TextField();
        TextField tfModelo = new TextField();
        TextField tfPrecio = new TextField();
        TextField tfMatricula = new TextField();
        Label lbMarca = new Label("Marca");
        Label lbModelo = new Label("Modelo");
        Label lbPrecio = new Label("Precio");
        Label lbMatricula = new Label("Matricula");
        GridPane botones = new GridPane();

        GridPane.setConstraints(lbMarca, 0,2);
        GridPane.setConstraints(lbModelo, 0,3);
        GridPane.setConstraints(lbMatricula, 0,4);
        GridPane.setConstraints(lbPrecio, 0,5);
        GridPane.setConstraints(tfMarca,1,2);
        GridPane.setConstraints(tfMatricula,1,3);
        GridPane.setConstraints(tfModelo,1,4);
        GridPane.setConstraints(tfPrecio,1,5);
        GridPane.setConstraints(botones,0,13, 2, 2);
        GridPane.setConstraints(btnCrear,0,0,2,1);
        GridPane.setConstraints(btnCancelar,2,0,2,1);

        root.setPadding(new Insets(10,30,10,30));
        botones.setPadding(new Insets(30,0,0,0));

        root.setHgap(10);
        root.setVgap(10);

        botones.setHgap(10);
        botones.setVgap(10);

        btnCrear.setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
        btnCancelar.setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);

        botones.getChildren().addAll(btnCrear,btnCancelar);
        root.getChildren().addAll(tfMarca, tfMatricula, tfModelo, tfPrecio,  lbPrecio, lbModelo, lbMarca, lbMatricula, botones);

        stage.setResizable(false);
        stage.setTitle("Añadir");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
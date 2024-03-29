package com.example.concesionariobbdd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1033, 609);
        stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
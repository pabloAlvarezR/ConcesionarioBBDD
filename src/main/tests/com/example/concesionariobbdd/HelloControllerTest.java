package com.example.concesionariobbdd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class HelloControllerTest {
    Pane mainroot;
    Stage mainstage;
    @Start
    public void start(Stage stage) throws IOException {
        mainroot = (Pane) FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        mainstage = stage;
        stage.setTitle("Hello!");
        stage.setScene(new Scene(mainroot));
        stage.show();
    }

    @Test
    void validarEscribirValorCapoTexto(FxRobot robot){
        robot.clickOn("#txtNombre");
        robot.write("Soy Alberto Contador y me gustan los cachopos");
    }
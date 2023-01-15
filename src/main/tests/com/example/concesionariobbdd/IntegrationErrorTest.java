package com.example.concesionariobbdd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class IntegrationErrorTest {
    TableView tvEliminar;
    Pane mainroot;
    Stage mainstage;

    @Start
    public void start(Stage stage) throws IOException {
        mainroot = (Pane) FXMLLoader.load(getClass().getResource("Inicio-view.fxml"));
        mainstage = stage;
        stage.setTitle("Test");
        stage.setScene(new Scene(mainroot));
        stage.show();
    }

    @Test
    void validarAñadirDatos(FxRobot robot) {
        robot.clickOn("#btnAnnadir");
        robot.sleep(1000);

        FxAssert.verifyThat(robot.window("Añadir nuevo coche"), WindowMatchers.isShowing());
        robot.clickOn("#tfCod_Coche");
        robot.write("50");
        robot.clickOn("#tfMarca");
        robot.write("TestWheels");
        robot.clickOn("#tfModelo");
        robot.write("Test");
        robot.clickOn("#tfAnnio");
        robot.write("2050");
        robot.clickOn("#tfBastidor");
        robot.write("TEST12345");
        robot.clickOn("#tfMatricula");
        robot.write("0000 XXX");
        robot.clickOn("#tfExtras");
        robot.write("Esto es una prueba de extras");

        robot.sleep(1000);
        robot.clickOn("#btnAnnadirCoche");
        robot.sleep(1000);
        robot.clickOn("Aceptar");
    }




}
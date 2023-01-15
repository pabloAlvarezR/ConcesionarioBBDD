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
class IntegrationTest {
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
        robot.clickOn("#tfPrecio");
        robot.write("500000");
        robot.clickOn("#tfMatricula");
        robot.write("0000 XXX");
        robot.clickOn("#tfExtras");
        robot.write("Esto es una prueba de extras");

        robot.sleep(1000);
        robot.clickOn("#btnAnnadirCoche");
        robot.sleep(1000);
        robot.clickOn("Aceptar");
        robot.clickOn("#btnAtras");

        TableView tableView = robot.lookup("#tvDatosInicio").queryAs(TableView.class);
        robot.clickOn("TestWheels");
        Concesionario Coche = (Concesionario) tableView.getSelectionModel().getSelectedItem();

        Assertions.assertEquals("50" ,Coche.getCod_Coche());
        Assertions.assertEquals("TestWheels" ,Coche.getMarca());
        Assertions.assertEquals("Test" ,Coche.getModelo());
        Assertions.assertEquals("2050" ,Coche.getAnio_fabricacion());
        Assertions.assertEquals("TEST12345" ,Coche.getBastidor());
        Assertions.assertEquals("500000" ,Coche.getPrecio());
        Assertions.assertEquals("0000 XXX" ,Coche.getMatricula());
        Assertions.assertEquals("Esto es una prueba de extras" ,Coche.getExtras());

    }




}
package com.example.concesionariobbdd;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

import static org.junit.jupiter.api.Assertions.*;

class BorrarDatosTest {
    @Test
    void validarBorrarDatos(FxRobot robot){
        robot.clickOn("#btnGoToEliminar");
        robot.sleep(1000);

        robot.clickOn("TestWheels");
        robot.clickOn("#btnEliminar");

        robot.sleep(1000);
        robot.clickOn("Sí");
        robot.sleep(2000);
    }
}
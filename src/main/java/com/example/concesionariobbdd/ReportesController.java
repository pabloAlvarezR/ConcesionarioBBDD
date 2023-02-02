package com.example.concesionariobbdd;

import javafx.fxml.FXML;
import net.sf.jasperreports.engine.JRException;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ReportesController {


    public void onImprimirListadoClick(javafx.event.ActionEvent actionEvent) {
        try {
            // --- Show Jasper Report on click-----
            new ReportCoches().showReportSimple();
        } catch (ClassNotFoundException | JRException | SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void onImprimirListadoPedidosCliClick(javafx.event.ActionEvent actionEvent) {
        try {
            // --- Show Jasper Report on click-----
            new ReportCoches().showReportConSubreport();
        } catch (ClassNotFoundException | JRException | SQLException e1) {
            e1.printStackTrace();
        }
    }
}

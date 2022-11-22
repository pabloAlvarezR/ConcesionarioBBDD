package com.example.concesionariobbdd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class HelloController {
    private Concesionario auxiliar;

    @FXML
    private Label welcomeText;

    public void mostrarDatos() {
       /* Dynamic TableView Data From Database
          BY Narayan G. Maharjan https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-1/
          Modificado por FDGA
        */
        ObservableList<Object> data = FXCollections.observableArrayList();
        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/noinch?useSSL=false"
                    , "adminer",
                    "adminer");
            String SQL = "SELECT * "+"FROM offices";
            ResultSet datos= c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());


            while (datos.next()){
                auxiliar = new Concesionario(
                        datos.getString("officeCode"),
                        datos.getString("city"),
                        datos.getString("phone"),
                        datos.getString("addressLine1"),
                        datos.getString("addressLine2"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());
            }

            tcOfficeCode.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("officeCode"));
            tcCity.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("city"));
            tcPhone.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("phone"));
            tcAddress1.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("addressLine1"));
            tcAddress2.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("addressLine2"));

            tvDatos.setItems(data);



        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvDatos.getColumns().clear();
            tvDatos.setItems(null);
            System.out.println("Error on Building Data");
        }
    }
    }
}
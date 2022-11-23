package com.example.concesionariobbdd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    private Concesionario auxiliar;

    @FXML
    private TableView tvCoches;

    @FXML
    private TableColumn tcCod_Coche;

    @FXML
    private TableColumn tcMarca;
    @FXML
    private TableColumn tcModelo;
    @FXML
    private TableColumn tcAnio_Fabricacion;
    @FXML
    private TableColumn tcBastidor;
    @FXML
    private TableColumn tcPrecio;
    @FXML
    private TableColumn tcMatricula;
    @FXML
    private TableColumn tcMotor;
    @FXML
    private TableColumn tcExtras;



    public void mostrarDatos() {
       /* Dynamic TableView Data From Database
          BY Narayan G. Maharjan https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-1/
          Modificado por FDGA
        */
        ObservableList<Object> data = FXCollections.observableArrayList();
        Connection c = null;
        data = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            String SQL = "SELECT * "+"FROM coches";
            ResultSet datos= c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());


            while (datos.next()){
                auxiliar = new Concesionario(
                        datos.getString("Cod_Coche"),
                        datos.getString("Marca"),
                        datos.getString("Modelo"),
                        datos.getString("año_fabricacion"),
                        datos.getString("bastidor"),
                        datos.getString("precio"),
                        datos.getString("matricula"),
                        datos.getString("motor"),
                        datos.getString("extras"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());
            }

            tcCod_Coche.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cod_Coche"));
            tcMarca.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("marca"));
            tcModelo.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("modelo"));
            tcAnio_Fabricacion.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("anio_fabricacion"));
            tcBastidor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("bastidor"));
            tcPrecio.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("precio"));
            tcMatricula.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("matricula"));
            tcMotor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("motor"));
            tcExtras.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("extras"));

            tvCoches.setItems(data);
            c.close();


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvCoches.getColumns().clear();
            tvCoches.setItems(null);

            System.out.println("Error on Building Data");
        }
    }

    private void cargarGestorDobleCLick () {
        tvCoches.setRowFactory(tv -> {
            TableRow<Concesionario> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    auxiliar.setCod_Coche(row.getItem().getCod_Coche());
                    auxiliar.setmarca(row.getItem().getMarca());
                    auxiliar.setModelo(row.getItem().getModelo());
                    auxiliar.setAnio_fabricacion(row.getItem().getAnio_fabricacion());
                    auxiliar.setBastidor(row.getItem().getBastidor());
                    auxiliar.setPrecio(row.getItem().getPrecio());
                    auxiliar.setMatricula(row.getItem().getMatricula());
                    auxiliar.setMotor(row.getItem().getMotor());
                    auxiliar.setExtras(row.getItem().getExtras());

                    tfCod_Coche.setText(auxiliar.getCod_Coche());
                    tfMarca.setText(auxiliar.getCity());
                    tfPhone.setText(auxiliar.getPhone());
                    tfAddress1.setText(auxiliar.getAddressLine1());
                    tfAddress2.setText(auxiliar.getAddressLine2());
                }
            });
            return row;
        });
    }

    @FXML
    public void initialize(){

        mostrarDatos();
    }
    }

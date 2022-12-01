package com.example.concesionariobbdd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EliminarController {
    private Concesionario auxiliar;

    @FXML
    private Button btnAnadir, btnAtras;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnMotores;
    @FXML
    private TextField tfCod_Coche;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfModelo;
    @FXML
    private TextField tfAnio_Fabricacion;
    @FXML
    private TextField tfBastidor;
    @FXML
    private TextField tfPrecio;
    @FXML
    private TextField tfMatricula;
    @FXML
    private TextField tfMotor;
    @FXML
    private TextArea tfExtras;
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

    private Text txtBindingSelecc;

    @FXML
    public void initialize(){
        cargarGestorDobleCLick();
        mostrarDatos();

    }

    public void borrarTF(){
        tfCod_Coche.clear();
    }

    public void GoToAnnadir(ActionEvent event){


        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Annadir-view.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader2.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        Stage stage2 = (Stage) this.btnAnadir.getScene().getWindow();
        stage2.close();

    }

    public void GoToInicio(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Inicio-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage stage3 = (Stage) this.btnAtras.getScene().getWindow();
            stage3.close();
        }catch (IOException E){

        }
    }

    public void GoToEditar(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Editar-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage stage4 = (Stage) this.btnEditar.getScene().getWindow();
            stage4.close();
        }catch (IOException E){

        }
    }

    public void GoToBuscar(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Buscar-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage stage5 = (Stage) this.btnBuscar.getScene().getWindow();
            stage5.close();
        }catch (IOException E){

        }
    }

    public void GoToEliminar(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Eliminar-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage stage6 = (Stage) this.btnEliminar.getScene().getWindow();
            stage6.close();
        }catch (IOException E){

        }
    }

    public void GoToMotores(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Motores-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO FRANCISCO GONZÁLEZ S. L.");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage stage7 = (Stage) this.btnMotores.getScene().getWindow();
            stage7.close();
        }catch (IOException E){

        }
    }

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
            String SQL = "SELECT * " + "FROM coches";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());


            while (datos.next()) {
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


            System.out.println("Error on Building Data");
        }
    }

    public void borrar(ActionEvent event) {
        Connection c;
        int registrosAfectadosConsulta = 0;
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estas seguro de que quieres borrar?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            try {
                // Nos conectamos
                c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                        , "root",
                        "adminer");
                String SQL = "DELETE FROM Coches "
                        + " WHERE Cod_Coche = ? ";

                PreparedStatement st = c.prepareStatement(SQL);

                st.setString(1, tfCod_Coche.getText());

                // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
                // nos devuelve el número de registros afectados. Al ser un Delete nos debe devolver 1 si se ha hecho correctamente
                registrosAfectadosConsulta = st.executeUpdate();

                mostrarDatos();
                borrarTF();
                st.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error:" + e.toString());

            }
        }
        {

        }
    }

    private void cargarGestorDobleCLick () {
        tvCoches.setRowFactory(tv -> {
            TableRow<Concesionario> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    auxiliar.setCod_Coche(row.getItem().getCod_Coche());

                    tfCod_Coche.setText(auxiliar.getCod_Coche());

                }
            });
            return row;
        });
    }
}
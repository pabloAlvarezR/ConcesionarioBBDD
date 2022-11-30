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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MotoresController {
    private Motores auxiliar;

    @FXML
    private Button btnAnadir, btnAtras, btnAnnadirMotor, btnEditarMotores;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnMotores;
    @FXML
    private TableView tvMotores;
    @FXML
    private TableColumn tcCod_Motor;
    @FXML
    private TableColumn tcPotencia;
    @FXML
    private TableColumn tcCilindrada;
    @FXML
    private TableColumn tcCilindros;
    @FXML
    private TextField tfCod_Motor, tfPotencia, tfCilindrada, tfCilindros;



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
            stage.setTitle("CONCESIONARIO");
            stage.setScene(scene);
            stage.show();

            Stage stage2 = (Stage) this.btnAnadir.getScene().getWindow();
            stage2.close();

    }

    public void GoToInicio(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Motores-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO");
            stage.setScene(scene);
            stage.show();

            Stage stage3 = (Stage) this.btnAtras.getScene().getWindow();
            stage3.close();
        }catch (IOException E){

        }
    }

    public void GoToEditar(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("EditarMot-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO");
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
            stage.setTitle("CONCESIONARIO");
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
            stage.setTitle("CONCESIONARIO");
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
            stage.setTitle("CONCESIONARIO");
            stage.setScene(scene);
            stage.show();

            Stage stage7 = (Stage) this.btnMotores.getScene().getWindow();
            stage7.close();
        }catch (IOException E){

        }
    }

    public void GoToAnnadirMot(ActionEvent event){


        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("AnnadirMot-view.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader2.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Añadir nuevo motor");
        stage.setScene(scene);
        stage.show();

        Stage stage8 = (Stage) this.btnMotores.getScene().getWindow();
        stage8.close();

    }

    public boolean Insertar(ActionEvent actionEvent) {
        Concesionario auxiliar;
        ObservableList<Object> data = FXCollections.observableArrayList();
        int registrosAfectadosConsulta = 0;
        Connection c;
        try {
            // Nos conectamos
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            String SQL = "INSERT INTO motor ("
                    + " IdMotor ,"
                    + " Potencia ,"
                    + " Cilindrada ,"
                    + " Cilindros )"
                    + " VALUES ( ?, ?, ?, ?)";

            PreparedStatement st = c.prepareStatement(SQL);

            st.setString(1, tfCod_Motor.getText());
            st.setString(2, tfPotencia.getText());
            st.setString(3, tfCilindrada.getText());
            st.setString(4, tfCilindros.getText());

            registrosAfectadosConsulta = st.executeUpdate();


            borrarTF();
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION, "Se ha añadido los datos a la tabla", ButtonType.OK);
            alert.showAndWait();


            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente

            st.close();
            c.close();

            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Motores-view.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader2.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Concesionario");
            stage.setScene(scene);
            stage.show();

            Stage stage8 = (Stage) this.btnAnnadirMotor.getScene().getWindow();
            stage8.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }

    public Boolean actualizar(ActionEvent event) {
        Connection c;
        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            String SQL = "UPDATE motor "
                    + " SET "
                    + " Potencia =? ,"
                    + " Cilindrada =? ,"
                    + " Cilindros =? "
                    + " WHERE IdMotor = ? ";

            PreparedStatement st = c.prepareStatement(SQL);

            st.setString(1, tfPotencia.getText());
            st.setString(2, tfCilindrada.getText());
            st.setString(3, tfCilindros.getText());

            st.setString(4, tfCod_Motor.getText());

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Update nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            if(tfCod_Motor.getText() == ""){
                Alert alert;
                alert = new Alert(Alert.AlertType.WARNING, "No se ha modificado ningun dato", ButtonType.OK);
                alert.showAndWait();
            }else {
                Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION, "Se han modificado los datos de la tabla", ButtonType.OK);
                alert.showAndWait();
            }
            mostrarDatos();
            borrarTF();
            st.close();
            c.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }

    public void borrar(ActionEvent event) {
        Connection c;

        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estas seguro de que quieres borrar?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            try {
                // Nos conectamos
                c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                        , "root",
                        "adminer");
                String SQL = "DELETE FROM motor "
                        + " WHERE IdMotor = ? ";
                PreparedStatement st = c.prepareStatement(SQL);

                st.setString(1, tfCod_Motor.getText());

                // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
                // nos devuelve el número de registros afectados. Al ser un Delete nos debe devolver 1 si se ha hecho correctamente
                st.executeUpdate();

                mostrarDatos();
                tfCod_Motor.clear();
                st.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error:" + e.toString());

            }
        }
    }

    private void cargarGestorDobleCLick () {
        if(tvMotores == null){

        }else{
            tvMotores.setRowFactory(tv -> {
                TableRow<Motores> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        auxiliar.setCod_Motor(row.getItem().getCod_Motor());
                        auxiliar.setPotencia(row.getItem().getPotencia());
                        auxiliar.setCilindrada(row.getItem().getCilindrada());
                        auxiliar.setCilindros(row.getItem().getCilindros());

                        tfCod_Motor.setText(auxiliar.getCod_Motor());
                        tfPotencia.setText(auxiliar.getPotencia());
                        tfCilindrada.setText(auxiliar.getCilindrada());
                        tfCilindros.setText(auxiliar.getCilindros());

                    }
                });
                return row;
            });
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
            String SQL = "SELECT * "+"FROM motor";
            ResultSet datos= c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());


            while (datos.next()){
                auxiliar = new Motores(
                        datos.getString("IdMotor"),
                        datos.getString("Potencia") + " Cv",
                        datos.getString("Cilindrada") + " cc",
                        datos.getString("Cilindros"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());
            }

            tcCod_Motor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cod_Motor"));
            tcPotencia.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Potencia"));
            tcCilindrada.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cilindrada"));
            tcCilindros.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cilindros"));


            tvMotores.setItems(data);
            c.close();


        } catch (Exception e) {
            System.out.println("Error on Building Data");
            System.out.println(e);
        }
    }

    public void borrarTF(){
        tfCod_Motor.clear();
        tfPotencia.clear();
        tfCilindros.clear();
        tfCilindrada.clear();
    }

    @FXML
    public void initialize(){
        cargarGestorDobleCLick();
        mostrarDatos();
    }
}
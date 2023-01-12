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
import java.sql.*;

public class MotoresController {
    private Motores auxiliar;

    @FXML
    private Button btnAnadir, btnAtras, btnAnnadirMotor, btnEditarMotores, btnBuscarMotores, btnBuscar, btnEditar, btnEliminar, btnMotores;
    @FXML
    private TableView tvMotores;
    @FXML
    private TableColumn tcCod_Motor,tcPotencia, tcCilindrada, tcPotencia2;
    @FXML
    private TextField tfCod_Motor, tfPotencia, tfPotencia2, tfPotenciaMin, tfPotenciaMax, tfCilindrada;


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
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Inicio-view.fxml"));
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
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Editar-view.fxml"));
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

    public void GoToEditarMot(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("EditarMot-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO");
            stage.setScene(scene);
            stage.show();

            Stage stage10 = (Stage) this.btnEditar.getScene().getWindow();
            stage10.close();
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

    }

    public void GoToBuscarMot(ActionEvent event){


        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("BuscarMot-view.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader2.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Busqueda de motores");
        stage.setScene(scene);
        stage.show();

        Stage stage8 = (Stage) this.btnBuscarMotores.getScene().getWindow();
        stage8.close();

    }

    public void GoToMotoresback(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Motores-view.fxml"));
            Parent root = null;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONCESIONARIO");
            stage.setScene(scene);
            stage.show();

            Stage stage7 = (Stage) this.btnAtras.getScene().getWindow();
            stage7.close();
        }catch (IOException E){

        }
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
            String SQL = "INSERT INTO motores ("
                    + " IdMotor ,"
                    + " Motor ,"
                    + " Potencia ,"
                    + " Cilindrada )"
                    + " VALUES ( ?, ?, ?, ?)";

            PreparedStatement st = c.prepareStatement(SQL);

            st.setString(1, tfCod_Motor.getText());
            st.setString(2, tfPotencia.getText());
            st.setString(3, tfPotencia2.getText());
            st.setString(4, tfCilindrada.getText());

            try {
                registrosAfectadosConsulta = st.executeUpdate();
                borrarTF();
                Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION, "Se ha añadido los datos a la tabla", ButtonType.OK);
                alert.showAndWait();


                // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
                // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente

                st.close();
                c.close();



                Stage stage8 = (Stage) this.btnAnnadirMotor.getScene().getWindow();
                stage8.close();




            }catch (SQLIntegrityConstraintViolationException e){
                Alert alert2;
                alert2 = new Alert(Alert.AlertType.ERROR, "No se ha encontrado el coche a añadir el motor", ButtonType.OK);
                alert2.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
        if (registrosAfectadosConsulta == 1) {
            return true;
        } else {
            return false;
        }


    }

    public boolean buscarCod_Motor(ActionEvent actionEvent) {
        ObservableList<Motores> data = null;
        try {
            Connection conexionBBDD;

            Motores auxiliar;
            data = FXCollections.observableArrayList();
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            ;
            //hacemos la consulta con los datos que queremos sacar
            String SQL = "SELECT * "
                    + "FROM motor" +
                    " where IdMotor like \"%"+tfCod_Motor.getText()+"%\"";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()){
                auxiliar = new Motores(
                        datos.getString("Coche"),
                        datos.getString("Motor"),
                        datos.getString("Potencia"),
                        datos.getString("Cilindrada"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());
            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCod_Motor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cod_Motor"));
            tcPotencia.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Potencia"));
            //sin esto no podremos mostrar nada asi que es obligatorio
            tvMotores.setItems(data);
            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvMotores.getColumns().clear();
            System.out.println(e.toString());
            tvMotores.setItems(null);
            System.out.println("Error on Building Data");

        }
        tvMotores.setItems(data);
        System.out.println(data);
        return false;
    }



    public boolean buscarPrecioMot(ActionEvent actionEvent) {
        ObservableList<Motores> data = null;
        try {
            Connection conexionBBDD;

            Motores auxiliar;
            data = FXCollections.observableArrayList();
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            ;
            if (tfPotenciaMax.getText() == ""){
                tfPotenciaMax.setText("99999");
            }
            if (tfPotenciaMin.getText() == "") {
                tfPotenciaMin.setText("0");
            }
            //hacemos la consulta con los datos que queremos sacar
            String SQL = "SELECT * "
                    + "FROM motor" +
                    " where IdMotor like \"%"+tfCod_Motor.getText()+"%\"" +
                    " and potencia BETWEEN "+tfPotenciaMin.getText()+" and "+tfPotenciaMax.getText();
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()){
                auxiliar = new Motores(
                        datos.getString("Coche"),
                        datos.getString("Motor"),
                        datos.getString("Potencia"),
                        datos.getString("Cilindrada"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());
            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCod_Motor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cod_Motor"));
            tcPotencia.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Potencia"));
            tcPotencia2.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Potencia"));
            tcCilindrada.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Potencia"));

            //sin esto no podremos mostrar nada asi que es obligatorio
            tvMotores.setItems(data);
            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvMotores.getColumns().clear();
            System.out.println(e.toString());
            tvMotores.setItems(null);
            System.out.println("Error on Building Data");

        }
        tvMotores.setItems(data);
        System.out.println(data);
        return false;
    }

    public Boolean actualizar(ActionEvent event) {
        Connection c;
        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            String SQL = "UPDATE motores "
                    + " SET "
                    + " Motor =? ,"
                    + " WHERE Coche = ? ";

            PreparedStatement st = c.prepareStatement(SQL);

            st.setString(1, tfPotencia.getText());

            st.setString(2, tfCod_Motor.getText());

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
                    if (event.getClickCount() == 1 && (!row.isEmpty())) {
                        auxiliar.setIdMotor(row.getItem().getIdMotor());
                        auxiliar.setMotor(row.getItem().getMotor());
                        auxiliar.setPotencia(row.getItem().getPotencia());
                        auxiliar.setCilindrada(row.getItem().getCilindrada());

                        tfCod_Motor.setText(auxiliar.getIdMotor());
                        tfPotencia.setText(auxiliar.getMotor());


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
            String SQL = "SELECT * "+"FROM motores";
            ResultSet datos= c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());


            while (datos.next()){
                auxiliar = new Motores(
                        datos.getString("IdMotor"),
                        datos.getString("Motor"),
                        datos.getString("Potencia"),
                        datos.getString("Cilindrada"));

                data.add(auxiliar);
                System.out.println(auxiliar.toString());
            }

            tcCod_Motor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("IdMotor"));
            tcPotencia.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Motor"));
            tcPotencia2.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Potencia"));
            tcCilindrada.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cilindrada"));


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
        tfPotencia.clear();
        tfCilindrada.clear();
    }

    @FXML
    public void initialize(){
        cargarGestorDobleCLick();
        mostrarDatos();
    }
}
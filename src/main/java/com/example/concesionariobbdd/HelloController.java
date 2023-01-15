package com.example.concesionariobbdd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
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
    private TextField tfCod_Coche , tfPrecioMax, tfPrecioMin;
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
    private TableColumn tcExtras;

    public void borrarTF(){
        tfCod_Coche.clear();
        tfMarca.clear();
        tfModelo.clear();
        tfAnio_Fabricacion.clear();
        tfBastidor.clear();
        tfPrecio.clear();
        tfMatricula.clear();
        tfExtras.clear();
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
        stage.setTitle("Añadir nuevo coche");
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
            tcExtras.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("extras"));

            tvCoches.setItems(data);
            c.close();


        } catch (Exception e) {


            System.out.println("Error on Building Data");
        }
    }

    /*private void cargarGestorDobleCLick () {
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


                }
            });
            return row;
        });
    }*/

    public boolean buscarCod_Coche(ActionEvent actionEvent) {
        ObservableList<Concesionario> data = null;
        try {
            Connection conexionBBDD;

            Concesionario auxiliar;
            data = FXCollections.observableArrayList();
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            ;
            //hacemos la consulta con los datos que queremos sacar
            String SQL = "SELECT * " + "FROM coches where Cod_Coche like \"%"+tfCod_Coche.getText()+"%\"";
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
                while (datos.next()){
                    auxiliar = new Concesionario(
                            datos.getString("Cod_Coche"),
                            datos.getString("Marca"),
                            datos.getString("Modelo"),
                            datos.getString("año_fabricacion"),
                            datos.getString("bastidor"),
                            datos.getString("precio"),
                            datos.getString("matricula"),
                            datos.getString("extras"));


                data.add(auxiliar);
                //System.out.println(auxiliar.toString());
            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCod_Coche.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cod_Coche"));
            tcMarca.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("marca"));
            tcModelo.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("modelo"));
            tcAnio_Fabricacion.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("anio_fabricacion"));
            tcBastidor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("bastidor"));
            tcPrecio.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("precio"));
            tcMatricula.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("matricula"));
            tcExtras.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("extras"));
            //sin esto no podremos mostrar nada asi que es obligatorio
            tvCoches.setItems(data);
            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvCoches.getColumns().clear();
            System.out.println(e.toString());
            tvCoches.setItems(null);
            System.out.println("Error on Building Data");

        }
        tvCoches.setItems(data);
        System.out.println(data);
        return false;
    }

    public boolean buscarPrecio(ActionEvent actionEvent) {
        ObservableList<Concesionario> data = null;
        try {
            Connection conexionBBDD;

            Concesionario auxiliar;
            data = FXCollections.observableArrayList();
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                    , "root",
                    "adminer");
            ;
            if (tfPrecioMax.getText() == ""){
                tfPrecioMax.setText("10000000");
            }
            if (tfPrecioMin.getText() == "") {
                tfPrecioMin.setText("0");
            }
            //hacemos la consulta con los datos que queremos sacar
            String SQL = "SELECT * "
                    + "FROM coches" +
                    " where Cod_Coche like \"%"+tfCod_Coche.getText()+"%\"" +
                    " and precio BETWEEN "+tfPrecioMin.getText()+" and "+tfPrecioMax.getText();
            ResultSet datos = c.createStatement().executeQuery(SQL);
            System.out.println(datos.toString());

            //esto nos da unos datos pero tenemos que mostrarlo en la tabla
            //de esta forma los mostramos en la tabla
            while (datos.next()){
                auxiliar = new Concesionario(
                        datos.getString("Cod_Coche"),
                        datos.getString("Marca"),
                        datos.getString("Modelo"),
                        datos.getString("año_fabricacion"),
                        datos.getString("bastidor"),
                        datos.getString("precio"),
                        datos.getString("matricula"),
                        datos.getString("extras"));


                data.add(auxiliar);
                //System.out.println(auxiliar.toString());
            }
            //esto es para poner los datos en la tabla para ello simplemnete le ponemos que en el id de cada columna de la tabla le aplique
            //su dato es decir para oficina pues el codigo que tenemos en el array  y asi con cada dato
            tcCod_Coche.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("Cod_Coche"));
            tcMarca.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("marca"));
            tcModelo.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("modelo"));
            tcAnio_Fabricacion.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("anio_fabricacion"));
            tcBastidor.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("bastidor"));
            tcPrecio.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("precio"));
            tcMatricula.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("matricula"));
            tcExtras.setCellValueFactory(new PropertyValueFactory<Concesionario, String>("extras"));
            //sin esto no podremos mostrar nada asi que es obligatorio
            tvCoches.setItems(data);
            //proximo paso insertar datos
            //para ello debemos volver a conectar a la base de datos


        } catch (Exception e) {
            e.printStackTrace();
            data.removeAll();
            tvCoches.getColumns().clear();
            System.out.println(e.toString());
            tvCoches.setItems(null);
            System.out.println("Error on Building Data");

        }
        tvCoches.setItems(data);
        System.out.println(data);
        return false;
    }

    public boolean Insertar(ActionEvent actionEvent) {
        Concesionario auxiliar;
        ObservableList<Object> data = FXCollections.observableArrayList();
        int registrosAfectadosConsulta = 0;
        Connection c;

        if (tfPrecio.getText().isBlank()) {
            Alert alert2;
            alert2 = new Alert(Alert.AlertType.ERROR, "El coche debe tener un precio", ButtonType.OK);
            alert2.showAndWait();
        }else{
            try {
                // Nos conectamos
                c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false"
                        , "root",
                        "adminer");
                String SQL = "INSERT INTO Coches ("
                        + " Cod_coche ,"
                        + " Marca ,"
                        + " Modelo ,"
                        + " Año_Fabricacion ,"
                        + " Bastidor ,"
                        + " Precio ,"
                        + " Matricula ,"
                        + " Extras )"
                        + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement st = c.prepareStatement(SQL);



                st.setString(1, tfCod_Coche.getText());
                st.setString(2, tfMarca.getText());
                st.setString(3, tfModelo.getText());
                st.setString(4, tfAnio_Fabricacion.getText());
                st.setString(5, tfBastidor.getText());
                st.setString(6, tfPrecio.getText());
                st.setString(7, tfMatricula.getText());
                st.setString(8, tfExtras.getText());



                registrosAfectadosConsulta = st.executeUpdate();


                borrarTF();
                Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION, "Se ha añadido los datos a la tabla", ButtonType.OK);
                alert.showAndWait();

                // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
                // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente

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
            }
        }
        return false;
    }



    public void Coche(Event event) {
        TiempoEjecucion coche = new TiempoEjecucion();
        Stage stage = new Stage();
        try {
            coche.start(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize(){
        mostrarDatos();
    }
}
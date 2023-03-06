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

/**
 * Controlador de la ventana principal del programa, encargado de manejar la interfaz gráfica
 * y gestionar los eventos del usuario.
 */
public class HelloController {

    /**
     * Concesionario auxiliar utilizado para realizar operaciones sobre los datos del concesionario.
     */
    private Concesionario auxiliar;

    /**
     * Botón para añadir un nuevo coche.
     */
    @FXML
    private Button btnAnadir;

    /**
     * Botón para volver a la pantalla principal.
     */
    @FXML
    private Button btnAtras;

    /**
     * Botón para abrir la ventana de búsqueda.
     */
    @FXML
    private Button btnBuscar;

    /**
     * Botón para abrir la ventana de edición.
     */
    @FXML
    private Button btnEditar;

    /**
     * Botón para eliminar un coche.
     */
    @FXML
    private Button btnEliminar;

    /**
     * Botón para abrir la ventana de motores.
     */
    @FXML
    private Button btnMotores, btnReporte;

    /**
     * Campo de texto para introducir el código del coche.
     */
    @FXML
    private TextField tfCod_Coche;

    /**
     * Campo de texto para introducir el precio máximo.
     */
    @FXML
    private TextField tfPrecioMax;

    /**
     * Campo de texto para introducir el precio mínimo.
     */
    @FXML
    private TextField tfPrecioMin;

    /**
     * Campo de texto para introducir la marca del coche.
     */
    @FXML
    private TextField tfMarca;

    /**
     * Campo de texto para introducir el modelo del coche.
     */
    @FXML
    private TextField tfModelo;

    /**
     * Campo de texto para introducir el año de fabricación del coche.
     */
    @FXML
    private TextField tfAnio_Fabricacion;

    /**
     * Campo de texto para introducir el número de bastidor del coche.
     */
    @FXML
    private TextField tfBastidor;

    /**
     * Campo de texto para introducir el precio del coche.
     */
    @FXML
    private TextField tfPrecio;

    /**
     * Campo de texto para introducir la matrícula del coche.
     */
    @FXML
    private TextField tfMatricula;

    /**
     * Área de texto para introducir extras del coche.
     */
    @FXML
    private TextArea tfExtras;

    /**
     * Tabla que muestra los coches disponibles.
     */
    @FXML
    private TableView tvCoches;

    /**
     * Columna que muestra el código del coche.
     */
    @FXML
    private TableColumn tcCod_Coche;

    /**
     * Columna que muestra la marca del coche.
     */
    @FXML
    private TableColumn tcMarca;

    /**
     * Columna que muestra el modelo del coche.
     */
    @FXML
    private TableColumn tcModelo;

    /**
     * Columna que muestra el año de fabricación del coche.
     */
    @FXML
    private TableColumn tcAnio_Fabricacion;

    /**
     * Columna que muestra el número de bastidor del coche.
     */
    @FXML
    private TableColumn tcBastidor;

    /**
     * Columna que muestra el precio del coche.
     */
    @FXML
    private TableColumn tcPrecio;

    /**
     * Columna que muestra la matrícula del coche.
     */
    @FXML
    private TableColumn tcMatricula;

    /**
     * TableColumn para mostrar los extras de cada coche en la tabla
     */
    @FXML
    private TableColumn tcExtras;
    /**
     *  Función para borrar el contenido de los campos de texto
     */
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
    /**
     * Función para cambiar a la vista de añadir un nuevo coche
     */
    public void GoToAnnadir(){ //
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Annadir-view.fxml"));
        Parent root;
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
        stage.show(); // Muestra la nueva ventana para añadir un coche

        Stage stage2 = (Stage) this.btnAnadir.getScene().getWindow();
        stage2.close(); // Cierra la ventana actual

    }

    public void GoToInicio(){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Inicio-view.fxml"));
            Parent root;
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

    public void GoToEditar(){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Editar-view.fxml"));
            Parent root;
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

    public void GoToBuscar(){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Buscar-view.fxml"));
            Parent root;
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

    public void GoToEliminar(){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Eliminar-view.fxml"));
            Parent root;
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

    public void GoToMotores(){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Motores-view.fxml"));
            Parent root;
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

    public void GoToReportes(){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Reports-view.fxml"));
            Parent root;
            root = fxmlLoader2.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Selector de reportes");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            Stage stage7 = (Stage) this.btnReporte.getScene().getWindow();
        }catch (IOException E){
            System.out.println("No ha habierto reportes, error");
        }
    }

    public void mostrarDatos() {

        ObservableList<Object> data;
        Connection c;
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

    public boolean buscarCod_Coche() {
        ObservableList<Concesionario> data = null;
        try {

            Concesionario auxiliar;
            data = FXCollections.observableArrayList();
            Connection c;
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

            Concesionario auxiliar;
            data = FXCollections.observableArrayList();
            Connection c;
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
            }

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

    public boolean Insertar() {
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
                System.out.println("Error:" + e);
            }
        }
        return false;
    }

    @FXML
    public void initialize(){
        mostrarDatos();
    }
}
package com.example.concesionariobbdd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ApplicationExtension.class)
class UnitaryDeleteTest {



    @Test
    @Order(1)
    void testUnitarioEliminar() throws SQLException {

        final String servidor = "jdbc:mariadb://localhost:5555/Concesionario?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        Connection conn;
        conn = DriverManager.getConnection(servidor, usuario, passwd);
        try {

            conn = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "DELETE FROM coches "
                    + " WHERE Cod_coche = '1212' ";

            PreparedStatement st = conn.prepareStatement(SQL);

            st.executeUpdate();

            st.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());

        }
    }

    @Test
    @Order(2)
    void testComprobarEliminar() {
        ObservableList<Concesionario> resultadoConsulta = FXCollections.observableArrayList();
        final String servidor = "jdbc:mariadb://localhost:5555/Concesionario?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectados = 0;
        Connection conn;


        try {
            conn = DriverManager.getConnection(servidor, usuario, passwd);

            String SQL = "SELECT * "
                    + "FROM coches "
                    + "WHERE Cod_coche ='1212'";


            ResultSet Consulta = conn.createStatement().executeQuery(SQL);
            PreparedStatement st = conn.prepareStatement(SQL);

            while (Consulta.next()) {

                Concesionario c = new Concesionario(
                        Consulta.getString("Cod_coche"),
                        Consulta.getString("Marca"),
                        Consulta.getString("Modelo"),
                        Consulta.getString("Año_Fabricacion"),
                        Consulta.getString("Bastidor"),
                        Consulta.getString("Precio"),
                        Consulta.getString("Matricula"),
                        Consulta.getString("Extras")
                );

                resultadoConsulta.add(c);
                registrosAfectados++;
                System.out.println(c.toString());

            }
            ResultSet resultadoConsulta2 = conn.createStatement().executeQuery(SQL);
            if(registrosAfectados == 0){
                System.out.println("Tupla eliminada correctamente");


            }else {
                assert false:"La tupla no se ha eliminado";
            }

        }catch (SQLException e){
            System.out.println("Error de datos");
        }
    }
}
package com.example.concesionariobbdd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ApplicationExtension.class)
class UnitaryAddTest {
    public ObservableList<Concesionario> resultadoConsulta;
    @Test
    @Order(1)
    void testAñadirDatos() throws SQLException {
        final String servidor = "jdbc:mariadb://localhost:5555/Concesionario?useSSL=false";
        final String usuario = "root";
        final String passwd = "adminer";
        int registrosAfectadosConsulta = 0;
        Connection conexionBBDD;
        conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
        Concesionario auxiliar;
        ObservableList<Object> data = FXCollections.observableArrayList();
        Connection c;

            // Nos conectamos
            c = DriverManager.getConnection("jdbc:mariadb://localhost:5555/Concesionario?useSSL=false", usuario, passwd);
            String SQL = "INSERT INTO coches ("
                    + " Cod_coche ,"
                    + " Marca ,"
                    + " Modelo ,"
                    + " Año_Fabricacion ,"
                    + " Bastidor ,"
                    + " Precio ,"
                    + " Matricula ,"
                    + " Extras )"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

             PreparedStatement st = null;

        try {
            st = conexionBBDD.prepareStatement(SQL);

            st.setInt(1, Integer.parseInt("1212"));
            st.setString(2, "UnitaryTest");
            st.setString(3, "UnitaryTest");
            st.setInt(4, Integer.parseInt("2001"));
            st.setString(5, "UnitaryTest");
            st.setInt(6, Integer.parseInt("1000"));
            st.setString(7, "0000 XXX");
            st.setString(8, "UnitaryTest");

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente

            st.executeUpdate();
            st.close();
            conexionBBDD.close();

            System.out.println("Datos añadidos correctamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
        }
    }

    @Test
    @Order(2)
    void testComprobarDatos() {

        this.resultadoConsulta = FXCollections.observableArrayList();
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
            ResultSet consulta = conn.createStatement().executeQuery(SQL);
            if(consulta.next()){
                System.out.println("Registros afectados: "+registrosAfectados);

            }else {
                assert false:"No tiene datos";
            }

        }catch (SQLException e){
            System.out.println("Error: Tupla no encontrada, asegurate de que exista");
        }
    }
}
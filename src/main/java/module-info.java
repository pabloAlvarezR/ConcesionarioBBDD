module com.example.concesionariobbdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.concesionariobbdd to javafx.fxml;
    exports com.example.concesionariobbdd;
}
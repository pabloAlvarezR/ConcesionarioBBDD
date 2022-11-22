package com.example.concesionariobbdd;

public class Concesionario {
    String Cod_Coche;
    String marca;
    String modelo;
    String anio_fabricacion;
    String bastidor;
    String precio;
    String matricula;
    String motor;
    String extras;


    @Override
    public String toString() {
        return "coches{" +
                "cod_coche='" + Cod_Coche + '\'' +
                ", marca='" + marca + '\'' +
                ", anio_fabricacion='" + anio_fabricacion + '\'' +
                ", bastidor='" + bastidor + '\'' +
                ", precio='" + precio + '\'' +
                ", matricula='" + matricula + '\'' +
                ", motor='" + motor + '\'' +
                ", extras='" + extras + '\'' +
                '}';
    }

    public void setCod_Coche(String cod_Coche) {
        this.Cod_Coche = cod_Coche;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio_fabricacion(String anio_fabricacion) {
        this.anio_fabricacion = addressLine1;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getCod_Coche() {
        return Cod_Coche;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnio_fabricacion() {
        return anio_fabricacion;
    }

    public String getBastidor() {
        return bastidor;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecio() {
        return precio;
    }



    String phone;
    String addressLine1;
    String addressLine2;

    public Concesionario(String officeCode, String city, String phone, String addressLine1, String addressLine2) {
        this.Cod_Coche = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }
}

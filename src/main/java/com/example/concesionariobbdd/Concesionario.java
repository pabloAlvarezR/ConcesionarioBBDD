package com.example.concesionariobbdd;

public class Concesionario {
    String Cod_Coche;
    String marca;
    String modelo;
    String anio_fabricacion;
    String bastidor;
    String precio;
    String matricula;
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
        this.anio_fabricacion = anio_fabricacion;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setExtras(String extras) {
        this.extras = extras;
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

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getExtras() {
        return extras;
    }


    public Concesionario(String Cod_Coche, String marca, String modelo, String anio_fabricacion, String bastidor, String precio, String matricula, String extras) {
        this.Cod_Coche = Cod_Coche;
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.bastidor = bastidor;
        this.precio = precio;
        this.matricula = matricula;
        this.extras = extras;
    }
}

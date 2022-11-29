package com.example.concesionariobbdd;

public class Motores {
    String Cod_Motor;
    String Potencia;
    String Cilindrada;
    String Cilindros;


    @Override
    public String toString() {
        return "Motores{" +
                "cod_Motor='" + Cod_Motor + '\'' +
                ", Potencia='" + Potencia + '\'' +
                ", Cilindrada='" + Cilindrada + '\'' +
                ", Cilindros='" + Cilindros + '\'' +
                '}';
    }

    public void setCod_Motor(String cod_Motor) {
        this.Cod_Motor = cod_Motor;
    }

    public void setPotencia(String Potencia) {
        this.Potencia = Potencia;
    }

    public void setCilindrada(String Cilindrada) {
        this.Cilindros = Cilindrada;
    }

    public void setCilindros(String Cilindros) {
        this.Cilindros = Cilindros;
    }


    public String getCod_Motor() {
        return Cod_Motor;
    }

    public String getPotencia() {
        return Potencia;
    }

    public String getCilindrada() {
        return Cilindrada;
    }

    public String getCilindros() {
        return Cilindros;
    }

    public Motores(String Cod_Motores, String Potencia, String Cilindrada, String Cilindros) {
        this.Cod_Motor = Cod_Motores;
        this.Potencia = Potencia;
        this.Cilindros = Cilindros;
        this.Cilindrada = Cilindrada;

    }
}

package com.example.concesionariobbdd;

public class Motores {
    String IdMotor;
    String Motor;
    String Potencia;
    String Cilindrada;


    @Override
    public String toString() {
        return "Motores{" +
                "IdMotor='" + IdMotor + '\''+
                ", Motor ='" + Motor + '\'' +
                ", Potencia ='" + Potencia +" Cv"+ '\'' +
                ", Cilindrada ='" + Cilindrada +" cc"+ '\'' +
                '}';
    }

    public void setIdMotor(String idMotor) {
        this.IdMotor = idMotor;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }
    public void setPotencia(String Potencia) {
        this.Potencia = Potencia;
    }
    public void setCilindrada(String Cilindrada) {
        this.Cilindrada = Cilindrada;
    }




    public String getIdMotor() {
        return IdMotor;
    }

    public String getMotor() {return Motor;}

    public String getPotencia() {
        return Potencia;
    }

    public String getCilindrada() {
        return Cilindrada;
    }



    public Motores(String IdMotor, String Motor, String Potencia, String Cilindrada) {
        this.IdMotor = IdMotor;
        this.Motor = Motor;
        this.Potencia = Potencia;
        this.Cilindrada = Cilindrada;



    }
}
